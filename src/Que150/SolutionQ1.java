package Que150;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SolutionQ1 {
    public int[] topKFrequent(int[] nums, int k){
        //这题可以用桶排序来实现，时间复杂度为O(n)。具体过程是先用hashmap存储元素和频次，再用桶排序选取前k个元素
        List<Integer> result = new ArrayList<>();
        Map<Integer,Integer> map = new HashMap<>();
        //使用字典存储出现次数
        for(int num:nums){
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        //桶排序，频率作为下标
        List<Integer>[] list = new List[nums.length+1];
        for(int key : map.keySet()){
            // 获取出现的次数作为下标
            int i = map.get(key);
            if(list[i] == null){
                list[i] = new ArrayList();
            }
            list[i].add(key);
        }
        //output
        for(int i = list.length - 1;i >= 0 && result.size() < k;i--){
            if(list[i] == null) continue;
            result.addAll(list[i]);
        }
        //转int[]
        return result.stream().mapToInt(i->i).toArray();
    }
}
