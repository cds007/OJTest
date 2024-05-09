package TrueQuestion.Ques0417;

import java.util.Scanner;
import java.util.Stack;

public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();//重置换行符
        String[] input = in.nextLine().split(" ");
        Stack<String> stack = new Stack<>();
        int cnt = 1;//记录连续数量
        for (int i = 0; i < input.length; i++) {
            if (!stack.isEmpty()){
                if (stack.peek().equals(input[i])){
                    cnt++;
                    if (cnt==3){
                        stack.pop();
                        stack.pop();
                        cnt=1;
                    }else{
                        stack.push(input[i]);
                    }
                }else{
                    stack.push(input[i]);
                }
            }else{
                stack.push(input[i]);
            }
        }
        if (stack.isEmpty()){
            System.out.println(0);
        }else{
            StringBuilder sb = new StringBuilder();
            while (!stack.isEmpty()){
                sb.append(stack.pop()).append(" ");
            }
            sb.delete(sb.length()-1,sb.length());
            sb.reverse();
            System.out.println(sb);
        }
    }
}
