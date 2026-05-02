# Java 零基础到精通 - 代码示例

本项目是跟随[黑马程序员](https://www.itheima.com/)课程学习 Java 过程中的每日代码练习合集，涵盖从基础语法到网络编程的各个阶段。

每学习一天的课程，就把当天的代码写在对应的 Day 目录下，所有代码放在同一个项目中统一管理。

## 环境要求

- JDK 21
- Maven 3.6+

## 项目结构

```
src/main/java/io/github/lianjishu/
├── Day01-Beginner-Level/          入门基础 - HelloWorld
├── Day02-BasicConcept/            基本概念 - 变量、数据类型、键盘输入
├── Day03-Operator/                运算符 - 逻辑运算符、三元运算符
├── Day04-ConditionAndLoop/        条件判断与循环 - if、switch、for
├── Day05-LoopTestbook/            循环练习题
├── Day06-Method/                  方法与数组
├── Day07-Comprehensive_Exercise/  综合练习 - 数字加密、机票、验证码
├── Day08-OOP/                     面向对象编程入门
├── Day09-OOP-Practice/            OOP 实战 - 文字格斗游戏
├── Day10-String/                  字符串操作 - 模拟登录、罗马数字
├── Day11-OOP_..._StudentsMS/      ArrayList 与学生管理系统
├── Day14-OOP_..._Comprehensive/   OOP 综合练习 - 动物继承体系
├── Day15-Abstract_Interface_.../  抽象类、接口、内部类、适配器模式
├── Day16-Event/                   GUI 事件监听
├── Day16_17-Jigsawgame/           拼图游戏 (Swing GUI)
├── Day18-API-Basics-ObjectClone/  API 基础 - Math、Object、Runtime、克隆
├── Day19-API-RegularExpression/   正则表达式 (预留)
├── Day20-API-Time-WrapperClass/   时间 API 与包装类
├── Day21-API-Algo-Lambda/         算法与 Lambda 表达式 (预留)
├── Day22-Collection-List/         集合框架 - List
└── Day33-InetProgram/             网络编程 - InetAddress
```

## 使用方式

```bash
# 编译整个项目
mvn compile

# 清理构建产物
mvn clean
```

## 注意事项

- 本项目为个人学习用途，代码以演示为主
- 每个 Day 目录相对独立，可单独查看
- Day 编号对应课程天数，部分编号缺失属于正常跳过
- Day19、Day21 为预留目录，暂无代码
