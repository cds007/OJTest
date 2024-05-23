package huawei;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //6 -5 10 -3 2 3 -5
        int[] a = new int[]{6, -5 ,10, -3 ,2 ,3, -5};
        int[] b = pengZhuang(a);
        for (int i = 0; i < b.length; i++) {
            System.out.println(b[i]);
        }
    }

    public static int[] pengZhuang(int [] asteroids){
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < asteroids.length; i++) {
            list.add(asteroids[i]);
        }
        int n = asteroids.length;
        int i = 0;
        while (i<list.size()-1){
            int a = list.get(i);
            int b = list.get(i+1);
            if (a>0&&b<0){
                if (a>Math.abs(b)){
                    list.set(i,list.get(i));
                    list.remove(i+1);
                    i++;
                    continue;
                }else if (a<Math.abs(b)){
                    list.set(i,list.get(i+1));
                    list.remove(i+1);
                    i--;
                    continue;
                }else{
                    list.remove(i+1);//先remove后面的
                    list.remove(i);
                }
            }
            i++;
        }
        int[] newArr=  list.stream().mapToInt(Integer::intValue).toArray();
        return newArr;
    }
}
