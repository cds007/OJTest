package 字符串.TLV解析Ⅰ;

import java.util.Scanner;

public class MainTJ {
    public static void main(String[] args) {
        Scanner in= new Scanner(System.in);
        String tag = in.nextLine();
        String[] tagArr = in.nextLine().split(" ");//1.可以学到分割字符串数组
        for(int i=0;i< tagArr.length;i++){
            int tagLen = Integer.parseInt(tagArr[i+2]+tagArr[i+1],16);//2.字符串转int，16进制转10进制
            if (tagArr[i].equals(tag)){//3.还是得用equals
                StringBuilder sb = new StringBuilder("");
                for(int j=0;j<tagLen;j++){
                    sb.append(tagArr[i+3+j]).append(" ");//4.用StringBuilder会方便一点
                }
                String str = sb.toString();
                System.out.println(str);
                break;
            }else{
                i = i+tagLen+2;//5.稍微计算一下就知道了
            }
        }
    }
}
