package Que150.HaXi;

public class Solution383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        //1.思路：遍历maga，哈希存放，遍历ran，哈希获取，时间复杂度O(n+m)
        //2.题解：思路一样的，用哈希数组来存，并且加上长度的判断剪枝，效率会高一点，我们按题解自己写一遍代码，简单！
        if (ransomNote.length()>magazine.length()) return false;
        int[] chars = new int[26];
        for (char ch :
                magazine.toCharArray()) {
            chars[ch-'a']++;
        }
        for (char ch :
                ransomNote.toCharArray()) {
            chars[ch - 'a']--;
            if (chars[ch-'a']<0) return false;
        }
        return true;
    }
}
