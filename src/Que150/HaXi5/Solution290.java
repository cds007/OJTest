package Que150.HaXi5;

import java.util.HashMap;
import java.util.Map;

public class Solution290 {
    public boolean wordPattern(String pattern, String s) {
        //1.我的想法：这跟刚刚那题有点像啊。这题是 字符<->字符串。那还是一样的呗，用一个Character,String来存储。
        //2.题解：emm，写的有点复杂，这里我们自己写一下吧
        Map<Character,String> c2s = new HashMap<>();
        Map<String,Character> s2c = new HashMap<>();
        String[] strArr = s.split(" ");
        if (strArr.length!=pattern.length()) return false;
        int len = pattern.length();
        for (int i = 0; i < len; i++) {
            char ch = pattern.charAt(i);
            String str = strArr[i];
            if (c2s.containsKey(ch)&&!c2s.get(ch).equals(str)||s2c.containsKey(str)&&s2c.get(str)!=ch) return false;//细节equals
            c2s.put(ch,str);
            s2c.put(str,ch);
        }
        return true;
    }
}
