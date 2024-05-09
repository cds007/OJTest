package 字符串.拼接URL;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] URL = in.nextLine().split(",");
        StringBuilder sb = new StringBuilder();
        if (URL.length == 0) {
            System.out.println("/");
            return;
        }
        //要考虑所有情况，前缀的头尾以及后缀的头尾，总共有6种情况，但是不用考虑后缀的尾吗
        if (URL[0].charAt(0) == '/') {  //前缀字符串是'/'开头
            if (URL[0].charAt(URL[0].length() - 1) != '/' && URL[1].charAt(0) != '/') {  // 前缀最后一个字符不是'/'，且后缀第一个也不是
                sb.append(URL[0]);
                sb.append('/');
                sb.append(URL[1]);
                // 这个判断有问题，不进
            } else if (URL[0].charAt(URL[0].length() - 1) == '/' && URL[1].charAt(0) == '/'){ //  前缀最后一个字符是'/'，且后缀第一个也是, 前缀去掉，后缀不变
                sb.append(URL[0].substring(0, URL[0].length() - 1));
                sb.append(URL[1]);
            } else {  // 前缀最后一个字符是'/'，或者后缀第一个是
                sb.append(URL[0]);
                sb.append(URL[1]);
            }
        } else {
            sb.append('/');
            if (URL[0].charAt(URL[0].length() - 1) != '/' && URL[1].charAt(0) != '/') {  // 前缀最后一个字符不是'/'，且后缀第一个也不是
                sb.append(URL[0]);
                sb.append('/');
                sb.append(URL[1]);
                // 这个判断有问题，不进
            } else if (URL[0].charAt(URL[0].length() - 1) == '/' && URL[1].charAt(0) == '/'){ //  前缀最后一个字符是'/'，且后缀第一个也是, 前缀去掉，后缀不变
                sb.append(URL[0].substring(0, URL[0].length() - 1));
                sb.append(URL[1]);
            } else {  // 前缀最后一个字符是'/'，或者后缀第一个是
                sb.append(URL[0]);
                sb.append(URL[1]);
            }
        }
        System.out.println(sb.toString());
    }
}
