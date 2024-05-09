package Que150.ArrayStr;

public class Solution27 {
    public int removeElement(int[] nums, int val) {
        //O(1)的复杂度
        //移除元素
        //输入：nums = [3,2,2,3], val = 3
        //输出：2, nums = [2,2]
        //这题我他喵好像做过，就是用个双指针，一个用来记录应该填充的下标，一个用来查找索引的元素，没想到我记忆力还可以啊，这题应该是好久之前做的了
        int ret = 0;
        int tIndex = 0;//填充下标
        for (int i = 0; i < nums.length; i++) {//i就是搜索下标
            if (nums[i]!=val){
                nums[tIndex++] = nums[i];
                ret++;
            }
        }
        return ret;
    }
}
