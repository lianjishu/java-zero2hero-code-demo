# 调整项目结构:扁平化 Java 包名为 `io.github.lianjishu`

## Context

当前 28 个子模块里,day01–day22、day33 的代码都包了一层 `io.github.lianjishu.<子模块名>`(如 `io.github.lianjishu.Day18_API_Basics_ObjectClone`),而 day31 / day32 下的 6 个子模块则完全没有 `io.github.lianjishu` 前缀,有的用默认包(`multiproducer-and-multiconsumer`),有的用 `implement1` / `TransferTaskDemo` 这种临时子包,整体命名风格不统一,新建模块时还要纠结"子模块名"该写什么。

目标:把所有 Java 源代码统一进 `io.github.lianjishu` 一层(顶层只此一段),让 day01–day22 + day33 直接挂在这一层下(扁平化),让 day31/32 在保留各自业务子包(`implement1`、`ComprehensivePracticalExercises` 等)的前提下补上 `io.github.lianjishu.` 前缀,顺手把 day14 残留拼写错误 `Day14_OOP_Plus_Comprehensive_Exercis` 改回 `Day14_OOP_Plus_Comprehensive_Exercise`,并更新 README 里的目录树示例。

## 范围(已通过 AskUserQuestion 与用户确认)

- ✅ 拼写使用 `lianjishu`(不是 `lianjihsu`),与 root pom groupId 一致
- ✅ day31 / day32 一并加 `io.github.lianjishu` 前缀
- ✅ 顺带修 day14 拼写错误 + 更新 README
- ❌ `day21-api-algo-lambda` 无源码,跳过

## 根因 / 关键事实

- root `pom.xml` 的 `<groupId>` 已经是 `io.github.lianjishu`,不需要改。
- 没有任何 `pom.xml` 引用了 `io.github.lianjishu.*` 路径或 groupId(仅作为 `<parent>` 的根 groupId 使用)。**所有 pom 都无需改动**。
- 没有 `module-info.java` / `package-info.java` / 反射字符串 / 脚本 / IDE 配置引用了具体子包名。重命名不会引发外部硬编码断裂。
- `day31-multithreading/ticket-selling-simulation/target/generated-sources/annotations/TicketPool.java` 是注解处理器生成,**不入版本库**,跳过。
- `day32-mutithreading-and-juc/.../UseSynchronized/TicketPool.java` 是手写并被 git 追踪,要正常迁移。

## 执行步骤

### A. 扁平化(20 个 day 模块):移除 `io.github.lianjishu.<子模块名>` 这一层

对下列每个模块,做**同样三步**:
1. 把 `src/main/java/io/github/lianjishu/<子模块名>/` 下**所有 .java 文件**(以及同目录下的 .md 笔记)上移一层到 `src/main/java/io/github/lianjishu/`(注意:子模块名下**还嵌着**子文件夹的,内层结构保留,只剥最外层 `DayXX_*` 文件夹)
2. 把这些 .java 的 `package io.github.lianjishu.<子模块名>;` 改成 `package io.github.lianjishu;`
3. 删空 `DayXX_*` 文件夹

涉及模块 + 顶层包名(若子模块下还有子文件夹,子文件夹原样保留):

| 模块 | 当前顶层包 | 备注 |
|---|---|---|
| day01-beginner-level | `Day01_Beginner_Level` | 1 .java |
| day02-basic-concept | `Day02_BasicConcept` | 8 .java |
| day03-operator | `Day03_Operator` | 2 .java |
| day04-condition-and-loop | `Day04_ConditionAndLoop` | 6 .java |
| day05-loop-testbook | `Day05_LoopTestbook` | 1 .java |
| day06-method | `Day06_Method` | 2 .java |
| day07-comprehensive-exercise | `Day07_Comprehensive_Exercise` | 4 .java |
| day08-oop | `Day08_OOP` | 1 .java |
| day09-oop-practice | `Day09_OOP_Practice` | 3 .java |
| day10-string | `Day10_String` | 2 .java |
| day11-oop-plus-arraylist-studentsms | `Day11_OOP_Plus_ArrayList_StudentsMS` | 5 .java |
| day14-oop-plus-comprehensive-exercise | `Day14_OOP_Plus_Comprehensive_Exercis` | **本轮改为 `Day14_OOP_Plus_Comprehensive_Exercise`**,5 .java |
| day15-abstract-class-interface-inner-class | `Day15_AbstractClass_Interface_InnerClass` | 17+ .java + 内嵌 README.md |
| day16-17-jigsawgame | `Day16_17_Jigsawgame` | 6 .java |
| day16-event | `Day16_Event` | 7 .java |
| day18-api-basics-object-clone | `Day18_API_Basics_ObjectClone` | 7 .java |
| day19-api-regular-expression | `Day19_API_RegularExpression` | 13+ .java + `练习.md`,内嵌子包 `CapturingGroupRe`、`Crawler`、`RegExp` 保留 |
| day20-api-time-wrapper-class | `Day20_API_Time_WrapperClass` | 2 .java,内嵌子包 `TimeClass`、`WrapperClass` 保留 |
| day22-collections-framework-list | `Day22_CollectionsFramework_List` | 4+ .java + `体系结构.md`,内嵌子包 `Iterator`、`TasteCollection` 保留 |
| day33-inet-program | `Day33_InetProgram` | 1 .java |

