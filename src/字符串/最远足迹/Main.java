package 字符串.最远足迹;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        int sPos = -1;
        int ePos = -1;
        int max = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i)=='('){//这个考虑是对的，因为不考虑括号的嵌套的情况
                int pos = str.indexOf(')',i);
                String s = str.substring(i,pos+1);//(32,10)
                int retMax = handle(s);
                if (retMax>max){
                    max = retMax;
                    sPos = i;
                    ePos = pos+1;
                }
            }
        }
        if (sPos!=-1){
            System.out.println(str.substring(sPos,ePos));
        }else{
            System.out.println("(0,0)");
        }
    }

    public static int handle(String str){
        String s = str.substring(1,str.length()-1);
        String[] arr = s.split(",");
        if (arr.length!=2) return -1;
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            //判断大小
            if (Integer.valueOf(arr[i])<=0||Integer.valueOf(arr[i])>=1000) return -1;
            if (!(arr[i].charAt(0)>='1'&&arr[i].charAt(0)<='9')) return -1;
            max += Integer.valueOf(arr[i])*Integer.valueOf(arr[i]);
        }
        return max;
    }
}
