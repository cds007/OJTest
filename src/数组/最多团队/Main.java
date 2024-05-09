package 数组.最多团队;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //排序，跟题解的思路差不多。On的复杂度，也是优化了一点了。
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = in.nextInt();
        }
        int M = in.nextInt();
        Arrays.sort(arr);
        int sum = 0;
        int left = 0;
        int right = arr.length-1;
        while(left<right){
            if (arr[right]>=M){
                sum++;
            }else{
                for (int i = left; i < right; i++) {
                    if (arr[i]+arr[right]>=M){
                        sum++;
                        left = i+1;
                        break;
                    }
                }
            }
            right--;
        }
        System.out.println(sum);
    }
}
