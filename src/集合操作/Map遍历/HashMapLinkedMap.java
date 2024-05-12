package 集合操作.Map遍历;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class HashMapLinkedMap {
    public static void main(String[] args) {
        //LinkedHashMap是有序的，由数组+链表+红黑树+双向链表维护
        Map<String,String> map1 = new HashMap<>();
        map1.put("小狗","小明");
        map1.put("小猫","小红");
        map1.put("淘天","小红");
        map1.put("引用","小红");
        map1.put("建议妥否","小红");
        map1.put("二","小红");
        map1.put("而俄方","小红");
        Map<String,String> map2 = new LinkedHashMap<>();
        map2.put("小狗","小明");
        map2.put("小猫","小红");
        map2.put("淘天","小红");
        map2.put("引用","小红");
        map2.put("建议妥否","小红");
        map2.put("二","小红");
        map2.put("而俄方","小红");
        for (Map.Entry<String, String> entry :
                map1.entrySet()) {
            System.out.println(entry.getKey()+" "+entry.getValue());
        }
        System.out.println("#######################################3");
        for (Map.Entry<String, String> entry :
                map2.entrySet()) {
            System.out.println(entry.getKey()+" "+entry.getValue());
        }
    }
}
