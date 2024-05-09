package 栈和队列.DNA序列;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //滑动窗口,On的方法。不是Onm，每一轮的窗口中不需要再遍历，滑动窗口的实现方法包括双端队列和双指针
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();//AACTGTGCACGACCTGA
        int N = in.nextInt();
        if (N>=str.length()){
            System.out.println(str);
            return;
        }
        int max = 0;
        int ans = 0;
        int pos = 0;
        Deque<Character> deque = new LinkedList<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            deque.addLast(ch);
            if (ch=='C'||ch=='G'){
                ans++;
            }
            if (deque.size()==N){
                if (ans>max){
                    pos = i-N+1;
                    max = pos;
                }
                if (deque.getFirst()=='C'||deque.getFirst()=='G'){
                    ans--;
                }
                deque.removeFirst();
            }
        }
        System.out.println(str.substring(pos,pos+N));
    }
}
