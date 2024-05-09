package 栈和队列.字符串消除;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        //跟题解写的几乎一样
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if ((ch < 'a' || ch > 'z') && (ch < 'A' || ch >'Z')) {
                System.out.println(0);
                return;
            }
            if (stack.isEmpty()){
                stack.add(ch);
            }else{
                if (stack.peek()==ch){
                    stack.pop();
                }else{
                    stack.push(ch);
                }
            }
        }
        System.out.println(stack.size());
    }
}
