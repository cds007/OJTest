package Que150.dpDouble23;

public class Solution64 {
    public int minPathSum(int[][] grid) {
        //这题好简单
        //dp[i][j]表示走到(i,j)的最小路径和
        //题解的写法在于不需要dp数组，直接从上至下更改grid数组即可
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i == 0 && j == 0) continue;
                else if (i == 0) grid[i][j] = grid[i][j - 1] + grid[i][j];
                else if (j == 0) grid[i][j] = grid[i - 1][j] + grid[i][j];
                else grid[i][j] = Math.min(grid[i - 1][j], grid[i][j - 1]) + grid[i][j];
            }
        }
        return grid[grid.length - 1][grid[0].length - 1];
    }
}
