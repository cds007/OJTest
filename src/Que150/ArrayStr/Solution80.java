package Que150.ArrayStr;

public class Solution80 {
    public int removeDuplicates(int[] nums) {
        //输入：nums = [0,0,1,1,1,1,2,3,3]
        //输出：7, nums = [0,0,1,1,2,3,3]
        //小于等于2的直接输出即可，大于等于2的输出2个即可，所以可以用一个变量来保存出现次数
        //这个方法的时间复杂度不过On，一样的。
        int tIndex = 0;//待填充索引，不可跳跃
        int cnt = 0;//出现次数
        int temp = 100000;//保存上一个，用来刷新cnt
        for (int sIndex = 0; sIndex < nums.length; sIndex++) {
            if (nums[sIndex]!=temp){
                cnt=0;
                temp = nums[sIndex];
            }
            if (temp==nums[sIndex]&&cnt<2){
                nums[tIndex++] = nums[sIndex];
                cnt++;
            }
        }
        return tIndex;
    }
}
