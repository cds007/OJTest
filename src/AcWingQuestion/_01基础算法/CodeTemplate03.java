package AcWingQuestion._01基础算法;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CodeTemplate03 {

    public static boolean check(double x) {/* ... */ return true;} // 检查x是否满足某种性质

    /**
     * 浮点数二分查找的模板
     * @param a
     * @param b
     * @param c
     * @return
     */
    public static double flSearch(double a,double b,double c){
        double l=a,r=b;
        while(r-l>c){
            double mid=(l+r)/2;
            if(check(mid)) l=mid;
            else r=mid;
        }
        return l;
    }


    public static void main(String[] args) throws IOException {
        /**
         * 790. 数的三次方根
         * 给定一个浮点数 n，求它的三次方根。共一行，包含一个浮点数，表示问题的解。
         * 注意，结果保留 6位小数。 −10000≤n≤10000
         */
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));//用BufferedReader比Scanner快一倍！
        double n = Double.valueOf(in.readLine());
        double l = -10000,r = 10000;
        while(r-l>1e-8){ // 这里是经验值，如果是保留6位，那么取1e-8，4位取1e-6，多两位即可。
            double mid = (l+r)/2;
            if (mid*mid*mid>=n) r=mid;
            else l = mid;
        }
        //另一种写法：循环100次，相当于除以2的100次方。
//        for (int i = 0; i < 100; i++) {
//            double mid = (l+r)/2;
//            if (mid*mid*mid>=n) r=mid;
//            else l = mid;
//        }
        System.out.printf("%.6f",l);
    }
}
