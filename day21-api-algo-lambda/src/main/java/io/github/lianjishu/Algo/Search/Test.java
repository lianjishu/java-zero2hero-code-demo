package io.github.lianjishu.Algo.Search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 演示所有 {@link SearchStrategy} 实现：分别用 [1, 2, 3, 4, 5] 测试命中 / 未命中 / 进阶版本.
 * 每次执行前调用 {@link #reset()} 把共享列表还原，避免
 * {@link LinearSearch#doSearchAdvanced} 添加的哨兵元素污染到后续策略的测试输入.
 */
public class Test {

    /** 共享测试列表：每次 {@link #reset()} 后都回到 [1, 2, 3, 4, 5]. */
    public static List<Integer> nums = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));

    /** 全局断言通过 / 失败计数，末尾汇总输出. */
    private static int passed = 0;
    private static int failed = 0;

    /** 把共享列表还原为初始状态 [1, 2, 3, 4, 5]. */
    private static void reset() {
        nums.clear();
        nums.addAll(Arrays.asList(1, 2, 3, 4, 5));
    }

    /**
     * 断言 {@code actual} 等于 {@code expected}.
     * 失败时仅打印但不抛异常，让所有用例尽量都跑完，最后通过 {@code System.exit(1)} 给出非 0 退出码.
     */
    private static void assertEquals(String label, int expected, int actual) {
        if (expected == actual) {
            passed++;
            return;
        }
        failed++;
        System.out.printf("  [FAIL] %-40s expected=%d, actual=%d%n",
                label, expected, actual);
    }

    /**
     * 对单个策略跑一次通用三连：未命中 / 命中 / 进阶版本.
     * <p>
     * 注：{@link BinarySearch} 当前没有覆写 {@link SearchStrategy#doSearchAdvanced}，
     * 会直接复用接口默认实现 ({@code return 0})。这里对 BinarySearch 单独调整期望值，
     * 以尊重"接口默认行为"的现状，而不是默默放行.
     */
    private static void runOne(String name) {
        reset();
        SearchStrategy strategy = StrategyFactory.create(name);
        int r1 = strategy.doSearch(nums, 10);            // 不存在 -> -1
        int r2 = strategy.doSearch(nums, 4);             // 存在   -> 3
        int r3 = strategy.doSearchAdvanced(nums, 4);
        System.out.printf("%-18s | doSearch(10)=%2d | doSearch(4)=%d | doSearchAdvanced(4)=%d%n",
                name, r1, r2, r3);

        assertEquals(name + " · doSearch(10) 未命中", -1, r1);
        assertEquals(name + " · doSearch(4) 命中",    3, r2);

        // BinarySearch 没有覆写 doSearchAdvanced，接口默认返回 0
        if (name.equals("BinarySearch")) {
            assertEquals(name + " · doSearchAdvanced(4) [接口默认]", 0, r3);
        } else {
            assertEquals(name + " · doSearchAdvanced(4)", 3, r3);
        }
    }

    private static void testLinearSearch()    { runOne("LinearSearch"); }
    private static void testBinarySearch()    { runOne("BinarySearch"); }
    private static void testBlockSearch()     { runOne("BlockSearch"); }
    private static void testHashSearch()      { runOne("HashSearch"); }
    private static void testFibonacciSearch() { runOne("FibonacciSearch"); }

    /**
     * 额外的边界场景：空列表对所有策略都应统一返回 -1，
     * 验证各实现的健壮性（防御 n=0 / n=1 等退化情形）.
     * <p>
     * 每次循环都重新构造一个空列表：因为 {@link LinearSearch#doSearchAdvanced}
     * 会往入参里追加哨兵，复用同一个空列表会让后续策略看到的不是空列表.
     */
    private static void testBoundary() {
        System.out.println("---- Boundary (空列表应统一返回 -1) ----");
        for (String name : List.of("LinearSearch", "BinarySearch",
                "BlockSearch", "HashSearch", "FibonacciSearch")) {
            SearchStrategy s = StrategyFactory.create(name);
            List<Integer> empty = new ArrayList<>();
            assertEquals(name + " · doSearch on []",         -1, s.doSearch(empty, 1));

            // BinarySearch 复用接口默认 doSearchAdvanced（return 0），需要特殊处理
            if (name.equals("BinarySearch")) {
                assertEquals(name + " · doSearchAdvanced on [] [接口默认]", 0, s.doSearchAdvanced(empty, 1));
            } else {
                assertEquals(name + " · doSearchAdvanced on []", -1, s.doSearchAdvanced(empty, 1));
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("================================================");
        System.out.println(" SearchStrategy 演示 & 简单断言测试");
        System.out.println("================================================");
        testLinearSearch();
        testBinarySearch();
        testBlockSearch();
        testHashSearch();
        testFibonacciSearch();
        testBoundary();

        System.out.println("------------------------------------------------");
        System.out.printf("Result: passed=%d, failed=%d%n", passed, failed);
        System.out.println("================================================");
        if (failed > 0) {
            System.exit(1);
        }
    }
}
