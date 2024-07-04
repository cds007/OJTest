package AcWingQuestion._01基础算法;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CodeTemplate05 {
    /**
     * 高精度算法模板2：高精度数与低精度数的乘法和除法
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

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String A = in.readLine();
        int b = Integer.valueOf(in.readLine());
        List<Integer> listA = new ArrayList<>();
        for(int i = A.length()-1;i>=0;i--) listA.add(A.charAt(i)-'0');

        List<Integer> listC = mul(listA,b);

        for(int i=listC.size()-1;i>=0;i--) System.out.print(listC.get(i));
    }
}
