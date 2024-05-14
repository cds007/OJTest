package Que150.HaXi5;

import java.util.HashMap;
import java.util.Map;

public class Solution1 {
    public int[] twoSum(int[] nums, int target) {
        //solution1的题，秒了。
        int[] retArr = new int[2];
        Map<Integer,Integer> Map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int p = target-nums[i];
            if (Map.containsKey(p)){
                retArr[0] = Map.get(p);
                retArr[1] = i;
                return retArr;
            }
            Map.put(nums[i],i);//敢这么存是因为每种输入只对应一个答案
        }
        return new int[0];
    }
}
