package AcWingQuestion._01基础算法;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Acwing788 {
    /**
     * 逆序对的数量 归并排序
     * 给定一个长度为 n 的整数数列，请你计算数列中的逆序对的数量。
     * 6
     * 2 3 4 5 6 1
     * 5
     * 数据量十万，最坏的情况可能产生5*109这么多对，用long来存储
     */
    public static long merge_sort(int[] q,int l,int r){
        if (l>=r) return 0;//个数
        int mid = l+r>>1;
        long res = merge_sort(q,l,mid)+merge_sort(q,mid+1,r);
        int[] temp = new int[r-l+1];
        int k=0,i=l,j=mid+1;
        while (i<=mid&&j<=r){
            if (q[i]<=q[j]) temp[k++] = q[i++];
            else{
                //可以计算逆序对了
                res += mid - i+1; //这个是核心，i是第一个比此j大的，所以接下来的数都比j大，那么只需要计算mid-i+1就是都比j大的了
                temp[k++] = q[j++];
            }
        }
        while (i<=mid) temp[k++] = q[i++];
        while (j<=r) temp[k++] = q[j++];
        for(i=l,k=0;i<=r;i++,k++) q[i] = temp[k];
        return res;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(in.readLine());
        int[] q = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
        long result = merge_sort(q,0,n-1);
        System.out.println(result);
        in.close();
    }
}
