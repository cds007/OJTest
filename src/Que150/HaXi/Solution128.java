package Que150.HaXi;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Solution128 {
    public int longestConsecutive(int[] nums) {
        //1.我的想法：这题我直接秒啊。用一个哈希dp数组，数组存储的是到此的连续子序列长度，返回最大的那个就行，时间复杂度包O(nlogn)的。
        // 但是。。。10的9次方，好像有点大啊。还是用哈希表吧，一样的。
        Arrays.sort(nums);
        Map<Integer,Integer> map = new HashMap<>();
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int valuePre = map.getOrDefault(nums[i]-1,0);
            int value = valuePre+1;
            max = Math.max(value,max);
            map.put(nums[i],value);
        }
        return max;
    }
}
