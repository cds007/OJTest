package Que150.Wei20;

public class Solution67 {
    class Solution {
        public String addBinary(String a, String b) {
            //朴素的思想
            StringBuilder ans = new StringBuilder();
            int ca = 0;
            for(int i = a.length() - 1, j = b.length() - 1;i >= 0 || j >= 0; i--, j--) {
                int sum = ca;
                sum += i >= 0 ? a.charAt(i) - '0' : 0;
                sum += j >= 0 ? b.charAt(j) - '0' : 0;
                ans.append(sum % 2);
                ca = sum / 2;
            }
            ans.append(ca == 1 ? ca : "");
            return ans.reverse().toString();
        }
    }
}
