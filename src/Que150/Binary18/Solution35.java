package Que150.Binary18;

public class Solution35 {
    public int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int left = 0,right = n-1,ans = n;
        while(left<=right){
            int mid = (right-left)/2+left;
            if (target<nums[mid]){
                ans = mid;//这个很关键，因为可能有不存在的需要插入
                right = mid-1;
            }else if (target>nums[mid]){
                left = mid+1;
            }else{
                ans = mid;
                break;
            }
        }
        return ans;
    }
}
