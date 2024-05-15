package Que150.Math21;

public class Solution50 {
    public double myPow(double x, int n) {
        //快速幂+回溯算法
        long N = n;
        return N >= 0 ? quickMul(x, N) : 1.0 / quickMul(x, -N);
    }

    public double quickMul(double x, long N) {
        //带入x的13次方试试
        if (N == 0) {
            return 1.0;
        }
        double y = quickMul(x, N / 2);
        return N % 2 == 0 ? y * y : y * y * x;
    }
}
