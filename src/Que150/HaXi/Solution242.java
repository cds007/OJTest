package Que150.HaXi;

public class Solution242 {
    public boolean isAnagram(String s, String t) {
        //秒了
        int[] hash = new int[26];
        if (s.length()!=t.length()) return false;
        for(int i=0;i<s.length();i++){
            hash[s.charAt(i)-'a']++;
            hash[t.charAt(i)-'a']--;
        }
        for(int i=0;i<hash.length;i++){
            if (hash[i]!=0) return false;
        }
        return true;
    }
}
