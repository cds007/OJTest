package 集合操作.定制排序;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

// person对象没有实现Comparable接口，所以必须实现，这样才不会出错，才可以使treemap中的数据按顺序排列
// 前面一个例子的String类已经默认实现了Comparable接口，详细可以查看String类的API文档，另外其他
// 像Integer类等都已经实现了Comparable接口，所以不需要另外实现了
public  class Person implements Comparable<Person> {
    private String name;
    private int age;

    public Person(String name, int age) {
        super();
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    /**
     * T重写compareTo方法实现按年龄来排序
     */
    @Override
    public int compareTo(Person o) {
        if (this.age > o.getAge()) {
            return 1;
        }//返回正数，第二个数排在第一个数前面
        if (this.age < o.getAge()) {
            return -1;
        }
        return 0;
    }

    public static void main(String[] args) {
        TreeMap<Person, String> pdata = new TreeMap<Person, String>();//TreeMap是自带排序的
        //这样写也可以
        Map<Person,String> pdata2 = new TreeMap<>((a,b)->{
            return b.age-a.age;//这个就是降序的写法
        });

        pdata2.put(new Person("张三", 30), "zhangsan");
        pdata2.put(new Person("李四", 20), "lisi");
        pdata2.put(new Person("王五", 10), "wangwu");
        pdata2.put(new Person("小红", 5), "xiaohong");
        // 得到key的值的同时得到key所对应的值
        Set<Person> keys = pdata2.keySet();
        for (Person key : keys) {
            System.out.println(key.getAge() + "-" + key.getName());

        }
    }

}


