package Que150.ArrayStr;

public class Solution189 {
    public void rotate(int[] nums, int k) {
        //输入: nums = [1,2,3,4,5,6,7], k = 3
        //输出: [5,6,7,1,2,3,4]
        //空间换时间,O(n)的时间复杂度即可
        int pos = (nums.length-k%nums.length);//后指针
        int[] nums2 = new int[nums.length];
        int cnt = 0;
        for (int i = pos; i < nums.length; i++) {
            nums2[cnt++] = nums[i];
        }
        for (int i = 0; i < pos; i++) {
            nums2[cnt++] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums2[i];
        }
    }
}
