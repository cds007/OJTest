package AcWingQuestion._01基础算法;

import java.util.*;

public class CodeTemplate01 {
    /**
     * 快速排序和归并排序模板
     */

    /**
     * 1.快速排序算法模板
     * 测试用例：
     * 5
     * 3 1 2 4 5
     * @param q
     * @param l
     * @param r
     */
    public static void quick_sort(int[] q,int l,int r){
        if (l>=r) return; //l==r也可以的，看个人习惯
        int x = q[l+r>>1],i = l-1,j = r+1; //这个是模板，先把i和j放到两边外，对应下面的++i和--j
        while (i<j){
            while (q[++i]<x);
            while (q[--j]>x);
            if (i<j){
                int temp = q[i];
                q[i] = q[j];
                q[j] = temp;
            }
        } // 第一轮结束之后，左边的都是小于等于x的，右边的都是大于x的。
        quick_sort(q,l,j); // 这里当然也可以用 (q,l,i-1)，但是对应的，上面不能写 x = q[l]，因为可能会死循环，比如 [1,2]
        quick_sort(q,j+1,r);
    }

    /**
     * 2.归并排序算法模板
     * 测试用例：
     * 5
     * 3 1 2 4 5
     * @param q
     * @param l
     * @param r
     */
    public static void merge_sort(int[] q,int l,int r){
        if (l>=r) return;
        int mid = l+r>>1;
        merge_sort(q,l,mid);
        merge_sort(q,mid+1,r);
        //合并
        int[] temp = new int[r-l+1];
        int i = l,j=mid+1,k=0;
        while(i<=mid&&j<=r){
            if (q[i]<=q[j]) temp[k++] = q[i++];
            else temp[k++] = q[j++];
        }
        while (i<=mid) temp[k++] = q[i++];
        while (j<=r) temp[k++] = q[j++];
        for(i=l,k=0;i<=r;i++,k++) q[i] = temp[k];
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int N = (int)1e6;
        int[] q = new int[N];
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            q[i] = in.nextInt();
        }
        //quick_sort(q,0,n-1);
        merge_sort(q,0,n-1);
        for (int i = 0; i < n; i++) {
            System.out.print(q[i]+" ");
        }
    }
}
