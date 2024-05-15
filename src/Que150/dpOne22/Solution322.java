package Que150.dpOne22;

public class Solution322 {
    public int coinChange(int[] coins, int amount) {
        if (amount==0) return 0;
        //1.dp[j]表示背包容量为j时，0-i的硬币能组合成总金额为j的最小个数j取值从1到amount
        //2.dp[j] = Math.min(dp[j],dp[j-coins[i]]+1)//注意！是个数不是组合数，所以后面是要加1的
        int max = Integer.MAX_VALUE;
        int[] dp = new int[amount+1];
        dp[0]  =0;
        for(int i=1;i<=amount;i++) dp[i] = max;
        for(int i=0;i<coins.length;i++){
            //先遍历物品
            for(int j=coins[i];j<=amount;j++){
                //再遍历背包
                if (dp[j-coins[i]]!=max){
                    //防止出现最大值还要加1的情况，不然会出现负数，超出负荷。
                    dp[j] = Math.min(dp[j],dp[j-coins[i]]+1);
                }

            }
        }
        if (dp[amount]==max) return -1;
        return dp[amount];
    }
}
