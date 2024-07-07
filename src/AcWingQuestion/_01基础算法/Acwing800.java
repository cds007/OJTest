package AcWingQuestion._01基础算法;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Acwing800 {
    /**
     * 800. 数组元素的目标和 双指针
     * 给定两个升序排序的有序数组 A 和 B，以及一个目标值 x。
     * 数组下标从 0 开始。请你求出满足 A[i]+B[j]=x的数对 (i,j) 。
     * 数据保证有唯一解。
     * 4 5 6
     * 1 2 4 7
     * 3 4 6 8 9
     * 1 1
     */
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int[] a1 = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
        int n = a1[0],m = a1[1],x = a1[2];
        int[] A = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
        int[] B = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
        //O(n)的时间复杂度，一个从头，一个从尾的双指针
        for (int i = 0,j=m-1; i < n; i++) {
            while (j>=0&&A[i]+B[j]>x) j--;
            if (j>=0&&A[i]+B[j]==x) System.out.println(i+" "+j);
        }
    }
}
