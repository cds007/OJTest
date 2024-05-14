package Que150.DoublePoint2;

public class Solution392 {
    public boolean isSubsequence(String s, String t) {
        //我美其名曰是动态规划，其实我上次写的那个算法就是个双指针算法，我笑死。
        int left = 0;int right = 0;
        while (left<s.length()&&right<t.length()){
            char chL = s.charAt(left);
            char chR = t.charAt(right);
            if (chL==chR){
                left++;
            }
            right++;
        }
        if (left==s.length()) return true;
        return false;
    }
}
