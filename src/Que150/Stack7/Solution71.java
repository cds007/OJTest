package Que150.Stack7;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution71 {
    public String simplifyPath(String path) {
        //这题看着好像挺难的，其实一点也不难，代码也很简单
        //  比如："/home/user/Documents/../Pictures" 这个就返回/home/user/Pictures
        //思路：1.先用/分割字符串数组，然后分别入栈，判断. .. 普通字符串 空字符串 四种情况 两个斜杠则为空字符串。然后再出栈输出即可。自己写一下代码：
        String[] names = path.split("/");
        Deque<String> deque = new ArrayDeque<>();//栈
        for (String name :
                names) {
            if ("..".equals(name)) {
                if (!deque.isEmpty()){
                    deque.removeLast();
                }
            } else if (name.length() != 0 && !".".equals(name)) {
                deque.addLast(name);
            }
        }
        //拼接
        StringBuilder sb = new StringBuilder();
        if (deque.isEmpty()){
            return "/";
        }else {
            while (!deque.isEmpty()){
                sb.append("/");
                sb.append(deque.removeFirst());
            }
        }
        return sb.toString();
    }
}
