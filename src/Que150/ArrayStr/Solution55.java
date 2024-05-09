package Que150.ArrayStr;

public class Solution55 {
    public boolean canJump(int[] nums) {
        //我的想法是一个On2的方法
        boolean[] dp = new boolean[nums.length];
        dp[0] = true;
        if (nums.length==1) return true;
        for (int i = 0; i < nums.length; i++) {
            if (i==nums.length-1) return false;
            if (dp[i]==true){
                for (int j = i+1; j <= i+nums[i] ; j++) {
                    if (j==nums.length-1) return true;
                    dp[j] = true;
                }
            }
        }
        return false;
    }

    public boolean canJump2(int[] nums) {
        //题解的On的方法很好，明白了，就是用dp数组来记录人到达当前下标时路修到的最远距离是多少，如果能达到最后一个下标，那么返回true
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (dp[i-1]<i) return false;
            dp[i] = Math.max(dp[i-1],i+nums[i]);
            //剪枝
            if (dp[i]>=nums.length-1) return true;
        }
        return true;
    }
}
