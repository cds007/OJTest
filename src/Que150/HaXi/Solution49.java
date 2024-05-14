package Que150.HaXi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        //1.初步想法：O(n2)，一次遍历，每次遍历时都遍历一遍已有的哈希表或者哈希数组
        //2.题解：两个方法都很好，关键是key是什么。1.先排序，key是排序的这个String值；2.用字符+计数的形式存key。比如a1e1t1，这样也可以完整表示一个key，很妙。
        //我们用字符+计数的形式写这个代码。
        //["eat","tea","tan","ate","nat","bat"]
        Map<String,List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            int[] chars = new int[26];
            //获取键
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < str.length(); j++) {
                chars[str.charAt(j)-'a']++;
            }
            for (int j = 0; j < 26; j++) {
                if (chars[j]!=0){
                    sb.append((char)('a'+j));
                    sb.append(chars[j]);
                }
            }
            String key = sb.toString();
            List<String> list = map.getOrDefault(key,new ArrayList<>());
            list.add(str);
            map.put(key,list);
        }
        return new ArrayList<List<String>>(map.values());
    }
}
