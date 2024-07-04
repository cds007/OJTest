package AcWingQuestion._01基础算法;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CodeTemplate04 {
    /**
     * 高精度算法模板，高精度算法其实是C++需要考虑的问题，Java中有BigInteger和BigDecimal，python默认数就是无限大的。
     * 实现高精度算法主要使用Vector或者List来实现，下面用Java中的ArrayList来实现不同的高精度算法
     */

    /**
     * 1.高精度加法模板
     * @param A
     * @param B
     * @return
     */
    public static List<Integer> add(List<Integer> A, List<Integer> B) {
        List<Integer> listC = new ArrayList<>();
        int t = 0;
        for (int i = 0; i < A.size() || i < B.size(); i++) {
            if (i<A.size()) t+=A.get(i);
            if (i<B.size()) t+=B.get(i);
            listC.add(t%10);
            t/=10;
        }
        if (t==1) listC.add(1);
        return listC;
    }

    public static boolean cmp(List<Integer> A , List<Integer> B){
        //比较大小
        if (A.size()!=B.size()) return A.size()>B.size();
        for (int i = A.size()-1;i>=0;i--) {
            if (A.get(i)!=B.get(i))
                return A.get(i)>B.get(i);
        }
        return true;
    }

    /**
     * 2.高精度减法模板
     * @param A
     * @param B
     * @return
     */
    public static List<Integer> sub(List<Integer> A,List<Integer> B){
        List<Integer> listC = new ArrayList<>();
        //A肯定大于等于B，t是进位
        for (int i = 0,t = 0; i < A.size(); i++) {
            t = A.get(i)-t;
            if (i<B.size()) t = t - B.get(i);
            listC.add((t+10)%10);
            if (t<0) t = 1;
            else t = 0;
        }
        //去掉首位为0的情况,size是1，因为还要返回个0
        while (listC.size()>1&&listC.get(listC.size()-1)==0) listC.remove(listC.size()-1);
        return listC;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String A = in.readLine();//123456
        String B = in.readLine();
        List<Integer> listA = new ArrayList<>();//654321
        List<Integer> listB = new ArrayList<>();
        for (int i = A.length()-1; i >= 0; i--) listA.add(A.charAt(i)-'0');
        for (int i = B.length()-1; i >= 0; i--) listB.add(B.charAt(i)-'0');
        //加法
        List<Integer> listC = add(listA,listB);
        //减法
        if (cmp(listA,listB)){
            listC = sub(listA,listB);
        }else{
            listC = sub(listB,listA);
            System.out.print("-");
        }

        for(int i=listC.size()-1;i>=0;i--) System.out.print(listC.get(i));
    }
}
