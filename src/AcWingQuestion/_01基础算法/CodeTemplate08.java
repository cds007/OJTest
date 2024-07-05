package AcWingQuestion._01基础算法;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CodeTemplate08 {
    /**
     * 差分就是前缀和的逆运算，找到一个b数组使得a数组是b数组的前缀和
     */
    public static void insert(int l,int r,int c,int[] b){
        b[l]+=c;
        b[r+1]-=c;
    }
    public static void main(String[] args) throws IOException {
        /**
         * 输入一个长度为 n的整数序列。
         * 接下来输入 m个操作，每个操作包含三个整数 l,r,c，表示将序列中 [l,r] 之间的每个数加上 c
         * 请你输出进行完所有操作后的序列。
         * 6 3
         * 1 2 2 1 2 1
         * 1 3 1
         * 3 5 1
         * 1 6 1
         * 3 4 5 3 4 2
         */
        //有Scanner就会慢，还是得这样写快一点，但是编码的时候就慢了
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] str1 = in.readLine().split(" ");
        int n = Integer.valueOf(str1[0]),m = Integer.valueOf(str1[1]);
        int[] a = new int[n+2];
        int[] b = new int[n+2];
        a[0]=0;b[0]=0;
        String[] str2 = in.readLine().split(" ");
        for(int i=1;i<=n;i++) a[i] = Integer.valueOf(str2[i-1]);
        for(int i=1;i<=n;i++) insert(i,i,a[i],b);//构造差分数组
        //加上c
        while (m-->0){
            String[] str3 = in.readLine().split(" ");
            int l = Integer.valueOf(str3[0]),r = Integer.valueOf(str3[1]),c = Integer.valueOf(str3[2]);
            insert(l,r,c,b);
        }
        //求前缀和
        for (int i = 1; i <=n; i++) {
            b[i]+=b[i-1];
        }
        for (int i = 1; i <= n; i++) {
            System.out.print(b[i]+" ");
        }
    }
}
