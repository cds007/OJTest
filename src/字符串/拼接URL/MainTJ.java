package 字符串.拼接URL;

import java.util.Scanner;

public class MainTJ {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] URL = in.nextLine().split(",");
        StringBuilder sb = new StringBuilder();
        if (URL.length == 0) {
            System.out.println("/");
            return;
        }
        sb.append("/").append(URL[0]).append("/").append(URL[1]);
        System.out.println(sb.toString().replaceAll("/+","/"));
    }
}
