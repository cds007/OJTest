package Que150.Stack7;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import static javax.swing.UIManager.put;

public class Solution20 {
    private static final Map<Character, Character> map = new HashMap<>() {{
        put('{', '}');
        put('[', ']');
        put('(', ')');
        put('?', '?');
    }};//这种写法我还是第一次见

    public boolean isValid(String s) {
        if (s.length() > 0 && !map.containsKey(s.charAt(0))) return false;
        LinkedList<Character> stack = new LinkedList<Character>() {{
            add('?');
        }};
        for (Character c : s.toCharArray()) {
            if (map.containsKey(c)) stack.addLast(c);
            else if (map.get(stack.removeLast()) != c) return false;
        }//想法很简单，代码写的比较高级，简洁。就是这个问号，我觉得没用呀
        return stack.size() == 1;//为什么要问号，参考这个样例："(){}}{" 当然你也可以判断size等于0，这样也不需要问号，多样的写法而已。
    }
}
