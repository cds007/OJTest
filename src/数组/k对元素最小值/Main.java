package 数组.k对元素最小值;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //这道题还是挺难的我感觉。题目理解上就比较绕。其次算法的实现也比较复杂。算法实现的语法我也是不太熟悉，搜了一些资料才能看懂。
        //1.细节：优先队列：每次加入都会进行排序；
        //2.细节：自定义排序器：大于，小于，等于的情况；用lamba表达式写。小于0则第一个对象排在第二个对象之前
        //3.细节：如何避免重复元素：只需要管nums2就行了，nums1的个数已经确定了不会变了。
        //4.其实：这道题遍历On2再排序，当然也可以做，这个算法也没提升多少。大概是O(nlogn)
        Scanner in = new Scanner(System.in);
        int len1 = in.nextInt();
        int[] nums1 = new int[len1];
        for (int i = 0; i < len1; i++) {
            nums1[i] = in.nextInt();
        }
        int len2 = in.nextInt();
        int[] nums2 = new int[len2];
        for (int i = 0; i < len2; i++) {
            nums2[i] = in.nextInt();
        }
        int k = in.nextInt();
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a, b) -> {
            return (nums1[a[0]] + nums2[a[1]]) - (nums1[b[0]] + nums2[b[1]]);
        });
        int m = Math.min(len1,k);
        for (int i = 0; i < m; i++) {
            priorityQueue.add(new int[]{i,0});//第二个索引为i
        }
        int res = 0;
        while(k!=0){
            //先计算队列头的值
            int[] ids = priorityQueue.poll();
            res+=nums1[ids[0]];
            res+=nums2[ids[1]];
            if (ids[1]<len2-1){
                int [] n = new int[]{ids[0],ids[1]+1};
                priorityQueue.add(n);
            }
            k--;
        }
        System.out.println(res);
    }
}
