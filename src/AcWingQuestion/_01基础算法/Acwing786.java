package AcWingQuestion._01基础算法;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Acwing786 {
    /**
     * 第k个数 ： 快排
     */
    public static int num = 0;

    /**
     * 这个是我写的方法，实际上我这个并不是很正确，因为我这个方法无论如何都会排序完，但其实没必要全部都排序的
     * @param q
     * @param l
     * @param r
     * @param k
     */
    public static void quick_sort(int[] q,int l,int r,int k){
        if (l>=r){
            //这里不能直接return，可能会漏掉只有一个的情况
            if (l==k) num = q[l];
            return;
        }
        int x = q[l+r>>1],i=l-1,j=r+1;
        while (i<j){
            while (q[++i]<x);
            while (q[--j]>x);
            if (i<j){
                int temp = q[i];
                q[i] = q[j];
                q[j] = temp;
            }
        }
        if (q[j]==x&&j==k) num = q[j];
        if (q[j+1]==x&&j+1==k) num = q[j+1];
        quick_sort(q,l,j,k);
        quick_sort(q,j+1,r,k);
    }

    /**
     * 题解版本 快100ms 时间复杂度是2n，n+n/2+n/4
     * @param arr
     * @param left
     * @param right
     * @param k
     * @return
     */
    public static int quickSort(int[] arr,int left,int right,int k){
        if(left >= right) return left; //k永远在l和r区间内
        int x = arr[(left + right) / 2],i = left - 1,j = right + 1;
        while(i < j){
            while(arr[++i] < x);
            while(arr[--j] > x);
            if(i < j){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int sl = j - left + 1;
        if(k <= sl) return quickSort(arr,left,j,k); //细节范围是left，j
        else return quickSort(arr,j+1,right,(k-sl)); //这个是细节k-sl，因为k不是绝对的，k是相对位置了，当左端点变成j+1，k相对于j+1就是k-sl
    }

    public static void main(String[] args) throws IOException {
        /**
         * 给定一个长度为 n 的整数数列，以及一个整数 k，请用快速选择算法求出数列从小到大排序后的第 k 个数。
         * 5 3
         * 2 4 1 5 3
         * 3
         */
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] str1 = in.readLine().split(" ");
        int n = Integer.valueOf(str1[0]),k = Integer.valueOf(str1[1]);
        int[] q = new int[n];
        String[] str2 = in.readLine().split(" ");
        for(int i=0;i<n;i++) q[i] = Integer.valueOf(str2[i]);

//        quick_sort(q,0,n-1,k-1); //下标从0开始
//        System.out.println(num);

        int result = quickSort(q,0,n-1,k);
        System.out.println(q[result]);
    }
}
