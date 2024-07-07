package AcWingQuestion._01基础算法;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class CodeTemplate13 {
    /**
     * 区间合并
     */
    public static int merge(List<Map.Entry<Integer,Integer>> segs){
        List<Map.Entry<Integer,Integer>> res = new ArrayList<>();
        int st = Integer.MIN_VALUE, ed = Integer.MIN_VALUE;
        for (Map.Entry<Integer, Integer> entry :
                segs) {
            if (ed<entry.getKey()){
                if (st!=Integer.MIN_VALUE) res.add(new AbstractMap.SimpleEntry<>(st,ed));
                st = entry.getKey();
                ed = entry.getValue();
            }else {
                ed = Math.max(ed,entry.getValue());
            }
        }
        //最后一个也放进去
        if (st!=Integer.MIN_VALUE) res.add(new AbstractMap.SimpleEntry<>(st,ed)); //if是防止segs为空
        return res.size();
    }
    public static void main(String[] args) throws IOException {
        /**
         * 给定 n 个区间 [li,ri] ，要求合并所有有交集的区间。
         * 注意如果在端点处相交，也算有交集。输出合并完成后的区间个数。
         * 例如：[1,3]和 [2,6] 可以合并为一个区间 [1,6]。
         * 5
         * 1 2
         * 2 4
         * 5 6
         * 7 8
         * 7 9
         * 3
         */
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(in.readLine());
        List<Map.Entry<Integer,Integer>> segs = new ArrayList<>();
        while (n-->0){
            int[] a = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
            segs.add(new AbstractMap.SimpleEntry<>(a[0],a[1]));
        }
        //排序
        segs.sort((a,b)->{
            //先按左端点升序排序再按右端点升序排序
            if (a.getKey()!=b.getKey())
                return a.getKey()-b.getKey();
            if (a.getValue()!=b.getValue())
                return a.getValue()-b.getValue();
            return 0;
        });
        System.out.println(merge(segs));
        in.close();
    }
}
