package Que150.ArrayStr;

import java.util.*;

public class Solution151 {
    public String reverseWords(String s) {
        //1.去除两边的多余空格
        //2.反转整个字符串
        //3.反转单词
        s = s.trim();
        List<String> list = Arrays.asList(s.split("\\s+"));
        Collections.reverse(list);
        return String.join(" ",list);
    }

    public static void main(String[] args) {
        String s = "a good   example";
        Solution151 solution151 = new Solution151();
        System.out.println(solution151.reverseWords(s));
    }
}
