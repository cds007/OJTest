package Que150.ArrayStr;

public class Solution238 {
    public int[] productExceptSelf(int[] nums) {
        //输入: nums = [-1,1,0,-3,3]
        //输出: [0,0,9,0,0]
        //输入: nums = [1,2,3,4]
        //输出: [24,12,8,6]
        //O(n)
        //双指针，左前缀数组和右前缀数组
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        int[] ret = new int[nums.length];
        left[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            left[i] = left[i-1]*nums[i-1];
        }
        right[nums.length-1]=1;
        for (int i = nums.length-2; i >= 0; i--) {
            right[i] = right[i+1]*nums[i+1];
        }
        for (int i = 0; i < nums.length; i++) {
            ret[i] = left[i]*right[i];
        }
        return ret;
        //这三个循环可以压缩为一个循环，题解也有，但是没这种好理解。
    }
}
