package AcWingQuestion._01基础算法;

import java.util.Scanner;

public class CodeTemplate09 {
    /**
     * 差分矩阵
     */
    static int N = 1010;
    static int n, m, q;
    static int[][] b = new int[N][N];
    static int[][] a = new int[N][N];

    public static void insert(int x1, int y1, int x2, int y2, int c){
        b[x1][y1] += c;
        b[x1][y2 + 1] -= c;
        b[x2 + 1][y1] -= c;
        b[x2 + 1][y2 + 1] += c;
    }

    /**
     * 输入一个 n 行 m 列的整数矩阵，再输入 q 个操作，每个操作包含五个整数 x1,y1,x2,y2,c，其中 (x1,y1) 和 (x2,y2)
     * 表示一个子矩阵的左上角坐标和右下角坐标。
     * 每个操作都要将选中的子矩阵中的每个元素的值加上 c
     * 请你将进行完所有操作后的矩阵输出。
     * @param args
     */
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        m = scan.nextInt();
        q = scan.nextInt();
        for (int i = 1; i <= n; i ++)
            for (int j = 1; j <= m; j ++){
                a[i][j] = scan.nextInt();
                insert(i, j, i, j, a[i][j]);
            }

        while (q -- > 0){
            int x1 = scan.nextInt();
            int y1 = scan.nextInt();
            int x2 = scan.nextInt();
            int y2 = scan.nextInt();
            int c = scan.nextInt();
            insert(x1, y1, x2, y2, c);
        }

        for (int i = 1; i <= n; i ++)
            for (int j = 1; j <= m; j ++)
                b[i][j] += b[i][j - 1] + b[i - 1][j] - b[i - 1][j - 1];

        for (int i = 1; i <= n; i ++){
            for (int j = 1; j <= m; j ++)
                System.out.print(b[i][j] + " ");
            System.out.println();
        }
    }
}
