package Que150.dpOne22;

import java.util.List;

public class Solution139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        //完全背包问题，排序，先背包再物品
        //1.比之前的难，稍微变了一下
        //2.dp[j]=true，表示从第一个字符到第j个字符能被拼接；
        //3.dp[j] = dp[i] && (能从i-j中找到一个字符串在wordDict中)
        //4.dp[0] = true
        //5.如何遍历，不像之前那样遍历了，遍历物品的时候有点难度
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        for(int j=1;j<=s.length();j++){//遍历背包大小
            for(int i=0;i<j;i++){//遍历单词
                String str = s.substring(i,j);//i从0开始，但是i是dp[i+1]
                if (wordDict.contains(str)&&dp[i]==true){
                    dp[j] = true;
                }
            }
        }
        return dp[s.length()];
    }
}
