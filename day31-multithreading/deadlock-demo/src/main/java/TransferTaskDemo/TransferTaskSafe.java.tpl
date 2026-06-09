// 模板:照 TODO 填完后,把 .tpl 后缀去掉,改名为 TransferTaskSafe.java
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
