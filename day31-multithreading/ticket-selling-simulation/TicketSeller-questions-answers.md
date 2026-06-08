# Java 多线程 — 售票仿真代码问题解答

> 范围:`day31-multithreading/ticket-selling-simulation` 模块,涉及 `TicketSellerLock.java`、`TicketSellerSync.java`、`TicketPool.java`,以及 `three-implements-multithreading` 模块中两种线程创建方式的对比。

---

## ⚠️ 前置发现 — TicketSellerLock.java 存在严重 Bug

阅读 `TicketSellerLock.java:5-39` 后,发现一个关键问题需要先指出:

```java
public Lock lock = new ReentrantLock();   // line 5:声明了,但……

@Override
public void run() {
    while(true) {
        try { Thread.sleep(100); } catch (...) { ... }
//      synchronized (TicketPool.class) {   // line 16:被注释掉了!
            // ... 临界区
            if(!TicketPool.isEmpty()) { /* 读 remaining, 写 remaining */ }
            else { break; }
//      }                                      // line 37:被注释掉了
    }
}
```

**`lock` 字段从未被调用 (`lock()` / `unlock()` 都没有),`synchronized` 块又被注释掉了。** 也就是说:
- 类名虽然叫 `TicketSellerLock`,实际却没有加任何锁;
- 7 个线程同时跑 `TicketPool.setRemaining(getRemaining()-1)` + `getTickets().get(...)` 会产生经典的 **race condition**(超卖、重复售出、ArrayIndexOutOfBoundsException);
- `Thread.sleep(100)` 只是为了"慢放"演示,不是同步原语。

> **结论:** 你目前看到的输出,`TicketSeller.java`(无锁)和 `TicketSellerLock.java`(实际也无锁)行为相同;`TicketSellerSync.java` 才是真正安全的。后续若需要把 Lock 版本修对,改成:
> ```java
> lock.lock();
> try {
>     // 临界区
> } finally {
>     lock.unlock();
> }
> ```

---

## Q1 — `import java.util.concurrent.locks.ReentrantLock;` 是什么?

### 1.1 包的归属

- 完整路径:`java.util.concurrent.locks.ReentrantLock`
- 所属包:`java.util.concurrent.locks` (简称 J.U.C. locks)
- 引入版本:**JDK 1.5** (Doug Lea 主导,作为 `synchronized` 的增强替代方案)

这个包里的核心类型:

| 类型 | 角色 |
| --- | --- |
| `Lock` | **接口**,定义 `lock() / unlock() / tryLock() / lockInterruptibly() / newCondition()` |
| `ReentrantLock` | `Lock` 最常用的实现,支持重入 |
| `ReentrantReadWriteLock` | 读写分离锁(读共享、写互斥) |
| `StampedLock` | JDK 8 引入,带版本戳的乐观读锁 |

### 1.2 命名含义

- **Reentrant (可重入):** 同一线程可以多次获取同一把锁而不会死锁(底层用 `holdCount` 计数,`unlock` 必须调用等量的次数)。
- 对比 C++ 的 `std::mutex`:Java `synchronized` 本身就是可重入的;`ReentrantLock` 把这个能力显式地开放给 `Lock` 接口。

### 1.3 它解决 `synchronized` 哪些痛点

| 痛点 | `synchronized` | `ReentrantLock` |
| --- | --- | --- |
| 尝试获取锁(不阻塞) | ✗ | `tryLock()` |
| 尝试等待(带超时) | ✗ | `tryLock(time, unit)` |
| 可中断的等待 | ✗ (JVM 自己处理) | `lockInterruptibly()` |
| 公平性 | 不可选 | 构造参数 `new ReentrantLock(true)` |
| 多条件变量 | 只能 `wait/notify`,且只有一个条件队列 | `lock.newCondition()` 多个 |
| 编码粒度 | 关键字,JVM 帮你加解锁 | 手动 `lock/unlock`(必须在 `finally` 里 unlock) |

---

## Q2 — `synchronized (TicketPool.class)` + 两种线程创建法,锁对象怎么传?

### 2.1 为什么用 `TicketPool.class` 作锁?

`TicketPool` 中的 `remaining` 和 `tickets` 是 **`private static`**(见 `TicketPool.java:12, 93`)。Java 中 **静态字段归属于类、不归属于实例** — 7 个 `TicketSeller` 实例共同读写这同一份类级别的数据。

