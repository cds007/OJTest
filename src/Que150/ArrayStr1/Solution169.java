package Que150.ArrayStr1;

import java.util.HashMap;
import java.util.Map;

public class Solution169 {
    public int majorityElement(int[] nums) {
        //输入：nums = [2,2,1,1,1,2,2]
        //输出：2
        Map<Integer,Integer> map = new HashMap<>();
        int n = nums.length/2;
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])){
                if (map.get(nums[i])+1>n){
                    return nums[i];
                }
                map.put(nums[i],map.get(nums[i]+1));
            }else{
                map.put(nums[i],1);
            }
        }
        return nums[0];
    }
}
