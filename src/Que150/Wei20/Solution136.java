package Que150.Wei20;

public class Solution136 {
    public int singleNumber(int[] nums) {
        int single = 0;
        for (int num : nums) {//我想起来了，这道题，就是做异或运算，然后相同的都会被消掉。
            single ^= num;
        }
        return single;
    }
}
