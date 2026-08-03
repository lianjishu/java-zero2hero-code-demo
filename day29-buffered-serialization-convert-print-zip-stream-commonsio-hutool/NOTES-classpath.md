# day29 classpath 笔记 — 摸清底层原理用

> 目的:记录 day29 模块当前 classpath 的"真实状态",理解 IDEA / mvn / javac 三条路分别怎么找类。
> 适用人群:作者本人(后续回看)、同模块协作者(理解为什么不写 pom)。

---

## 1. 模块当前依赖了哪些第三方 jar

```
day29-buffered-serialization-convert-print-zip-stream-commonsio-hutool/lib/
├── hutool-all-5.8.47.jar     cn.hutool.*  (FileUtil / IoUtil / 等等)
└── commons-io-2.22.0.jar     org.apache.commons.io.*
```

两个 jar 都是**手动下载放到 `lib/` 下**,不在 Maven 仓库里。
也没有写进 `pom.xml` —— 这是当前**有意为之**的状态(见 §5)。

---

## 2. 三条路的 classpath 长什么样

### 2.1 Maven 编译(mvn compile)

```
day29-buffered-serialization-convert-print-zip-stream-commonsio-hutool/target/classes
```

**只有 `target/classes` 一个条目**。hutool / commons-io 不在 classpath 里,所以源码里写
`cn.hutool.core.io.FileUtil` 会编译失败。这是当前的事实 —— `mvn compile` 跑不过。

### 2.2 IDEA 直接 Run(右键 → Run 'TasteHutoolFileUtil.main()')

从 IDEA 的 Run Configuration 反推出完整 classpath:

```
E:\...\day29-buffered-serialization-convert-print-zip-stream-commonsio-hutool\target\classes
E:\...\day29-buffered-serialization-convert-print-zip-stream-commonsio-hutool\lib\hutool-all-5.8.47.jar
E:\...\day29-buffered-serialization-convert-print-zip-stream-commonsio-hutool\lib\commons-io-2.22.0.jar
```

IDEA 是从 `.iml` / 项目配置里读到这两个 jar,自动加到 Run 的 `-classpath` 里。
所以 IDEA 能跑,mvn 不能跑 —— **同一个人、同一个项目、不同的工具,classpath 居然不一样**。

### 2.3 手动命令行模拟 IDEA 当前状态

> 不靠 IDEA、不靠 mvn,只靠 `java` 命令行,看 -cp 到底起什么作用。

Windows(Git Bash / PowerShell 都行):

```bash
java -cp "target/classes;lib/hutool-all-5.8.47.jar;lib/commons-io-2.22.0.jar" tastelib.hutool.TasteHutoolFileUtil
```

Linux / macOS:

```bash
java -cp "target/classes:lib/hutool-all-5.8.47.jar:lib/commons-io-2.22.0.jar" tastelib.hutool.TasteHutoolFileUtil
```

注意三点:
1. 分隔符:Windows `;`,Unix `:`(这是历史遗留,和 PATH 一样)
2. `-cp` 必须在**类名**之前
3. `tastelib.hutool.TasteHutoolFileUtil` 是**全限定类名**,不是文件路径,不写 `.class`

如果这一步能跑通、`mvn compile` 还是挂,就能确证:**挂的是编译期 classpath,跟运行时无关**。

---

## 3. 编译期 vs 运行期 classpath 是同一套吗?

**是的。** `javac` 和 `java` 都用 `-cp`(或隐式),遵循同一套寻类规则。

区别只在**谁决定 classpath**:

| 阶段 | 工具 | classpath 由谁决定 | 怎么指定 |
|---|---|---|---|
| 编译 | javac / mvn | Maven(pom.xml) | pom dependencies / javac -cp |
| 运行 | java / IDEA Run | IDEA 项目配置 / 命令行 | .iml / -cp / pom 传递 |

Maven 的 `mvn compile` 失败,根因是 javac 拿到一个**不含 hutool 的 classpath**,根本进不去编译阶段。

---

## 4. 摸底层原理的四层(进度标记)

| 层 | 内容 | 状态 |
|---|---|---|
| L1 | IDEA "add as library" 不报红 → 因为 .iml 加了 jar | ✓ |
| L2 | IDEA Run Configuration 的完整 `-classpath` 内容 | ✓(见 §2.2) |
| L3 | javac 编译期 classpath 与 java 运行期 classpath 的关系 | ✓(见 §3) |
| L4 | Maven scope / 传递依赖 / 仓库解析 | 部分摸(见 §5) |

---

## 5. pom.xml 的现状(2026-08-02 改后)

摸完 L1~L3 后改了 pom,改之前/之后的取舍记在这里:

### 改动前的取舍(已完成历史)
- 摸 L1~L3 阶段保留 pom 不写,是为了不被"声明之后看起来就是对的"蒙蔽,亲手拼 -cp 才能看清来源
- 等过渡完再升级 pom

### 改后的当前方案:system scope
pom 里加了两个依赖:

```xml
<dependency>
    <groupId>cn.hutool</groupId><artifactId>hutool-all</artifactId>
    <version>5.8.47</version>
    <scope>system</scope>
    <systemPath>${project.basedir}/lib/hutool-all-5.8.47.jar</systemPath>
</dependency>
<dependency>
    <groupId>commons-io</groupId><artifactId>commons-io</artifactId>
    <version>2.22.0</version>
    <scope>system</scope>
    <systemPath>${project.basedir}/lib/commons-io-2.22.0.jar</systemPath>
</dependency>
```

`mvn compile` 现在跑通 (BUILD SUCCESS)。

### 摸到的 system scope 三个坑

1. **Maven WARNING**:`systemPath should not point at files within the project directory` — Maven 不推荐指项目内文件,警告"未来版本可能不支持"。当前 BUILD SUCCESS,但写法不"标准"。
2. **跨模块失效**:这个写法对本模块可用,别的模块依赖本模块时会找不到 jar(因为 system scope 不可传递、不进本地仓库)。
3. **scope 对比**:这次算是把 L4 的 `system` scope 摸到一半了 —— 后续如果要严格规范,得用 `mvn install:install-file` 把 jar 装到本地仓库,然后改 `compile` scope,WARNING 自然消失。

### 为什么这次没直接上 install-file 路线
- 教学项目,单模块,没有跨模块依赖场景,WARNING 在当前无伤大雅
- system scope 是过渡态,留作 L4 的"已知未完工"标记,以后回看能看出"为什么当时这么选"

---

## 6. 附录:IDEA Run Configuration 原始命令(存档)

```text
"C:\Java\jdk-21\bin\java.exe" \
  "-javaagent:C:\Program Files\JetBrains\IntelliJ IDEA 2026.1.1\lib\idea_rt.jar=14602" \
  -Dfile.encoding=UTF-8 -Dsun.stdout.encoding=UTF-8 -Dsun.stderr.encoding=UTF-8 \
  -classpath "E:\...\day29-...\target\classes;E:\...\day29-...\lib\hutool-all-5.8.47.jar;E:\...\day29-...\lib\commons-io-2.22.0.jar" \
  tastelib.hutool.TasteHutoolFileUtil
```

关键三部分:
1. `-javaagent:...idea_rt.jar=14602` — IDEA 的运行时探针,跟 classpath 无关
2. `-Dfile.encoding=UTF-8 ...` — 系统属性,跟 classpath 无关
3. `-classpath "...;...;..."` — **就是 L2 的真相**

去掉第 1、2 行,就是纯 `java -cp` 命令,跟 §2.3 等价。