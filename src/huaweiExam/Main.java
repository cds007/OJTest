package huaweiExam;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Map<String,Integer> map = new HashMap<>();
        while (in.hasNextLine()){
            String[] str = in.nextLine().split(" ");
            if (str.length==2){
                //打印
                if (map.containsKey(str[1])){
                    System.out.println(map.get(str[1]));
                }else{
                    System.out.println(-1);//出错
                }
            } else if (str.length==3) {
                //mov
                String strIn = str[1];
                String strOut = str[2];
                if (strOut.charAt(0)=='a'){
                    //说明是寄存器
                    int num = map.get(str[2]);
                    map.put(strIn,num);
                }else{
                    //数字
                    int num = Integer.valueOf(strOut);
                    map.put(strIn,num);
                }
            } else if (str.length==4) {
                //加减乘除
                String suan = str[0];
                String first = str[1];
                int firstSum = 0;
                int secondNum = 0;int thirdNum = 0;
                if (map.containsKey(first)){
                    firstSum = map.get(first);
                }
                String second = str[2];
                if (second.charAt(0)=='a'){
                    secondNum = map.get(str[2]);
                }else{
                    secondNum = Integer.valueOf(second);
                }
                String third = str[3];
                if (third.charAt(0)=='a'){
                    thirdNum = map.get(str[3]);
                }else{
                    thirdNum = Integer.valueOf(third);
                }
                if (suan.equals("ADD")){
                    firstSum = secondNum + thirdNum;
                } else if (suan.equals("SUB")) {
                    firstSum = secondNum - thirdNum;
                } else if (suan.equals("MUL")) {
                    firstSum = secondNum * thirdNum;
                } else if (suan.equals("DIV")) {
                    firstSum = secondNum / thirdNum;
                }
                map.put(first,firstSum);
            }
        }
    }
}
