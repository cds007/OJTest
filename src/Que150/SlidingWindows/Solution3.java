package Que150.SlidingWindows;

import java.util.*;

public class Solution3 {
    public int lengthOfLongestSubstring(String s) {
        //输入: s = "pwwkew"
        //输出: 3
        //解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
        //     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。

        //csdn上的看的不是很清楚，我自己用哈希表+滑动窗口实现一下，时间复杂度应该是On*k
        Deque<Character> queue = new LinkedList<>();
        Map<Character, Integer> map = new HashMap<>();
        int ret = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!map.containsKey(ch)) {
                map.put(ch, 1);
                queue.addLast(ch);
            } else {
                ret = Math.max(queue.size(),ret);
                Iterator<Character> iterator = queue.iterator();
                while (iterator.hasNext()){
                    Character c = iterator.next();
                    if (c==ch){
                        iterator.remove();
                    }
                    map.remove(c);
                    iterator.remove();
                }
                queue.addLast(ch);
            }
        }
        ret = Math.max(queue.size(),ret);
        return ret;
    }


    /**
     * for (Character c :
     *                         queue) {
     *                     if (c == ch) {
     *                         queue.removeFirst();
     *                         break;
     *                     }
     *                     map.remove(queue.getFirst());
     *                     queue.removeFirst();
     *                 }处刑一下：这段代码是有问题的，不能迭代的时候修改元素
     */

    public int lengthOfLongestSubstring2(String s) {
        //输入: s = "pwwkew"
        //输出: 3
        //解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
        //请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。

        //其实题解也是滑动窗口，但是题解的做法On就行了。想法跟我一样的，但是可以优化。
        //滑动窗口有双端队列和双指针两种做法，其实题解这个也可以看做是双指针的方法，真的写的挺好的。
        //1.一方面用了双指针来表示窗口的位置；2.另一方面哈希表存的不是个数，而是位置，这个很好的实现了On的效果；3.细节left的选取，参考abba的示例
        Map<Character,Integer> map = new HashMap<>();
        int left = 0;
        int ret = 0;
        for (int i = 0; i < s.length(); i++) {
            Character ch = s.charAt(i);
            if (!map.containsKey(ch)){//不存在
                map.put(ch,i);
                ret = Math.max(ret,i-left+1);
            }else{
                left = Math.max(left,map.get(ch)+1);//"abba"
                map.put(ch,i);
                ret = Math.max(ret,i-left+1);
            }
        }
        return ret;
    }


}
