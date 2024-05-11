package Que150.ArrayStr;

public class Solution12 {
    //我感觉这题挺简单的，就是一个排序加贪心，每次选最大的，而且这个算法时间复杂度只有O(1)。因为数据范围是给定的，最大循环次数不超过15次.
    public String intToRoman(int num) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            int val = values[i];
            String sym = symbols[i];
            while (num>=val){
                num-=val;
                sb.append(sym);
            }
            if (num==0){
                return sb.toString();
            }
        }
        return sb.toString();
    }
}
