# Deadlock Demo — 上机实验代码提示

> 这是一份"填空式"脚手架,用于 4 个文件的实现学习。每个文件给出**结构/签名 + 关键思考点**,**实现留给你自己写**。
>
> 实现完后,跟 `TicketSeller-questions-answers.md` 中的 `Thread` / `synchronized` 知识点对照验证。

---

## Context(为什么写这个)

- 上一阶段 `TicketSellerLock.java` 已经踩过"忘记 unlock / 重复 unlock"的坑 — 那只是**单个锁**的常见错误
- 这一阶段要进入**多锁**的世界,学会识别死锁的 4 个必要条件(Coffman),并掌握业界最常用的预防方案 — **统一加锁顺序**
- 通过 `jstack` 现场抓死锁,把"看不见的卡死"变成"看得见的栈"

---

## 文件 1:`Account.java`(POJO,~30 行)

**思考点:** 账户作为**共享资源**,是否需要"自带锁"?

```java
public class Account {
    // TODO: 声明 2 个字段
    //   - name:   账户名(String)
    //   - balance:余额(int)
    // 提示:是否要加 final?是否要 private?
    
    // TODO: 构造器  Account(String name, int balance)
    
    // TODO: 4 个方法
    //   - getName()       :返回账户名
    //   - getBalance()    :返回余额
    //   - debit(int amt)  :余额 -= amt
    //   - credit(int amt) :余额 += amt
    
    // TODO: toString() 方便打印,格式参考 TicketSeller.java 里的写法
}
```

**学习点:**
- `debit` / `credit` **不需要** `synchronized` — 因为锁应该在**调用方**(`TransferTask`)里加,而不是资源自己内部
- 想想看:如果 `debit` / `credit` 自己加锁,会发生什么?(提示:Java 对象有内置 monitor,但每个方法都加 `synchronized (this)` 的话,锁的粒度太小)
- `name` 是否要 `final`?提示:账户名创建后不应改 — 用 `final` 强化不变量

---

## 文件 2:`TransferTask.java`(BUG 版,~30 行,会死锁)

**思考点:** 怎么写"故意会死锁"的代码?哪些设计选择会让死锁**必现**?

```java
public class TransferTask implements Runnable {
    // TODO: 3 个字段
    //   - from:Account  (转出方)
    //   - to:Account    (转入方)
    //   - amount:int    (金额)
    
    // TODO: 构造器  TransferTask(Account from, Account to, int amount)
    
    @Override
    public void run() {
        // TODO: 实现转账
        // 
        // 关键设计:你需要"获取 2 个锁"——先锁一个,再锁另一个
        // 思考:
        //   1) 锁对象选什么?(提示:从 TicketSellerSync.java 借经验,
        //      但 Account 是实例级别的,不是 static,跟 TicketPool.class 不一样)
        //   2) 加锁顺序?——故意设计成"每次都先锁 from、再锁 to"
        //   3) 为什么"两段 synchronized 嵌套"会死锁?想想 2 个线程同时跑的场景
        //
        // 关键技巧:在两个 synchronized 块之间加 Thread.sleep(200)
        //   —— 这样能"拉宽死锁窗口",让 demo 几乎必现(否则线程太快,
        //   第一个可能一口气把两把锁都拿完再让出,反而不会死锁)
        //
        // 别忘了 import InterruptedException 处理
    }
}
```

**学习点:**
- 死锁的 4 个 Coffman 条件,这个文件**同时满足**全部 4 个 — 找出来对应到代码的哪几行
- `synchronized (from)` 和 `synchronized (to)` 是**两把独立的锁**(因为 `from` 和 `to` 是不同的对象)
- "Barging"(插队)是另一种饥饿,跟死锁不同 — 注意区分

---

## 文件 3:`TransferTaskSafe.java`(FIX 版,~40 行,不卡死)

**思考点:** 死锁形成的第 4 个条件是"循环等待"。怎么**打破循环等待**?

```java
public class TransferTaskSafe implements Runnable {
    // TODO: 字段、构造器跟 TransferTask 完全一样
    
    @Override
    public void run() {
        // TODO: 实现"无论 from → to 还是 to → from,都按同样顺序加锁"的转账
        //
        // 核心思路:加锁前先比较"哪个对象应该先锁",让它有一个**全局一致的顺序**
        //
        // 思考:
        //   1) 怎么定义"全局一致顺序"?—— 常见做法:用 hashCode
        //      (或者 System.identityHashCode,避免子类重写 hashCode 的坑)
        //   2) 如果 from.hashCode() == to.hashCode() 怎么办?(罕见但可能)
        //      —— 需要 tiebreaker,想想可以怎么兜底
        //   3) 算出 first / second 之后,加锁逻辑就跟 BUG 版一样,
        //      也要 Thread.sleep(200) 拉宽窗口
        //
        // 验证:跑这个版本,两个线程应该都能正常完成转账,不会卡住
    }
}
```

**学习点:**
- "固定加锁顺序"是**预防**死锁的最常用手段 — 适用于**已知所有锁对象**的场景
- 还有别的方法吗?想想:
  - `tryLock(timeout)`:不满足就放弃,业务重试(适用于锁竞争激烈、可以重试的场景)
  - 单一全局锁:简单粗暴但性能差
  - 无锁数据结构(用 `AtomicInteger`):改动大但最快
