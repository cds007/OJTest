package Que150.DoublePoint;

public class Solution125 {
    public boolean isPalindrome(String s) {
        //输入: s = "A man, a plan, a canal: Panama"
        //输出：true
        //解释："amanaplanacanalpanama" 是回文串。
        //思路:1.用StringBuilder来接收字符串，如果反转之后相等那么是回文串
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isUpperCase(ch)){
                //转小写
                ch = (char)(ch+32);
                sb.append(ch);
            } else if (Character.isLowerCase(ch)) {
                sb.append(ch);
            } else if (Character.isDigit(ch)) {
                sb.append(ch);
            }
        }
        String str = sb.toString();
        String str2 = sb.reverse().toString();
        if (str.equals(str2)){
            return true;
        }else{
            return false;
        }
    }
}
