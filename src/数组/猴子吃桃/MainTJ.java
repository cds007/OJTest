package 数组.猴子吃桃;

import java.util.Scanner;

public class MainTJ {
    public static void main(String[] args) {
        //其实这题本质上就是个查找问题，也不是很难。直接用二分查找的话复杂度就是O(nLogm)感觉比我的方法稍微快一点点，也没快很多其实。
        Scanner in = new Scanner(System.in);
        String[] str = in.nextLine().split(" ");
        int[] nums = new int[str.length - 1];
        for (int i = 0; i < str.length-1; i++) {//异常情况
            for (int j = 0; j < str[i].length(); j++) {
                char ch = str[i].charAt(j);
                if (ch>='0'&&ch<='9'){
                    continue;
                }else{
                    System.out.println(-1);
                    return;
                }
            }
            nums[i] = Integer.valueOf(str[i]);
        }
        int N = Integer.valueOf(str[str.length-1]);
        int left = 1;
        int right = nums[nums.length-1];
        while(left<right){
            //直接二分查找即可，就是个最简单的查找算法
            int mid = left + (right-left)/2;
            if (getTime(nums,mid)>N){
                left = mid+1;
            }else{
                right = mid;
            }
        }
        System.out.println(left);
    }

    public static int getTime(int[] arr,int rad){
        int time = 0;
        for (int a :
                arr) {
            if (a%rad!=0){
                time+=a/rad+1;
            }else{
                time+=a/rad;
            }
        }
        return time;
    }
}
