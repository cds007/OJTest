package Que150.Wei20;

public class Solution190 {
    public int reverseBits(int n) {
        int rev = 0;
        for (int i = 0; i < 32 && n != 0; ++i) {
            rev |= (n & 1) << (31 - i);//与操作获取最后一位，左移使得变成最高位，然后或操作使得加入到结果中
            n >>>= 1;
        }
        return rev;
    }
}
