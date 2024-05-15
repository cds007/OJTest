package Que150.Wei20;

public class Solution137 {
        public int singleNumber(int[] nums) {
            // 哈希表也可以做，但是空间是O(n)的。
            // 这个是统计每个数的每一位值，如果取余3不等于0，说明当前的（答案）的位数为1，否则当前的（答案）的位数值为0.妙啊！
            int ans = 0;
            for (int i = 0; i < 32; ++i) {
                int total = 0;
                for (int num : nums) {
                    total += ((num >> i) & 1);
                }
                if (total % 3 != 0) {
                    ans |= (1 << i);
                }
            }
            return ans;
        }
}
