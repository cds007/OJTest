package Que150.HaXi5;

import java.util.*;

public class Solution219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        //跟两数之和有点像啊，这有点简单啊。我一个O(n)的想法，直接一次遍历呗。秒了。
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])){
                if (i-map.get(nums[i])<=k) return true;
                map.put(nums[i],i);
            }else {
                map.put(nums[i],i);
            }
        }
        return false;
    }
}
