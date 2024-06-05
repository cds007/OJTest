package AcWingQuestion._01基础算法;

import java.util.*;
import java.io.*;

public class CodeTemplate {

    //快速排序算法模板
    public static void quickSort(int[] nums, int left, int right) {
        if (left >= right) return;
        int i = left, j = right;
        int pivot = nums[left];
        while (i < j) {
            while (i < j && nums[j] >= pivot) j--;
            while (i < j && nums[i] <= pivot) i++;
            if (i < j) {
                int temp = nums[i];
                nums[i] = nums[j];
            }
        }
        nums[left] = nums[i];
        nums[i] = pivot;
        quickSort(nums, left, i - 1);
        quickSort(nums, i + 1, right);
    }

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = 1000000000;
        System.out.println(N);
        int[] nums = new int[N];
        int n = 0;
        try {
            //第一行读取一个数，第二行读取一个数组
            String line = reader.readLine();
            n = Integer.parseInt(line);
            String[] strs = reader.readLine().split(" ");

            for (int i = 0; i < n; i++) {
                nums[i] = Integer.parseInt(strs[i]);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        quickSort(nums, 0, n-1); //调用快排
        for (int i = 0; i < n; i++) {
            System.out.println(nums[i]);
        }
    }
}
