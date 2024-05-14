package Que150.ArrayStr1;

public class Solution122 {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        dp[0][0] = -prices[0];//持有股票
        dp[0][1] = 0;//不持有股票
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]-prices[i]);//不持有，没毛病，考虑一个一直下降的折线就能明白了
            dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0]+prices[i]);//考虑一个一直增加的折线就明白了
        }
        return dp[prices.length-1][1];
    }
}
