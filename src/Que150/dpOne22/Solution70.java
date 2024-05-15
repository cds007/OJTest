package Que150.dpOne22;

public class Solution70 {
    public int climbStairs(int n) {
        int[] dp = new int[3];
        dp[0]=0;dp[1]=1;dp[2]=2;
        if (n<3) return n;
        for(int i=3;i<=n;i++){
            int sum = dp[1] + dp[2];
            dp [1] = dp[2];
            dp [2] = sum;
        }
        return dp[2];
    }
}
