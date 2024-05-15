package Que150.Kadane17;

public class Solution53 {
        public int maxSubArray(int[] nums) {// dp滚动数组
            // dp[i] = max(dp[i - 1] + nums[i], nums[i]);
            int pre = 0, maxAns = nums[0];
            for (int x : nums) {
                pre = Math.max(pre + x, x);
                maxAns = Math.max(maxAns, pre);
            }
            return maxAns;
        }
}
