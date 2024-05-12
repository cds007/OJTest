package 集合操作.定制排序;

import java.util.*;

public class Main2 {
    public static void main(String[] args) {
        Deque<Integer> deque = new ArrayDeque<>();
        deque.addLast(1);
        deque.addFirst(0);
        System.out.println(deque.getFirst());

        Set<Integer> set = new LinkedHashSet<>();
        set.add(4);
        set.add(2);
        for (Integer e :
                set) {
            System.out.println(e);
        }
    }
}
