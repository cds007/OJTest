package 字符串.非严格递增连续数字序列;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        int[] dp = new int[str.length()];
        int max = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i)>='a'&&str.charAt(i)<='z'){
                //是字母
                dp[i] = 0;
            }else if (str.charAt(i)>='0'&&str.charAt(i)<='9'&&i==0||str.charAt(i-1)>='a'&&str.charAt(i-1)<='z'&&str.charAt(i)>='0'&&str.charAt(i)<='9'){
                //第一次的数字
                dp[i] = 1;
            }else if (str.charAt(i)>=str.charAt(i-1)){
                dp[i] = dp[i-1]+1;
            }else{
                dp[i] = 1;
            }
            if (dp[i]>max) max = dp[i];
        }
        System.out.println(max);
    }
}
