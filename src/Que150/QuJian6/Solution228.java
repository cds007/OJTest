package Que150.QuJian6;

import java.util.ArrayList;
import java.util.List;

public class Solution228 {
    public List<String> summaryRanges(int[] nums) {
        //1.我的想法：直接双指针，一次遍历即可
        //2.题解：跟我一个想法
        //写一个清醒清醒，今天接下来的我都不打算写了，看懂就行，就写这一个
        List<String> ret = new ArrayList<>();
        int i = 0;
        int n = nums.length;
        while (i<n){
            int low = i;
            i++;
            while (i<n&&nums[i]==nums[i-1]){
                i++;
            }
            int high = i-1;
            StringBuilder sb = new StringBuilder();
            sb.append(nums[low]);
            if (low<high){
                sb.append("->");
                sb.append(nums[high]);
            }
            ret.add(sb.toString());
        }
        return ret;
    }
}
