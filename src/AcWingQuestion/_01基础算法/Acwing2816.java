package AcWingQuestion._01基础算法;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Acwing2816 {
    /**
     * 2816. 判断子序列
     * 给定一个长度为 n 的整数序列 a1,a2,…,an 以及一个长度为 m 的整数序列 b1,b2,…,bm。
     * 请你判断 a序列是否为 b序列的子序列。
     * 子序列指序列的一部分项按原有次序排列而得的序列，例如序列 {a1,a3,a5}是序列 {a1,a2,a3,a4,a5} 的一个子序列。
     * 3 5
     * 1 3 5
     * 1 2 3 4 5
     * Yes
     */
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int[] num1 = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
        int n = num1[0],m = num1[1];
        int[] a = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
        int[] b = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
        int i =0,j=0;
        while (i<n&&j<m){
            if (a[i]==b[j]){
                i++;j++;
            }else{
                j++;
            }
        }
        if (i==n) System.out.println("Yes");
        else System.out.println("No");
    }
}
