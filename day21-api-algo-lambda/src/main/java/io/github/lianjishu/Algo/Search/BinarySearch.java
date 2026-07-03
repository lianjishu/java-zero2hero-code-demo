package io.github.lianjishu.Algo.Search;

import java.util.List;

public class BinarySearch implements SearchStrategy {
    @Override
    public String name() {
        return "BinarySearch";
    }

    @Override
    public int doSearch(List<Integer> nums, int target) {
        int n = nums.size();
        int left = 0, right = n - 1;
        while (left < right) {
            int mid = (right - left) / 2 + left;
            if(target < nums.get(mid))
                right = mid-1;
            else if (target > nums.get(mid))
                left = mid + 1;
            else
                return mid;
        }
        return -1;

    }

//    @Override
//    public int doSearchAdvanced(List<Integer> nums, int target) {
//        return 0;
//    }
}
