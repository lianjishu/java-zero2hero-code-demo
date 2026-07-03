package io.github.lianjishu.Algo.Search;

import java.util.Map;
import java.util.function.Supplier;

/**
 * 策略工厂：用一张不可变 Map 把"策略名 -> 构造函数引用"集中维护.
 * 新增策略只需在 {@link #STRATEGIES} 中加一行，无需改动 create 逻辑.
 */
public final class StrategyFactory {

    /** 策略名 -> 构造函数引用，键值对形式集中维护. */
    private static final Map<String, Supplier<SearchStrategy>> STRATEGIES = Map.of(
            "LinearSearch",    LinearSearch::new,
            "BinarySearch",    BinarySearch::new,
            "BlockSearch",     BlockSearch::new,
            "HashSearch",      HashSearch::new,
            "FibonacciSearch", FibonacciSearch::new
    );

    private StrategyFactory() {
    }

    public static SearchStrategy create(String name) {
        if (name == null) {
            return null;
        }
        Supplier<SearchStrategy> supplier = STRATEGIES.get(name);
        if (supplier == null) {
            throw new IllegalStateException("Unexpected value: " + name);
        }
        return supplier.get();
    }

}
