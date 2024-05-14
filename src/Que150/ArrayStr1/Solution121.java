package Que150.ArrayStr1;

public class Solution121 {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];//第i天持有股票的最大利润和不持有股票的最大利润
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i-1][0],-prices[i]);//就是比谁更小
            dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0]+prices[i]);
        }
        return dp[prices.length-1][1];
    }
}
