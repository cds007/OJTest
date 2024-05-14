package Que150.ArrayStr1;

import java.util.*;

class RandomizedSet {
    //Solution380
    //输入
    //["RandomizedSet", "insert", "remove", "insert", "getRandom", "remove", "insert", "getRandom"]
    //[[], [1], [2], [2], [], [1], [2], []]
    //输出
    //[null, true, false, true, 2, true, false, 2]

    //因为是实现集合，所以不可能有相同元素，所以可以使用hashmap
    //insert和remove都可以用哈希表实现O(1)的复杂度，但哈希表不能实现O(1)的获取随机元素，所以还需要使用一个变长数组List
    //需要将变长数组和哈希表结合，变长数组中存储元素，哈希表中存储每个元素在变长数组中的下标。有点像无重复字符的最长子串，用哈希表存下标可以实现O(1)。
    Map<Integer,Integer> map;
    List<Integer> list;
    Random random;

    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
        random = new Random();
    }

    public boolean insert(int val) {
        if (map.containsKey(val)){
            return false;
        }else{
            list.add(val);
            map.put(val,list.size()-1);
            return true;
        }
    }

    public boolean remove(int val) {
        if (!map.containsKey(val)){
            return false;
        }else{
            //这个有点细节，为了保证下标的一致性，并且O(1)的复杂度，所以只将最后一个元素移入到该下标位置，然后改变索引值，删除下标值。
            int valLast = list.get(list.size()-1);
            int index = map.get(val);
            map.put(valLast,index);
            list.set(index,valLast);//这个操作是O(1)的。覆盖的。
            list.remove(list.size()-1);//移除最后一个元素
            map.remove(val);//移除掉val
            return true;
        }
    }

    public int getRandom() {
        //5, [0,4]
        int randomIndex = random.nextInt(list.size());
        return list.get(randomIndex);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
