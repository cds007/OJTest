package 栈和队列.滑动窗口最大值;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class MainTJ1 {
    public static void main(String[] args) {
        //双端队列法
        Scanner in = new Scanner(System.in);
        Deque<Integer> deque = new LinkedList<>();//这才是滑动窗口，时间复杂度为On
        int N = in.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = in.nextInt();
        }
        int M = in.nextInt();
        int ans = 0;//每一轮的值
        int max = 0;//返回
        for (int i = 0; i < arr.length; i++) {
            ans+=arr[i];
            deque.addLast(arr[i]);
            if (deque.size()>=M){
                max = Math.max(ans,max);
                ans-=deque.getFirst();
                deque.removeFirst();
            }//这里写的比题解好一点
        }
        System.out.println(max);
    }
}
