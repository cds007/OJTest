package Que150.dpDouble23;

public class Solution63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        //简单不必多言。
        int m = obstacleGrid.length;int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        for(int j=0;j<n&&obstacleGrid[0][j]==0;j++) dp[0][j] = 1;//初始化行，遇到石头直接停止
        for(int i=0;i<m&&obstacleGrid[i][0]==0;i++) dp[i][0] = 1;//初始化列，遇到石头直接停止
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if (obstacleGrid[i][j]==0) dp[i][j] = dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
}
