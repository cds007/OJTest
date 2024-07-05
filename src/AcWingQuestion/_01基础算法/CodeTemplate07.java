package AcWingQuestion._01基础算法;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CodeTemplate07 {
    /**
     * 二维前缀和
     * S[i, j] = 第i行j列格子左上部分所有元素的和
     * 以(x1, y1)为左上角，(x2, y2)为右下角的子矩阵的和为：
     * S[x2, y2] - S[x1 - 1, y2] - S[x2, y1 - 1] + S[x1 - 1, y1 - 1]
     */

    public static void main(String[] args) throws IOException {
        /**
         * 796. 子矩阵的和
         * 第一行包含三个整数 n，m，q
         * 接下来 n行，每行包含 m个整数，表示整数矩阵。接下来 q行，每行包含四个整数 x1,y1,x2,y2，表示一组询问。
         * 3 4 3
         * 1 7 2 4
         * 3 6 2 8
         * 2 1 2 3
         * 1 1 2 2
         * 2 1 3 4
         * 1 3 3 4
         * 17
         * 27
         * 21
         */
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] str1 = in.readLine().split(" ");
        int n = Integer.valueOf(str1[0]),m = Integer.valueOf(str1[1]),q = Integer.valueOf(str1[2]);
        int[][] arr = new int[n+1][m+1];
        int[][] S = new int[n+1][m+1];
        for (int i = 1; i <=n; i++) {
            String[] str2 = in.readLine().split(" ");
            for (int j = 1; j <=m; j++) {
                arr[i][j] = Integer.valueOf(str2[j-1]);
            }
        }
        //构造前缀和数组
        for (int i = 1; i <=n; i++) {
            for (int j = 1; j <=m; j++) {
                S[i][j] = S[i-1][j] + S[i][j-1] - S[i-1][j-1] + arr[i][j];
            }
        }
        //查询打印
        while (q--!=0){
            String[] str3 = in.readLine().split(" ");
            int x1 = Integer.valueOf(str3[0]),y1 = Integer.valueOf(str3[1]),x2 = Integer.valueOf(str3[2]),y2 = Integer.valueOf(str3[3]);
            System.out.println(S[x2][y2]-S[x2][y1-1]-S[x1-1][y2]+S[x1-1][y1-1]);
        }
    }
}
