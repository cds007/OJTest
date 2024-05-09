package 字符串.VLANPool;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] vlan = new int[4096];
        String[] vlanArr = in.nextLine().split(",");
        for(String str : vlanArr){
            int index = str.indexOf("-");
            if (index!=-1){
                String str1 = str.substring(0,index);
                String str2 = str.substring(index+1);
                int num1 = Integer.valueOf(str1);
                int num2 = Integer.valueOf(str2);
                for(int i=num1;i<=num2;i++){
                    vlan[i]=1;
                }
            }else{
                int num = Integer.valueOf(str);
                vlan[num] = 1;
            }
        }
        int vlanNeed = in.nextInt();
        if (vlan[vlanNeed]==1){
            vlan[vlanNeed]=0;
        }
        StringBuilder sb = new StringBuilder();
        for(int i=1;i<vlan.length;i++){
            int num1 = 0;
            if (vlan[i]==1){
                num1 = i;
            }
            while(vlan[i]==1){
                i++;
            }
            int num2 = i-1;
            if (num1!=0){
                if (num2==num1){
                    sb.append(num1).append(",");
                }else{
                    sb.append(num1).append("-").append(num2).append(",");
                }
            }
        }
        System.out.println(sb.substring(0,sb.length()-1));//这个思路是对的
    }
}
