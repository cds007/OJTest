package Que150.Math21;

public class Solution69 {
    public int mySqrt(int x) {
        //袖珍计算器
        if (x == 0) {
            return 0;
        }
        int ans = (int) Math.exp(0.5 * Math.log(x));
        return (long) (ans + 1) * (ans + 1) <= x ? ans + 1 : ans;
    }
}
