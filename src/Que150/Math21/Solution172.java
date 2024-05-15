package Que150.Math21;

public class Solution172 {
        public int trailingZeroes(int n) {
            //只需要计算1到n中质因子5和质因子2的最小值就行了，因为质因子2个数肯定大于5，所以只需要计算5的个数就行。
            int ans = 0;
            for (int i = 5; i <= n; i += 5) {
                for (int x = i; x % 5 == 0; x /= 5) {//5，25，100.125....
                    ++ans;
                }
            }
            return ans;
        }
}
