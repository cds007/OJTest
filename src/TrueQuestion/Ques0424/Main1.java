package TrueQuestion.Ques0424;

import java.util.Arrays;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        //满二叉搜索树查找
        //构建满二叉搜索树的方法是用递归+二分法
        //这题我们可以不用构建，直接用二分查找即可
        Scanner in = new Scanner(System.in);
        String[] str = in.nextLine().split(" ");
        int[] nums = new int[str.length];
        for (int i = 0; i < str.length; i++) {
            nums[i] = Integer.valueOf(str[i]);
        }
        int target = in.nextInt();
        Arrays.sort(nums);
        int left = 0;int right = nums.length-1;
        StringBuilder sb = new StringBuilder();
        sb.append("S");
        boolean flag = false;
        while(left<right){
            // 1 2 3 4 5 6 7
            int mid = left + (right-left)/2;  //(left + right) / 2 可能会导致整数溢出。这段代码保证健壮性
            if (nums[mid]==target){
                sb.append("Y");
                flag = true;
                break;
            } else if (nums[mid]<target) {
                sb.append("R");
                left = mid+1;//因为mid已经被搜索过了，如果不是的话肯定不需要再用了，所以用mid+1
            }else{
                sb.append("L");
                right = mid-1;//同理
            }
        }
        if (!flag){
            if (nums[left]==target){
                sb.append("Y");
            }else{
                sb.append("N");
            }
        }
        System.out.println(sb);
    }
}
