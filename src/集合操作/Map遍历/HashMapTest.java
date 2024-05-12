package 集合操作.Map遍历;

import java.util.*;

public class HashMapTest {
    /**
     * 七种方式来迭代HashMap，最适合的是用迭代器Entry来实现，最安全也最高效
     *     使用迭代器（Iterator）EntrySet 的方式进行遍历；
     *     使用迭代器（Iterator）KeySet 的方式进行遍历；
     *     使用 For Each EntrySet 的方式进行遍历；
     *     使用 For Each KeySet 的方式进行遍历；
     *     使用 Lambda 表达式的方式进行遍历；
     *     使用 Streams API 单线程的方式进行遍历；
     *     使用 Streams API 多线程的方式进行遍历。
     */
    public static void main(String[] args) {
        // 创建并赋值 HashMap
        Map<Integer, String> map = new HashMap();
        map.put(1, "Java");
        map.put(2, "JDK");
        map.put(3, "Spring Framework");
        map.put(4, "MyBatis framework");
        map.put(5, "Java中文社群");

        System.out.println("###使用迭代器（Iterator）EntrySet 的方式进行遍历；");
        Iterator<Map.Entry<Integer,String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<Integer,String> entry = iterator.next();
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }

        System.out.println("###使用迭代器（Iterator）KeySet 的方式进行遍历；");
        Iterator<Integer> iterator1 = map.keySet().iterator();
        while (iterator1.hasNext()){
            int key = iterator1.next();
            System.out.println(key);
            System.out.println(map.get(key));//这个过程其实是费时的
        }

        System.out.println("###使用 For Each EntrySet 的方式进行遍历；");
        for (Map.Entry<Integer, String> entry :
                map.entrySet()) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }

    }
}
