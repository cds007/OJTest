package antdiy;

public class Q1ChangeCoins {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        //1.dp[j]表示背包容量为j时，0-i的硬币能组合成总金额为j的最小个数j取值从1到amount
        //2.dp[j] = Math.min(dp[j],dp[j-coins[i]]+1)//注意！是个数不是组合数，所以后面是要加1的
        int max = Integer.MAX_VALUE;
        int[] dp = new int[amount+1];
        //3.dp数组初始化
        dp[0] = 0;
        for(int i=1;i<=amount;i++) dp[i] = max;
        for (int i = 0; i < coins.length; i++) {//先遍历物品
            for (int j = coins[i]; j <= amount; j++) {//再遍历背包
                if (dp[j-coins[i]]!=max){
                    dp[j] = Math.min(dp[j],dp[j-coins[i]]+1);
                }
            }
        }
        if (dp[amount]==max) return -1;
        return dp[amount];
    }
    public static void main(String[] args) {
        /**
         * 给定不同面额的硬币和一个总金额。计算可以凑成总金额所需最少硬币数量以及对应硬币面额。如果没有任何一种硬币组合能组成总金额，返回-1。
         */
        //这就是个很简单的完全背包问题
        //以下是测试用例
        Q1ChangeCoins q1 = new Q1ChangeCoins();
        int[] coins = new int[]{1,2,5};
        int amount = 11;
        System.out.println(q1.coinChange(coins,amount));//返回3
        coins = new int[]{2};
        amount = 3;
        System.out.println(q1.coinChange(coins,amount));//返回-1
    }
}
