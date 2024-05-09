package 字符串.报文解压缩;

import java.util.*;

public class Main {

    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        //1.思路就是先分离为多个组，再对每个组用三个栈进行存储和解压缩
        Scanner in = new Scanner(System.in);
        //分组思路就是一个]接着一个数字
        int pos = 0;
        String str = in.nextLine();
        for(int i=0;i<str.length();i++){
            if (str.charAt(i)==']'&&i==str.length()-1||str.charAt(i)==']'&&Character.isDigit(str.charAt(i+1))){
                //分组
                String zuStr = str.substring(pos,i+1);//形如3[m2[c]]
                pos=i+1;
                //处理String
                handle(zuStr);
            }
        }
        System.out.println(sb);
    }

    public static void handle(String str){
        //3[m2[c]]
        Stack<Integer> stackInt = new Stack<>();//存数字
        Stack<Character> stackCh = new Stack<>();//存左括号和字母
        char[] chars = str.toCharArray();
        int rad = 0;
        for(char ch : chars){
            if (Character.isDigit(ch)){
                rad = rad*10+ch-'0';
            } else if (ch=='[') {
                //左括号
                stackInt.push(rad);
                rad = 0;
                stackCh.push(ch);
            } else if (Character.isLetter(ch)) {
                //字母
                stackCh.push(ch);
            }else{
                //右括号则直接处理
                int cnt = stackInt.pop();
                List<Character> list = new ArrayList<>();
                while(stackCh.peek()!='['){
                    list.add(0,stackCh.pop());
                }
                stackCh.pop();
                for(int i=0;i<cnt;i++){
                    for(char c : list){
                        stackCh.push(c);
                    }
                }
            }
        }
        //最后的stackCh就是结果
        List<Character> list = new ArrayList<>();
        while(!stackCh.isEmpty()){
            list.add(0,stackCh.pop());
        }
        for(char c : list){
            sb.append(c);
        }
    }
}
