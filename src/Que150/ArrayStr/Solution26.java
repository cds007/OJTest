package Que150.ArrayStr;

public class Solution26 {
    public int removeDuplicates(int[] nums) {
        //输入：nums = [0,0,1,1,1,2,2,3,3,4]
        //输出：5, nums = [0,1,2,3,4]
        //原地修改数组，这题挺简单的，因为这个数组是排序好的，直接双指针就行
        int tIndex = 0;//填充指针
        for (int sIndex = 0; sIndex < nums.length; sIndex++) {//索引指针
            if (nums[sIndex]!=nums[tIndex]){
                nums[++tIndex] = nums[sIndex];
            }
        }
        return ++tIndex;
    }
}
