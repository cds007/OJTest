package Que150.Math21;

public class Solution9 {
    public boolean isPalindrome(int x) {
        //思考：这里大家可以思考一下，为什么末尾为 0 就可以直接返回 false
        //1221
        if (x < 0 || (x % 10 == 0 && x != 0)) return false;
        int revertedNumber = 0;
        while (x > revertedNumber) {//reverted是取了后面组成的数，x是原本的数整除之后的值。大于是考虑位数为奇数的情况
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }
        return x == revertedNumber || x == revertedNumber / 10;//除以10是考虑位数为奇数的情况
    }
}