`synchronized` 的语义是"对同一个 monitor 互斥",所以锁对象必须满足 **"所有线程看到的是同一个对象引用"**。能选的合法锁对象:

1. **`TicketPool.class`** — 类对象,整个 JVM 唯一 ✓(本项目选用)
2. **`TicketPool.LOCK`** — `TicketPool.java:6` 已经预定义了一个 `public static Object LOCK = new Object();` ✓
3. 任何**全局可访问、且不会变的对象**(如一个 `public static final Object LOCK = new Object();`)

⚠️ 反例:用 `new Object()`、用 `this`、用 `"abc"`(虽然 `"abc"` 字符串字面量在常量池唯一,但含义不清,不推荐) — 任何"每个线程自己 new 出来的对象"都会让锁形同虚设。

### 2.2 两种线程创建方式 × 锁对象最佳实践

| 创建方式 | 关键特点 | 锁对象怎么选 |
| --- | --- | --- |
| **`extends Thread`** (见 `FooThread.java`) | 任务与"线程身份"绑定,实例本身就是一个 Thread | 用 **静态/全局对象** 锁:`TicketPool.class`、或 `TicketPool.LOCK`。**不要用 `this`**(虽然每个 `FooThread` 是独立对象,但你锁的是"这个线程",别的线程进不去临界区,等同于"全串行化"且分散到不同 monitor) |
| **`implements Runnable`** (见 `BarImplemation.java` + 本项目 `TicketSellerSync.java`) | 任务与线程身份解耦,**多个线程可以共享同一个 `Runnable` 实例**(数据天然共享) | ① 推荐:**共享同一 Runnable 实例 + 锁 `this`**(注意此时所有线程争抢同一把锁);② 共享 Runnable + 锁 `TicketPool.class`;③ 每线程 new 一个 Runnable + 锁 `TicketPool.class`(本项目做法 — 7 个 `new TicketSellerSync()`,锁的还是类对象) |

### 2.3 本项目实际写法分析

```java
// TestTicketSellerSync.java:3-9
Thread t1 = new Thread(new TicketSellerSync());   // 7 个不同实例
Thread t2 = new Thread(new TicketSellerSync());
// ...
// TicketSellerSync.java:8
synchronized (TicketPool.class) { ... }
```

- 7 个 `TicketSellerSync` **实例不同**,但锁的是**同一个 `TicketPool.class`**,所以 7 个线程会争抢同一把 monitor — **正确**。
- 若这里误写 `synchronized (this)`,每个 `TicketSellerSync` 实例都有自己的 monitor,7 个线程就完全并行,临界区又失去保护。

### 2.4 决策树(最佳实践)

```
Q1: 临界资源是 static 还是 instance?
    │
    ├─ static ─→ 锁对象:TicketPool.class / TicketPool.LOCK(全局)
    │           实现 Runnable 还是继承 Thread 都行,但记得共享同一个锁
    │
    └─ instance ─→
        Q2: 多线程是否共享同一个 Runnable 实例?
            │
            ├─ 共享同一实例 ─→ 锁 this(简洁)或锁外部传入的 final Object
            │
            └─ 每线程 new 一个 ─→ 必须锁外部对象(因为 this 不可见给别的线程)
```

> 一句话总结:**锁对象必须对所有要互斥的线程"透明可见且唯一"。** 谁持有它不重要,重要的是所有线程拿到的引用是同一个。

---

## Q3 — `ReentrantLock` vs `synchronized` 的 OS 原理差异,会不会有"线程饥饿"?

### 3.1 `synchronized` 在 OS 层的实现

**字节码层面:**
- 进入同步块 → `monitorenter` 指令(JVM 在对象头 `Mark Word` 上做 CAS)
- 退出同步块 → `monitorexit` 指令

**HotSpot 锁升级(JDK 6+):** 同一把锁根据竞争激烈程度,有 4 种状态:

```
无锁 → 偏向锁(单线程反复进入,JDK 15 默认禁用)
     → 轻量级锁(CAS 自旋,适合短临界区、低竞争)
     → 重量级锁(竞争激烈,升级到 OS mutex)
```

**Linux 上的"重量级锁":**
- JVM 调用 `pthread_mutex_lock`(POSIX 互斥锁)
- `pthread_mutex` 在 Linux 上是 **futex**(Fast Userspace mutex)
- 工作模式:**用户态自旋 + 内核态挂起**混合
  1. 线程先在用户态 CAS 自旋一小段时间(短)
  2. 自旋失败 → 调用 `futex(FUTEX_WAIT, ...)` 把自己挂到等待队列,**进入内核态阻塞**
  3. 持锁线程释放 → `futex(FUTEX_WAKE, ...)` 唤醒队列里的一个线程