### B. day31 / day32 模块:在保留业务子包的前提下加 `io.github.lianjishu` 前缀

对下列每个子模块,做**同样两步**:
1. 把 `src/main/java/<业务子包>/X.java` 移到 `src/main/java/io/github/lianjishu/<业务子包>/X.java`
2. 把 .java 顶部的 `package <业务子包>;` 改成 `package io.github.lianjishu.<业务子包>;`;若文件本来没有 `package` 声明(默认包),**新增** `package io.github.lianjishu;<业务子包或顶级>;` 一行

涉及模块:

| 模块 | 现有业务子包 / 默认包 | 文件数 |
|---|---|---|
| day31-multithreading/create-multithreading | `implement1`、`implement2`、`implement3`、`JoinInMainThread` | 9 |
| day31-multithreading/ticket-selling-simulation | 默认包(`TestTicketSeller`、`Ticket`、`TicketSeller` 等) | 6 |
| day31-multithreading/threading-synchronization | `TransferTaskDemo`、`ShowDeadLock` | 7 |
| day31-multithreading/producer-and-consumer | `ProducerConsumerDemo`、`ProducerConsumerDemoQueue` | 7 |
| day31-multithreading/multiproducer-and-multiconsumer | 默认包(`Apple`、`Orange`、`Plate`、`asdsa`) | 4 |
| day32-mutithreading-and-juc | `ComprehensivePracticalExercises` 内嵌 `PresentGifts`、`OddPrinter`、`RedPacket`、`TicketSeller/UseSynchronized`、`TicketSeller/UseArrayBlockingQueue` | 15+ |

注意:
- `ticket-selling-simulation` 模块根目录的 `TicketSeller-questions-answers.md` **不在** `src/` 下,不需动。
- `multiproducer-and-multiconsumer` 的文件要从默认包**升级**到 `io.github.lianjishu` 一级包,这是唯一**新增** `package` 行的情况。

### C. 文档更新

`README.md` 第 14–37 行的 ASCII 目录树是基于旧的"每个 day 一个子文件夹"结构画的,新结构下顶层只有 `io/github/lianjishu/`。最小改动:把 14–37 行那段树替换成简短描述 + 保留原 day 索引(去掉 `├── DayXX-.../` 路径前缀,只留说明文字)。结构示例:

```
所有 Java 代码统一位于 `src/main/java/io/github/lianjishu/` 之下。
各 Day 的代码通过子包 / 源码文件名前缀区分(详见各 day 模块下的 pom.xml)。
```

## 验证

依次执行:

1. `cd "E:/Projects/Code Demo/Java/itheima/java-zero2hero-code-demo" && mvn -q clean compile -DskipTests`
   - 期望: BUILD SUCCESS,所有 28 个子模块编译通过。
2. `git grep -nE "package[[:space:]]+io\.github\.lianjishu\.[A-Za-z_]" -- '*.java'`
   - 期望: **0 命中**(任何残留的 `io.github.lianjishu.<子包>;` 都应被消除)。
3. `git grep -nE "io\.github\.lianjishu\.[A-Z]" -- '*.java' '*.md' 'pom.xml'`
   - 期望: 0 命中(老的 `io.github.lianjishu.DayXX_*` 一律消失)。
4. `git grep -n "io\.github\.lianjishu" -- '*.java' | head`
   - 抽样确认新位置:例如 `day18/.../TestObject.java` 第一行应是 `package io.github.lianjishu;`,路径是 `day18-api-basics-object-clone/src/main/java/io/github/lianjishu/TestObject.java`。
5. `find . -type d -name "Day*_*" -not -path "*/target/*"`
   - 期望: 0 命中(老的 per-module 顶层包目录被清空)。
6. `mvn -q test`(若有任何 `*Test*.java` 在新包名下的运行需要)
   - 该项目基本没有 junit 测试,主要靠第 1 步的 compile 验证。

## 关键路径(供执行时定位)

- Root pom:`E:/Projects/Code Demo/Java/itheima/java-zero2hero-code-demo/pom.xml`(无需改)
- README:`E:/Projects/Code Demo/Java/itheima/java-zero2hero-code-demo/README.md`(更新 14–37 行)
- 全部 day 模块的源码根:`<模块>/src/main/java/`
- day31 / day32 源码根:`<子模块>/src/main/java/`

## 风险 / 注意点

- `day31-multithreading/ticket-selling-simulation` 的 pom 启用了 `--enable-preview`,迁移不能改它的 pom,只动 .java 位置和包声明。
- `multiproducer-and-multiconsumer` 里有个奇怪命名的 `asdsa.java`,先照搬过来不重命名(不在本次重构范围)。
- 位于源码树里的 .md 笔记(`练习.md`、`体系结构.md`、day15 的 `README.md` 等)跟随上层文件夹一起上移,不要丢失。
- 任何**仅以"子模块名"为包名、且内部类被同模块其他 .java 引用**的情况,因 `package` 改了、`import` 通常无需改(默认同包),但需在第 4 步抽样时确认 1–2 个跨文件引用没坏。
