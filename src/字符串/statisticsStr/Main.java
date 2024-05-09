package 字符串.statisticsStr;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String inStr = in.nextLine();
        if (inStr.indexOf("@")==inStr.length()-1){
            System.out.println(inStr);//特殊情况
            return;
        }
        int index = inStr.indexOf("@");
        String str1 = inStr.substring(0,index);
        String str2 = inStr.substring(index+1);
        String[] allStr = str1.split(",");
        String[] ocStr = str2.split(",");
        Map<String,Integer> map = new LinkedHashMap<>();//这个是我的小细节
        for(String str : allStr){
            String s1 = str.substring(0,1);
            int v1 = Integer.valueOf(str.substring(2));
            map.put(s1,v1);
        }
        for(String str : ocStr){
            String s1 = str.substring(0,1);
            int v1 = Integer.valueOf(str.substring(2));
            map.put(s1,map.get(s1)-v1);
        }
        StringBuilder sb = new StringBuilder();
        for(Map.Entry<String,Integer> entry : map.entrySet()){
            String s1 = entry.getKey();
            int v1 = entry.getValue();
            if (v1!=0) {
                sb.append(s1+":").append(v1).append(",");
            }
        }
        System.out.println(sb.substring(0,sb.length()-1));
    }
}
