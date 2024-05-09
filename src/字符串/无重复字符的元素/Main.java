package 字符串.无重复字符的元素;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] strArr = in.nextLine().split(",");
        int max = 0;
        Map<Character,Integer> map = new HashMap<>();//小细节
        //On2.5时间复杂度
        for (int i = 0; i < strArr.length; i++) {
            for (int j = i+1; j < strArr.length; j++) {
                boolean flag = false;
                String s1 = strArr[i];
                String s2 = strArr[j];
                if (s1.length()*s2.length()<=max){
                    continue;
                }
                for (int k = 0; k < s1.length(); k++) {
                    char ch = s1.charAt(k);
                    map.put(ch,1);
                }
                for (int k = 0; k < s2.length(); k++) {
                    char ch = s2.charAt(k);
                    if (map.containsKey(ch)){
                        flag = true;//细节
                        break;
                    }
                }
                if (!flag){
                    max = s1.length()*s2.length()>max?s1.length()*s2.length():max;
                }
                map.clear();
            }
        }
        System.out.println(max);
    }
}
