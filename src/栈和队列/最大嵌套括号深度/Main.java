package 栈和队列.最大嵌套括号深度;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        //思路跟题解差不多，计算嵌套深度考虑到用栈深度就行
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        Stack<Character> stackLeft = new Stack<>();
        int max = 0;
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            if (ch=='('||ch=='['||ch=='{'){
                //左括号
                stackLeft.push(ch);
            } else if (ch==')') {
                if (stackLeft.isEmpty()){
                    System.out.println(0);
                    return;
                }
                if (stackLeft.peek()!='('){
                    System.out.println(0);
                    return;
                }else{
                    max = Math.max(max,stackLeft.size());//获取嵌套深度
                    stackLeft.pop();
                }
            } else if (ch==']') {
                if (stackLeft.isEmpty()){
                    System.out.println(0);
                    return;
                }
                if (stackLeft.peek()!='['){
                    System.out.println(0);
                    return;
                }else{
                    max = Math.max(max,stackLeft.size());//获取嵌套深度
                    stackLeft.pop();
                }
            } else if (ch=='}') {
                if (stackLeft.isEmpty()){
                    System.out.println(0);
                    return;
                }
                if (stackLeft.peek()!='{'){
                    System.out.println(0);
                    return;
                }else{
                    max = Math.max(max,stackLeft.size());//获取嵌套深度
                    stackLeft.pop();
                }
            }
        }
        if (stackLeft.isEmpty()){
            System.out.println(max);
        }
    }
}
