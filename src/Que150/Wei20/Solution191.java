package Que150.Wei20;

public class Solution191 {
        public int hammingWeight(int n) {
            int ret = 0;
            for (int i = 0; i < 32; i++) {
                if ((n & (1 << i)) != 0) {//左移，然后与操作看看当前位是否为1
                    ret++;
                }
            }
            return ret;
        }
}
