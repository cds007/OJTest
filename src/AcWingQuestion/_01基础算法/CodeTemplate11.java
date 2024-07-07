package AcWingQuestion._01基础算法;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CodeTemplate11 {
    /**
     * 位运算代码模板：
     * 1.求n的二进制的第k位是几；n>>k&1
     * 2.lowbit操作：返回x的最后一位1 n&-n
     */
    public static void main(String[] args) throws IOException {
        /**
         * 801. 二进制中1的个数
         * 给定一个长度为 n 的数列，请你求出数列中每个数的二进制表示中 1 的个数。
         * 5
         * 1 2 3 4 5
         * 1 1 2 1 2
         */
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(in.readLine());
        int[] q = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
        for (int i = 0; i < n; i++) {
            int k = q[i];
            int cnt = 0;
            while (k>0){
                k-=k&-k;
                cnt++;
            }
            //System.out.print(Integer.bitCount(k)+" "); //也可以直接用这个方法
            System.out.print(cnt+" ");
        }
    }
}
