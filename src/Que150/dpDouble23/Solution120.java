package Que150.dpDouble23;

import java.util.List;

public class Solution120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        //动态规划就是比较难想，但一想到代码就很好写，这道题其实还好，不是很难。
        // f[i][j]f[i][j]f[i][j] 表示从三角形顶部走到位置 (i,j)(i, j)(i,j) 的最小路径和。
        //f[i][j]=min(f[i−1][j−1],f[i−1][j])+c[i][j]
        int n = triangle.size();
        int[][] f = new int[n][n];
        f[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < n; ++i) {
            f[i][0] = f[i - 1][0] + triangle.get(i).get(0);
            for (int j = 1; j < i; ++j) {
                f[i][j] = Math.min(f[i - 1][j - 1], f[i - 1][j]) + triangle.get(i).get(j);
            }
            f[i][i] = f[i - 1][i - 1] + triangle.get(i).get(i);
        }
        int minTotal = f[n - 1][0];
        for (int i = 1; i < n; ++i) {
            minTotal = Math.min(minTotal, f[n - 1][i]);
        }//最后一行
        return minTotal;
    }
}