### 3.2 `ReentrantLock` 在 OS 层的实现

**核心:AbstractQueuedSynchronizer (AQS)**,模板方法模式。

数据结构:
- `state`(int):重入计数,0 = 未占用
- `CLH` 变体的 **FIFO 双向链表**:等待队列,每个节点保存前驱/后继、`waitStatus`
- 独占模式(`Exclusive`):只有一个 `head` 队列

**获取锁的伪代码(非公平模式):**
```java
final boolean nonfairTryAcquire(int acquires) {
    if (CAS(state, 0, acquires)) {        // 直接 CAS 抢锁!
        setExclusiveOwnerThread(current);
        return true;
    }
    // 失败则入队
    return false;
}
```

**释放锁:** `tryRelease` 把 `state` 减回去,`state==0` 时 `unparkSuccessor` 唤醒后继。

底层调用:
- `LockSupport.park()` / `LockSupport.unpark()` — 最终调用 Linux 的 `futex` 同样走内核态挂起/唤醒
- 也就是说,**`ReentrantLock` 也没绕过 OS mutex**,只是 JVM 自己用 `park/unpark` 写了一个比 `synchronized` 更可控的版本。

### 3.3 关键差异表

| 维度 | `synchronized` | `ReentrantLock`(默认非公平) |
| --- | --- | --- |
| 加锁入口 | `monitorenter` 字节码 | Java 方法调用 `lock.lock()` |
| 等待队列 | 由 JVM 维护,应用程序看不见 | AQS 的 `Node` 链表,程序可调试/扩展 |
| 公平性 | **非公平**(无法配置) | **可配置** — 构造参数 `new ReentrantLock(true)` |
| 唤醒方式 | JVM 自动唤醒(从对象头 `Wait Set`) | `LockSupport.unpark(node.thread)` 精确唤醒 |
| 条件等待 | 整个 monitor 只能一个 `wait/notify` | `lock.newCondition()` 多个等待集 |
| 公平保证 | OS 调度器决定 | 公平锁保证 FIFO,但**会让出 CPU**给队首 |

### 3.4 "线程一凭借自身优势总是领先" 会不会发生?

**这其实是两个不同问题,要分开看:**

#### (a) 锁层面 — 锁竞争中的"插队"

`synchronized` 和 **默认的** `ReentrantLock` 都是 **非公平锁**:
- 持锁线程释放的瞬间,`ReentrantLock` 会让新来的线程和等待队列里的线程**同时**抢锁(通过 CAS `state` 0→1)
- 这种 **barging(插队)** 设计吞吐量高,但理论上一个"运气好"的线程可能连续抢到锁,导致等待队列中的线程 **starvation(饥饿)**

**缓解办法:**
```java
Lock lock = new ReentrantLock(true);  // 公平锁:FIFO,杜绝饥饿
```
但公平锁会让出 CPU 给队首,吞吐量会下降 1~2 个数量级,生产环境通常**默认非公平 + 业务上避免长临界区**。

#### (b) CPU 调度层面 — 操作系统调度器

**OS 调度器( Linux CFS、 Windows UMS)与 Java 锁完全解耦**。锁本身不决定谁先抢到 CPU 时间片。

但有一个关联点:
- **持锁线程会被 OS 视为"在 CPU 上运行"**,而等待线程会被挂在 futex 等待队列中(不消耗 CPU)
- 持锁线程一旦释放锁,`futex` 唤醒一个等待者;**此时 OS 调度器才介入**,决定先调度刚释放的线程还是新唤醒的线程
- 在 Linux CFS 下,刚被唤醒的线程通常会有短暂的"调度奖励"(`virtualruntime` 较低),**确实可能"看起来"总是赢**

#### (c) 你代码里的 `Thread.sleep(100)`

`synchronized` 和 `lock` 块都没有 `sleep` 调用 — `Thread.sleep` 是**线程自己主动让出 CPU**,跟锁竞争无关。它在你代码里的作用是:
- 放慢 7 个线程的节奏,让"线程一卖了第 N 张"的输出肉眼可见
- 不是同步原语,也不是性能调优手段

