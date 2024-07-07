package Que150;

public class Solution540 {
    public int singleNonDuplicate(int[] nums) {
        //先是偶奇，然后是奇偶
        //nums = [1,1,2,3,3,4,4,8,8]
        int l = 0,r = nums.length-1;
        while (l<r){
            //在目标值左边的数的前节点下标都是偶数，右边的数的前节点下标都是奇数，所以我们默认到偶数，来判断是在目标值左边还是右边
            int mid = l+r>>1;
            if (mid%2==1) mid--;
            if (nums[mid]!=nums[mid+1]) r = mid;
            else l = mid+2; //保证数据的一致性
        }
        return nums[l];
    }
}
