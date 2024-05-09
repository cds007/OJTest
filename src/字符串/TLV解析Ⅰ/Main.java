package 字符串.TLV解析Ⅰ;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String tagIndex = in.next();//待查的tag值
        while(in.hasNext()){
            String tag = in.next();//先查tag
            if (tagIndex.equals(tag)){
                //相等
                String tagLen = in.next();
                tagLen = in.next()+tagLen;
                int tagLenInt = stringToInt(tagLen);
                for(int i=0;i<tagLenInt;i++){
                    String out = in.next();
                    System.out.print(out);
                    System.out.print(" ");
                }
                return;
            }else{
                //tag转int
                //获取长度
                String tagLen = in.next();
                tagLen = in.next()+tagLen;
                int tagLenInt = stringToInt(tagLen);
                for(int i=0;i<tagLenInt;i++){
                    String skip = in.next();//跳过
                }
            }
        }
    }

    public static int stringToInt(String str){
        char[] chars = str.toCharArray();
        int sum = 0;
        for(char ch : chars){
            //32A
            if (ch>='0'&&ch<='9'){
                sum = sum*16+ch-'0';
            }else{
                sum = sum*16+ch-'A'+10;//只有大写
            }
        }
        return sum;
    }

}