**综上,你的担心有道理但被现有代码"中和"了:**
- 真正会出现线程饥饿的是非公平锁的 **barging**
- 但你代码里 `Thread.sleep(100)` 把节奏拖慢,加上临界区只是几行赋值/输出,持锁时间极短,**OS 调度器没有足够时间"偏袒"某个线程**
- 如果临界区变成 100ms 的数据库调用,7 个线程下默认非公平锁可能确实会让某些线程显得"运气总好"
- **生产建议:** 优先用 `synchronized`(简单、自动释放、不会忘记 unlock);真有公平性/超时/中断需求,再用 `ReentrantLock`

---

## Q4 — `Lock` 接口的 Java 内置实现类有哪些?

### 4.1 `java.util.concurrent.locks` 包内(直接实现 `Lock` 接口的)

| 实现类 | 引入版本 | 特点 |
| --- | --- | --- |
| **`ReentrantLock`** | 1.5 | 最常用,可重入,支持公平/非公平,见 Q3 |
| `ReentrantReadWriteLock.ReadLock` | 1.5 | 读锁,允许多个线程同时持有(共享) |
| `ReentrantReadWriteLock.WriteLock` | 1.5 | 写锁,排他 |
| **`StampedLock`** | **1.8** | 三种模式:写锁、悲观读锁、**乐观读**(通过版本戳 stamp 校验) |

> 注意:`ReentrantReadWriteLock` 自身**不是**直接实现 `Lock`,但它内部返回的 `readLock()` 和 `writeLock()` 都是 `Lock` 的实现。

### 4.2 `StampedLock` 特别说明(JDK 8+)

```java
StampedLock sl = new StampedLock();
long stamp = sl.tryOptimisticRead();   // 乐观读,几乎零成本
// ... 读数据 ...
if (!sl.validate(stamp)) {             // 校验:期间是否有写锁
    stamp = sl.readLock();             // 升级为悲观读
    try { /* 重新读 */ } finally { sl.unlockRead(stamp); }
}
```

适用场景:**读极多、写极少**(如配置中心、缓存查询)。JDK 8 之前只能用 `volatile` + CAS 自己实现,现在官方有了。

### 4.3 `java.util.concurrent` 包中"形态相似"的同步器(非 `Lock` 接口,但用法近似)

它们不实现 `Lock`,但行为上是"获取/释放通行证"模型,常被一起讨论:

| 类 | 模型 | 关键方法 |
| --- | --- | --- |
| `Semaphore` | N 个许可(计数信号量) | `acquire()` / `release()` |
| `CountDownLatch` | 一次性倒计数门栓 | `countDown()` / `await()` |
| `CyclicBarrier` | 可循环使用的栅栏 | `await()`(所有线程都到齐才放行) |
| `Phaser` | JDK 7 分阶段栅栏 | `arriveAndAwaitAdvance()` |
| `Exchanger` | 两线程数据交换 | `exchange()` |
| `FutureTask` / `CompletableFuture` | 任务结果容器 | `get()` |

### 4.4 选择建议

- **单资源互斥** → `ReentrantLock` / `synchronized`
- **读多写少** → `ReentrantReadWriteLock` / `StampedLock`
- **限制并发数** → `Semaphore`
- **等待多个任务完成** → `CountDownLatch` / `CompletableFuture`
- **多线程阶段性协作** → `Phaser` / `CyclicBarrier`
- **简单、能用 synchronized** → 优先 `synchronized`(编译期保证、不用 try/finally)

---

## 总结

| 问题 | 关键结论 |
| --- | --- |
| Q1 `ReentrantLock` | JDK 1.5 引入,在 `java.util.concurrent.locks`,作为 `synchronized` 的增强替代(可重入 + 显式 lock/unlock) |
| Q2 锁对象 | 锁对象必须"全局唯一";静态资源 → `TicketPool.class`;实例共享 → `this`;实例不共享 → 外部对象 |
| Q3 OS 原理 + 饥饿 | 两者最终都走 OS `futex`;默认都非公平,理论有 barging 饥饿风险;`Thread.sleep` 与锁无关 |
| Q4 Lock 实现 | `ReentrantLock`、`ReentrantReadWriteLock`(读/写锁)、`StampedLock`(乐观读) |

> 后续若要"修对" `TicketSellerLock.java`:在临界区外 `lock.lock()`,在 `try { 临界区 } finally { lock.unlock(); }`,并把 `synchronized` 注释保留作为对照,这样能直观对比两种同步方式。
