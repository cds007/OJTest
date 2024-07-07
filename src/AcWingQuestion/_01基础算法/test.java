package AcWingQuestion._01基础算法;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class test {
    /**
     * Java中的函数传参解析
     */

    public static void change(List<Integer> list){
        List<Integer> list2 = new ArrayList<>(Arrays.asList(2,4,6,8));
        list = list2;
    }

    public static void change2(List<Integer> list2){
        list2.clear();
    }
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        List<Integer> list1 = new ArrayList<>(Arrays.asList(5,4,3,2,1));
        list = list1;
        System.out.println(list.toString()); //没毛病，直接指向list1
        change(list);
        System.out.println(list.toString()); //[5,4,3,2,1] 没变化
        change2(list);
        System.out.println(list.toString()); // []

        //终于：我总结一下Java的函数传参：
        /**
         * 1.值传递：这个没得说，一般基本数据类型、new String()等都是值传递，拷贝一份值，形参和实参是没有关系的
         * 2.引用传递：1，明确概念：引用存在栈中，new出来的对象实例存在堆中；
         *           2.首先堆中实例没有改变也没有拷贝，而引用被拷贝了一份，所以形参中的list是拷贝的引用；
         *           3.所以在change中list赋值到另一个对象实例中去时，实参没有改变，而是形参指向了list2的对象实例；
         *           4.但是在change2中修改了list形参时，实参的对象实例也被修改了，因为此时形参和实参都指向同一块对象实例。
         */
    }
}
