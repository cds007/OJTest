package Que150.HaXi;

import java.util.HashMap;
import java.util.Map;

public class Solution205 {
    public boolean isIsomorphic(String s, String t) {
        //1.我的想法：太简单了，直接用hashmap来存就行了，映射嘛！
        //2.题解：跟我的想法一样，但是题解用两张hashmap来维护，更加全面！因为(foo,bar)和(bar,foo)用一张表是存不完的
        Map<Character,Character> s2t = new HashMap<>();
        Map<Character,Character> t2s = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char chs = s.charAt(i);
            char cht = t.charAt(i);
            if (s2t.containsKey(chs)&&s2t.get(chs)!=cht||t2s.containsKey(cht)&&t2s.get(cht)!=chs) return false;
            s2t.put(chs,cht);
            t2s.put(cht,chs);
        }
        return true;
    }
}
