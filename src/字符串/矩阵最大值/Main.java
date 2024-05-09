package 字符串.矩阵最大值;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        in.nextLine();//1.这个细节
        //没办法，看题解也是On3，就按On3来做吧。唯一的难点就是怎么去处理矩阵元素的移动
        int sum  =0;
        for (int i = 0; i < N; i++) {
            String str = in.nextLine();
            sum+=handle(str);
        }
        System.out.println(sum);
    }

    public static int handle(String str){
        //这里是On2，核心函数，但是经过我的改进似乎比On2小了。因为substring的复杂度好像是O1
        //遍历每一个1，让1当首位，用左移的思想会好理解一点
        int max = 0;
        String[] arr = str.split(",");
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals("1")){
                //移位 1,0,0,0,1
                StringBuilder sb = new StringBuilder();
                for (int j = i; j < arr.length; j++) {
                    sb.append(arr[j]);
                }
                for (int j = 0; j < i; j++) {
                    sb.append(arr[j]);
                }
                int num = Integer.valueOf(sb.toString(),2);//从二进制转成十进制
                if (num>max) max = num;
            }
        }
        return max;
    }
}
