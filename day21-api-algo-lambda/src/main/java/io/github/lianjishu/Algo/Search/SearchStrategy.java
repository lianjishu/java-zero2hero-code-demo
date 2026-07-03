package io.github.lianjishu.Algo.Search;

import java.util.List;

public interface SearchStrategy {

    public String name();

    public int doSearch(List<Integer> nums, int target);

    public default int doSearchAdvanced(List<Integer> nums, int target) {
        return 0;
    }
}

