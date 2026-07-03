package io.github.lianjishu.Algo.Search;

import java.util.List;

public class LinearSearch implements SearchStrategy {

    @Override
    public String name() {
        return "LinearSearch";
    }

    @Override
    public int doSearch(List<Integer> nums, int target) {
        int n = nums.size();
        int i = 0;
        while (i < n && !nums.get(i).equals(target))
            i++;
        if (i >= n) return -1;
        else return i;
    }

    @Override
    public int doSearchAdvanced(List<Integer> nums, int target) {
        int n = nums.size();
        int i = 0;
        int sentinel = target;
        nums.add(sentinel);

        while (nums.get(i) != sentinel)
            i++;

        if (i==n) return -1;
        else return i;
    }
}
