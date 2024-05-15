package Que150.Wei20;

public class Solution201 {
        public int rangeBitwiseAnd(int m, int n) {
            int shift = 0;
            // 找到公共前缀
            //1.先全部右移直到相同，那么找到公共左前缀了，然后再左移相应的位数，就是答案
            while (m < n) {
                m >>= 1;
                n >>= 1;
                ++shift;
            }
            return m << shift;
        }
}
