package Que150.SlidingWindows;

public class Solution209 {
    public int minSubArrayLen(int target, int[] nums) {
        //输入：target = 7, nums = [2,3,1,2,4,3]
        //输出：2
        //解释：子数组 [4,3] 是该条件下的长度最小的子数组。
        //用快慢指针（也可以看做是滑动窗口）来做，先让快指针遍历，如果sum大于等于target了，就让慢指针往后走，直到快指针到末尾
        int i=0,j=0,sum=0,result = Integer.MAX_VALUE;
        for(;j<nums.length;j++){
            sum+=nums[j];
            while (sum>=target){
                if (j-i+1<result) result = j-i+1;
                sum-=nums[i];
                i++;
            }
        }
        return result==Integer.MAX_VALUE?0:result;
    }
}
