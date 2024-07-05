package AcWingQuestion._01基础算法;

import com.sun.jdi.IntegerValue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class CodeTemplate06 {

    /**
     * 前缀和打卡模板
     * 一维前缀和:S[i] = a[1] + a[2] + ... a[i] , a[l] + ... + a[r] = S[r] - S[l - 1]
     */


    public static void main(String[] args) throws IOException {
        /**
         * 795. 前缀和
         * 输入一个长度为 n 的整数序列。
         * 接下来再输入 m 个询问，每个询问输入一对 l,r
         * 对于每个询问，输出原序列中从第 l 个数到第 r 个数的和。
         * 5 3
         * 2 1 3 6 4
         * 1 2
         * 1 3
         * 2 4
         *
         * 3
         * 6
         * 10
         */
        //BufferedReader 3000多ms，用Scanner要5000多ms。
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] str1 = in.readLine().split(" ");
        int n = Integer.valueOf(str1[0]);
        int m = Integer.valueOf(str1[1]);
        int[] a = new int[n+1];
        int[] S = new int[n+1];
        S[0] = 0;//默认为0
        String[] str2 = in.readLine().split(" ");
        for(int i = 1;i<=n;i++) a[i] = Integer.valueOf(str2[i-1]); // 前缀和最好从1开始计算
        for(int i = 1;i<=n;i++) S[i] = S[i-1] + a[i];
        while (m--!=0){
            String[] str3 = in.readLine().split(" ");
            int l = Integer.valueOf(str3[0]),r = Integer.valueOf(str3[1]);
            System.out.println(S[r]-S[l-1]);
        }
    }

}
