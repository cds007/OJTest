package Que150.dpOne22;

public class Solution198 {
    public int rob(int[] nums) {
        //1.dp[i]代表从0到i偷到的最高金额
        //2.dp[i]=Math.max(dp[i-2]+numbers[i],dp[i-1])
        //3.dp[0]=numbers[0];dp[1]=Math.max(numbers[0],numbers[1])
        //4.遍历顺序，从小到大，从2开始
        int[] dp = new int[nums.length+1];
        dp[0] = nums[0];
        if (nums.length==1) return dp[0];
        dp[1] = Math.max(nums[0],nums[1]);
        for(int i=2;i<nums.length;i++){
            dp[i] = Math.max(dp[i-2]+nums[i],dp[i-1]);
        }
        return dp[nums.length-1];
    }
}
