package AcWingQuestion._01基础算法;

import java.util.Scanner;
import java.io.*;
public class CodeTemplate02 {
    /**
     * 整数二分查找的模板：这两个模板可以应对绝大对数整数二分问题
     * 解释一下思想，二分的核心思想在于边界，将一个单调的序列依据(某种性质)分为两个区间，那么二分可以用来查找左区间的右端点和右区间的左端点。
     * 查找右区间的左端点可以依据模板一，查找左区间的右端点可以依据模板二。
     */
    boolean check(int x) {/* ... */ return true;} // 检查x是否满足某种性质
    // 区间[l, r]被划分成[l, mid]和[mid + 1, r]时使用：
    // 只需要注意这个mid，这也算个记忆的方式，当右区间的左端点也满足check时，那么显然接下来区间的边界是 r = mid，而不是mid-1，所以切分的区间是[l, mid]和[mid + 1, r]，所以check条件为true得到的是右区间
    int bsearch_1(int l,int r){
        while(l<r){
            int mid = l+r >> 1;
            if (check(mid)) r = mid;
            else l = mid + 1;
        }
        return l; //这个l和r是都可以的
    }
    // 区间[l, r]被划分成[l, mid - 1]和[mid, r]时使用：
    //这个查找的是左区间的右端点，显然就是check为true的是左区间，为true时，l = mid。
    int bsearch_2(int l,int r){
        while (l<r){
            int mid = l+r+1 >> 1;//这个需要注意，当 l = r-1时，如果mid不这样计算，那么会出现死循环的问题。
            if (check(mid)) l = mid;
            else r = mid -1;
        }
        return l;
    }

    public static void main(String[] args) throws IOException{
        //用BufferedReader要比Scanner快了1秒钟。
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] s1 = in.readLine().split(" ");
        int n = Integer.valueOf(s1[0]);
        int q = Integer.valueOf(s1[1]);
        int[] nums = new int[n];
        String[] s2 = in.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.valueOf(s2[i]);
        }
        while (q-->0){
            int k = Integer.valueOf(in.readLine());
            //先找左端点（右区间的左端点，模板1）
            int l = 0,r = n-1;
            while(l<r){
                int mid = l + r >>1;
                if (nums[mid]>=k) r = mid;
                else l  =mid +1;
            }
            int left = l;
            if (nums[left]!=k){
                System.out.println("-1 -1");
                continue;
            }
            l = 0;
            r=n-1;
            //找右端点（左区间的右端点，模板2）
            while(l<r){
                int mid = l + r +1 >>1;
                if (nums[mid]<=k) l = mid;
                else r = mid -1;
            }
            int right = r;
            System.out.println(left+" "+right);
        }
    }
}
