package 栈和队列.滑动窗口最大值;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        List<Integer> list = new ArrayList<>();//时间复杂度On2
        //我这个方法其实不对，因为根本没有用到滑动窗口，滑动窗口需要保留窗口内的值，然后进行removeFirst的操作，可以用双端队列或者双指针来实现。
        //题解的复杂度是On
        for (int i = 0; i < N; i++) {
            list.add(in.nextInt());
        }
        int M = in.nextInt();
        int max = 0;
        for (int i = 0; i < list.size()-M+1; i++) {
            int sum = 0;
            for (int j = 0; j < M; j++) {
                sum+=list.get(i+j);
            }
            max = Math.max(sum,max);
        }
        System.out.println(max);
    }
}
