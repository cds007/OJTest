package 栈和队列.滑动窗口最大值;

import java.util.Scanner;

public class MainTJ2 {
    public static void main(String[] args) {
        //双指针法
        Scanner in = new Scanner(System.in);
        int left = 0;
        int right = 0;
        int N = in.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = in.nextInt();
        }
        int M = in.nextInt();
        int ans = 0;
        int max = 0;
        while(right<arr.length){
            ans+=arr[right];
            right++;
            if (right-left>=M){
                //0-3
                max = Math.max(ans,max);
                ans -= arr[left];
                left++;
            }
        }
        System.out.println(max);
    }
}
