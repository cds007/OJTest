package 数组.猴子吃桃;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] str = in.nextLine().split(" ");
        int[] arr = new int[str.length-1];
        long sum = 0;
        //1.还应该有一个判断异常输入的过程
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.valueOf(str[i]);
            sum+=arr[i];
        }
        long time = Integer.valueOf(str[str.length-1]);//回来的时间
        //这题，可以在On2的复杂度上进行一定的优化
        //2.我这个方法其实还是On2，只不过节省一点点时间，但本质还是On2。
        long rad = sum/time;//初始值
        //如果初始速度太小
        boolean flag = false;
        while(handle(arr,rad)>time){
            flag = true;
            rad++;
        }
        if (flag){
            System.out.println(rad);
            return;
        }
        while (handle(arr,rad)<=time){
            rad--;
        }
        System.out.println(++rad);
    }
    
    public static long handle(int[] arr,long rad){
        long t = 0;
        long s = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]%rad!=0){
                t = arr[i]/rad+1;
            }else{
                t = arr[i]/rad;
            }
            s+=t;
        }
        return s;
    }
}
