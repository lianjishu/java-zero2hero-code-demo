# Java 从入门到起飞——代码示例与学习记录

本项目是跟随[黑马程序员](https://www.itheima.com/)「Java 从入门到起飞」系列课程学习过程中的每日代码练习合集，覆盖从基础语法、面向对象、常用 API、集合与 IO，到多线程、网络编程、反射与动态代理、注解与日志等阶段。

> **当前进度**：课程主体已基本学完。`Day01` 到 `Day36` 的核心模块均已落地，仓库可作为 Java 基础与进阶阶段的代码复习与查阅资料。

每学习一天的课程，就把当天的代码写在对应的 Day 目录下，所有代码放在同一个多模块 Maven 项目中统一管理。

## 环境要求

- JDK 21
- Maven 3.6+

## 项目结构

根项目按 Day 拆分为多个 Maven 子模块，每个子模块下 `src/main/java` 统一使用 `io.github.lianjishu` 基础包，通过子包/类名区分不同课程内容。

| 模块 | 简介 |
| --- | --- |
| day01-beginner-level | 入门基础 - HelloWorld |
| day02-basic-concept | 基本概念 - 变量、数据类型、键盘输入 |
| day03-operator | 运算符 - 算术、逻辑、三元运算符 |
| day04-condition-and-loop | 条件判断与循环 - if、switch、for、while |
| day05-loop-testbook | 循环练习题 |
| day06-method | 方法与数组 |
| day07-comprehensive-exercise | 综合练习 - 数字加密、机票、验证码 |
| day08-oop | 面向对象编程入门 - 类与对象、封装 |
| day09-oop-practice | OOP 实战 - 文字格斗游戏 |
| day10-string | 字符串操作 - 模拟登录、罗马数字转换 |
| day11-oop-plus-arraylist-studentsms | ArrayList 与学生管理系统 |
| day14-oop-plus-comprehensive-exercise | OOP 综合练习 - 动物继承体系 |
| day15-abstract-class-interface-inner-class | 抽象类、接口、内部类、适配器模式 |
| day16-event | GUI 事件监听 |
| day17-jigsawgame | 拼图游戏 (Swing GUI) |
| day18-api-basics-object-clone | API 基础 - Math、Object、Runtime、对象克隆 |
| day19-api-regular-expression | 正则表达式 |
| day20-api-time-wrapper-class | 时间 API 与包装类（JDK 8 `java.time`） |
| day21-api-algo-lambda | 算法练习与 Lambda 表达式 |
| day22-collection-framework-list | 集合框架 - List |
| day23-collection-generics-set-datastructure | 泛型、Set、栈/队列/链表等数据结构 |
| day24-map-varargs-collections | Map、可变参数、Collections 工具类 |
| day25-comprehensivexercise-doudizhugame | 集合综合实战 - 斗地主游戏 |
| day26-collection-stream-method-reference | Stream 流、方法引用 |
| day27-io-exception-file | 异常处理与 File 类 |
| day28-io-bytestream-characterstream | 字节流与字符流 |
| day29-buffered-serialization-convert-print-zip-stream-commonsio-hutool | 缓冲流、序列化、转换流、打印流、压缩流、Commons IO、Hutool |
| day29-io-final-exercise | IO 综合练习 |
| day30-comprehensive-exercise | 综合项目/资料 |
| day31-multithreading | 多线程基础（多个子模块） |
| day32-mutithreading-and-juc | JUC 并发工具 |
| day33-network-programming | 网络编程 - InetAddress、TCP/UDP |
| day34-final-project-chatroom | 结业项目 - 多客户端聊天室 |
| day35-reflection-and-dynamic-proxy | 反射与动态代理 |
| day36-log-classloader-xml-unittest-annotaion | 日志、类加载器、XML、单元测试、注解 |

> 表中模块名以根目录 `pom.xml` 的 `<modules>` 配置为准；课程编号跳跃属于正常跳过。

## 使用方式

```bash
# 编译整个项目
mvn compile

# 清理构建产物
mvn clean
```

## 当前进度

「Java 从入门到起飞」主体课程已完成阶段性学习，当前代码仓库覆盖以下技术点：

- **Java 基础语法**：变量、数据类型、运算符、流程控制、方法、数组
- **面向对象**：类与对象、封装、继承、多态、抽象类、接口、内部类、适配器模式
- **常用 API**：Math、Object、Runtime、String、正则表达式、包装类、JDK 8 `java.time` 时间 API
- **集合体系**：Collection、List、Set、Map、泛型、可变参数、Collections 工具类、Stream 流、方法引用
- **数据结构与算法**：常见排序/查找、栈、队列、链表
- **IO 与异常**：异常处理、File、字节流、字符流、缓冲流、序列化、转换流、打印流、压缩流，以及 Commons IO、Hutool 等工具库
- **GUI 编程**：Swing 基础、事件监听、拼图小游戏
- **多线程与并发**：`Thread`、`Runnable`、线程池、锁机制、JUC 并发工具
- **网络编程**：InetAddress、TCP、UDP、多客户端聊天室实战
- **高级特性**：反射、动态代理、类加载器、注解、XML、JUnit 单元测试、日志框架集成

## 后续计划

「Java 从入门到起飞」侧重基础与进阶，但通往企业级开发仍有不少台阶。下一阶段计划按需推进：

- **设计模式与代码重构**：常见设计模式实践与小型项目重构
- **JVM 与性能调优**：内存模型、垃圾回收、常用调优参数与工具
- **Web 基础**：Servlet、Tomcat、HTTP 协议、过滤器与监听器
- **数据库**：MySQL 基础、JDBC、连接池、事务与索引
- **主流框架**：Spring / Spring Boot、MyBatis、Spring MVC
- **项目实战**：REST API、前后端分离项目、微服务入门

## 注意事项

- 本项目为个人学习用途，代码以演示为主
- 每个 Day 模块相对独立，可在对应目录下单独查看
- Day 编号对应课程天数，部分编号缺失属于正常跳过
- 课程对应的学习笔记、心得与扩展资料，按需补充在各模块的 `.md` 文件中