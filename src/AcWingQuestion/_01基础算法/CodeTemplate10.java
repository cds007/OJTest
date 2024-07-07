package AcWingQuestion._01基础算法;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Map;

public class CodeTemplate10 {
    /**
     * 双指针的算法模板，常见就是用两个指针维护一段区间
     */

    public static void main(String[] args) throws IOException {
        /**
         * 799. 最长连续不重复子序列
         * 5
         * 1 2 2 3 5
         * 3
         */
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(in.readLine());
        int[] q = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
        int[] s = new int[100001]; //用哈希表也可以的，用来存储每个数出现的次数
        int result = 0;
        for (int i = 0,j=0; i < n; i++) {
            s[q[i]]++;
            while (j<i&&s[q[i]]>1) s[q[j++]]--; //每一次的重复都只可能是i++带来的重复
            result = Math.max(result,i-j+1);
        }
        System.out.println(result);
        in.close();
    }
}
