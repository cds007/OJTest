package Que150.ArrayStr;

import java.util.Arrays;

public class Solution274 {
    public int hIndex(int[] citations) {
        //输入：citations = [3,0,6,1,5]
        //输出：3
        //解释：给定数组表示研究者总共有 5 篇论文，每篇论文相应的被引用了 3, 0, 6, 1, 5 次。
        //我的想法是一个O(nlogn)的算法，先排序，再从尾到头遍历，直接判断nums[length-i]的大小即可
        Arrays.sort(citations);
        int start = Math.min(citations.length,citations[citations.length-1]);
        for (int i = start; i >0 ; i--) {
            if (citations[citations.length-i]>=i){
                return i;
            }
        }
        return 0;
    }

    //优化，可以用计数排序，其实也是先排序啦，但是计数排序的时间复杂度只有O(n)，所以会快一点点
    public int hIndex2(int[] citations) {
        int[] counter = new int[citations.length+1];//要加1，考虑数组值可能大于长度的情况，一律放在length上。
        //计数排序
        for (int i = 0; i < citations.length; i++) {
            if (citations[i]>=citations.length){
                counter[citations.length]++;
            }else{
                counter[citations[i]]++;
            }
        }
        //遍历
        int sum = 0;
        for (int i = counter.length; i >=0 ; i--) {
            sum+=counter[i];
            if (sum>=i){
                return i;
            }
        }
        return 0;
    }
}
