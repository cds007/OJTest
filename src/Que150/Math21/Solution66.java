package Que150.Math21;

public class Solution66 {
    public int[] plusOne(int[] digits) {
        //这题我以前写过的，这个写的代码还是很妙的。就是每个都加1，如果最后的值不是0，那么说明到此为止了，直接return。如果是0，说明还没结束，你得进位。
        //其实只有99，999这种会溢出，所以最后的返回也很巧妙，新建一个长度+1的数组，全部都是0，只需修改第一位为1即可。
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0) return digits;
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }
}
