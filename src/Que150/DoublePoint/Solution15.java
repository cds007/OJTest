package Que150.DoublePoint;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution15 {
    public List<List<Integer>> threeSum(int[] nums) {
        //输入：nums = [-1,0,1,2,-1,-4]
        //输出：[[-1,-1,2],[-1,0,1]]
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) return list;
            //对i去重
            //细节下面这个逻辑在000的样例中会下标越界
            //while(i>=1&&nums[i]==nums[i-1]) i++; //说明i之前已经被加过了
            //得改成这样：
            if (i >= 1 && nums[i] == nums[i - 1]) continue;
            int left = i + 1;
            int right = nums.length - 1;
            //细节不能等于，不然就是同一个数字了
            while (left < right) {
                if (nums[i] + nums[left] + nums[right] > 0) right--;
                else if (nums[i] + nums[left] + nums[right] < 0) left++;
                else {
                    //先保存结果
                    List<Integer> retList = new ArrayList<>();
                    retList.add(nums[i]);
                    retList.add(nums[left]);
                    retList.add(nums[right]);
                    list.add(retList);
                    //对left和right去重
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    //细节，最后还要移动
                    right--;
                    left++;
                }
            }
        }
        return list;
    }
}
