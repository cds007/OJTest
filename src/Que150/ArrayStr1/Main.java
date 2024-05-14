package Que150.ArrayStr1;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = {3, 1, 4, 1, 5, 9};
        String[] strArray = new String[]{"Z", "a", "D"};
        Integer[] arrInteger = new Integer[arr.length];
        Arrays.setAll(arrInteger,i -> arr[i]);
        Arrays.sort(arrInteger,(a,b) -> b-a);
        Arrays.setAll(arr,i->arrInteger[i]);
        // 打印排序后的数组
        System.out.println(Arrays.toString(arr));
    }
}
