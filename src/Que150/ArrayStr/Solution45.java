package Que150.ArrayStr;

public class Solution45 {
    public int jump(int[] nums) {
        //这题肯定是动态规划，我想想怎么做，但是我的想法还是On2，先用On2来做。
        int[] dp = new int[nums.length];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0] = 0;
        for (int i = 0; i < nums.length-1; i++) {
            for (int j = i+1; j<nums.length&&j <=i+nums[i]; j++) {
                dp[j] = Math.min(dp[i]+1,dp[j]);
            }
        }
        return dp[nums.length-1];
    }

    //这个是用贪心算法来计算的，每次都跳最大的，实现方式感觉还挺新颖的。
    public int jump2(int[] nums) {
        int length = nums.length;
        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        for (int i = 0; i < length - 1; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]);
            if (i == end) {
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }
}