- **Happens-before** 原则:即使加了锁,如果忘了 `volatile` / `synchronized` 包住共享变量,仍可能有可见性问题 — 这个 demo 里 `int` 字段因为总在 `synchronized` 块内读写,所以没事

---

## 文件 4:`TestDeadlock.java`(~50 行,main + 演示)

**思考点:** 怎么写一个"既能演示死锁、又能演示修复"的 main?怎么提示用户用 `jstack` 验证?

```java
public class TestDeadlock {
    public static void main(String[] args) {
        // TODO: 准备 2 个 Account 实例(比如 Alice 1000, Bob 1000)
        // 打印初始余额
        
        // TODO: 根据 args[0] 决定跑哪个版本
        //   - 无参 或 "bug"  → 跑 BUG 版(预期:卡住)
        //   - "safe"          → 跑 FIX 版(预期:正常完成)
        //
        // 提示:每个版本里:
        //   1) 创建 2 个 Thread,传不同的 TransferTask 实例
        //      (T1: A→B;T2: B→A)
        //   2) 给线程起好名字(如 "T-AtoB"、"T-BtoA"),
        //      这样 jstack 输出里一眼能找到
        //   3) start() 两个线程
        //
        // 提示:在跑 BUG 版时,**不要**用 t1.join() 等结果
        //   —— 会一直等下去
    }
    
    // TODO: 2 个辅助方法
    //   - runDeadlock(Account a, Account b)  → 创建 BUG 版线程并启动
    //   - runSafe(Account a, Account b)      → 创建 FIX 版线程并启动
    //
    // 在 runDeadlock 里加一个打印提示,告诉用户:
    //   "程序卡住了?在另一个终端执行: jps 找 PID,然后 jstack <pid> | tail -30"
}
```

**学习点:**
- 线程**命名**是好习惯 — 不写名字的话,jstack 里看到的是 `Thread-0`、`Thread-1`,调试地狱
- 死锁检测有 3 种方法:
  1. `jstack <pid>` / `jcmd <pid> Thread.print` — 末尾会显示 `Found 1 deadlock.`
  2. `jconsole` / `VisualVM` — GUI 可视化
  3. `ThreadMXBean.findDeadlockedThreads()` — 程序内自动检测(进阶,可选)
- `main` 线程**不会**被阻塞(它只是 `start()` 之后就返回了),所以 main 跑完后**进程不会退出** — 因为还有 2 个非 daemon 线程卡在 synchronized 上

---

## 验证清单(写完后必跑)

```
1. mvn -pl day31-multithreading/deadlock-demo compile              ← 编译过
2. mvn -pl day31-multithreading/deadlock-demo exec:java \
     -Dexec.mainClass=TestDeadlock                                  ← 跑 BUG 版
   → 程序卡住,看到类似 "T-AtoB 锁住 Alice,等待 Bob..." 这样的输出
3. 另开终端:
   → jps                          找到 PID
   → jstack <pid> | tail -30      看到 "Found 1 deadlock." + 两个线程的栈
4. 杀掉卡住的进程(Ctrl+C),再跑:
   mvn -pl day31-multithreading/deadlock-demo exec:java \
     -Dexec.mainClass=TestDeadlock -Dexec.args="safe"
   → 程序正常完成,两个账户最终余额对得上(都是 1000)
5. (选做)反复跑 BUG 版 5~10 次,确认每次都死锁
```

---

## 容易踩的坑(提前避雷)

| 坑 | 后果 | 怎么避 |
| --- | --- | --- |
| 忘记 `Thread.sleep(200)` | 线程太快,可能恰好不卡死 | 两次加锁之间强制 sleep |
| `synchronized (this)` 而非 `synchronized (account)` | 锁的是 `TransferTask` 实例,跟 Account 无关,完全没互斥 | 锁**共享资源对象** |
| FIX 版里 `first.equals(second)` | 如果 `from == to`(自转账)会出问题 | 边界 case 可以先 `if (from == to) return;` |
| `debit`/`credit` 里自己加了 `synchronized` | 跟外层 `synchronized (account)` 嵌套,死锁或重复加锁(Java 是可重入的,但语义混乱) | 让 `debit`/`credit` **保持纯逻辑**,不加锁 |
| `int balance` 而非 `volatile int balance` | 这次因为都在 synchronized 里读写所以没事;但要意识到:如果哪天去掉 synchronized,可能读到旧值 | 教学 demo 暂时忽略,JUC 章节会讲 `volatile` |

---

## 思考题(写完代码后回头想)

1. **死锁 vs 活锁 vs 饥饿:** `tryLock + 重试`能修死锁,但如果两个线程都礼貌地"让一下",是不是会**活锁**(都在动但都完成不了)?怎么破?
2. **动态锁顺序:** 如果运行时才知道要锁哪些对象(比如转账链 A→B→C→A,涉及 N 个账户),"全局一致顺序"怎么保证?想想哲学家就餐问题。
3. **Lock 接口的 `tryLock` 怎么写?** 试着用 `ReentrantLock` 改写 BUG 版,用 `tryLock(100, TimeUnit.MILLISECONDS)` 拿不到就释放已有的。
4. **`ThreadMXBean` 自动检测:** 写个 `main` 循环调用 `findDeadlockedThreads()`,有死锁就打印。提示:管理 Bean 入口在 `java.lang.management.ManagementFactory`。

> 答完这 4 题,死锁这一节就基本过关了。
