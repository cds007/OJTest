package AcWingQuestion._01基础算法;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CodeTemplate05 {
    /**
     * 高精度算法模板2：高精度数与低精度数的乘法和除法
     */

    /**
     * 3.高精度乘法
     * @param listA
     * @param b
     * @return
     */
    public static List<Integer> mul(List<Integer> listA , int b){
        List<Integer> listC = new ArrayList<>();
        int t = 0;//t是进位，不一定是1了。
        for (int i = 0; i < listA.size() || t != 0; i++) { //t不等于0，因为可能超出进位，会有这种情况
            if (i<listA.size()) t += listA.get(i)*b;
            listC.add(t%10);
            t/=10;
        }
        while (listC.size()>1&&listC.get(listC.size()-1)==0) listC.remove(listC.size()-1); //12345 0 乘法是会有多个0的情况出现的
        return listC;
    }

    /**
     * 4.高精度除法：A / b , 商是listC , 余数是r引用类型传参
     * @param listA
     * @param b
     * @return
     */
    public static List<Integer> div(List<Integer> listA, int b){ //A:4321
        List<Integer> listC = new ArrayList<>();
        int r = 0;
        //除法是从前往后计算的，这和加法、减法、乘法都不一样，所以注意最后的输出要转换一下
        for (int i = listA.size()-1; i >=0 ; i--) {
            r = r * 10 + listA.get(i);//进被除数的下一位
            listC.add(r/b);//除法
            r%=b;
        }
        //反转C
        Collections.reverse(listC);
        //去首位0
        while (listC.size()>1&&listC.get(listC.size()-1)==0) listC.remove(listC.size()-1);
        listC.add(r);//把余数加进来，在外面去掉
        return listC;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String A = in.readLine();
        int b = Integer.valueOf(in.readLine());
        List<Integer> listA = new ArrayList<>();
        for(int i = A.length()-1;i>=0;i--) listA.add(A.charAt(i)-'0');

        List<Integer> listC = mul(listA,b); //乘法

        listC = div(listA,b); //除法
        int r = listC.get(listC.size()-1);
        listC.remove(listC.size()-1);

        for(int i=listC.size()-1;i>=0;i--) System.out.print(listC.get(i));
        System.out.println();
        System.out.println(r);
    }
}
