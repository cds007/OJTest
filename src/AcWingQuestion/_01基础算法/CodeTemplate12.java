package AcWingQuestion._01基础算法;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CodeTemplate12 {
    /**
     * 离散化代码模板：排序+去重+二分
     * 我大概的一个想法：离散化是用来减少数据量的，原本需要很多数据来表示的，离散化之后数据量会变小。
     * 就是如果我们直接用差分来做的话，那么要开10^9的数组，而实际根本没有那么大数据量，用离散化的话只需要3*10^5（x,l,r）这么多，再将这些映射到一个数组的下标上，就可以根据数组的下标来差分计算，减少计算量。
     * 总结；我理解的离散化就是大幅度缩减数据量，可以画个数轴比对一下。
     */

    public static int N = 300010;

    public static List<Integer> alls = new ArrayList<>();
    public static List<Map.Entry<Integer,Integer>> add = new ArrayList<>(); //为什么不用map，因为map需要获取keyset或者entryset才能获取到值
    public static List<Map.Entry<Integer,Integer>> query = new ArrayList<>();

    public static Map<Integer,Integer> map = new HashMap<>();

    public static int unique(List<Integer> list){
        /**
         * 去重函数：
         * 也可以用LinkedSet转存实现：
         * List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 2, 3, 4, 4, 5));
         * Set<Integer> set = new LinkedHashSet<>(list);
         * list.clear();
         * list.addAll(set);
         */
        int j =0;
        for (int i = 0; i < list.size(); i++) {
            if (i==0||list.get(i)!=list.get(i-1)){
                list.set(j++,list.get(i));
            }
        }
        return j; //j是新list的长度
    }

    /**
     * 查找函数，用来将add和query中的元素映射到all的下标中去。但这一步我觉得用hashmap会更快一点，因为hashmap时间复杂度是O(1) 测试了一下，没差别，反而更慢了。
     * @param index
     * @return
     */
    public static int find(int index){
        //二分查找，待会用hashmap实现一下
        int i = 0;
        int j = alls.size()-1;
        while (i<j){
            //模板1：右区间的左端点，大于等于index的第一个数
            int mid = i+j>>1;
            if (alls.get(mid)>=index) j = mid;
            else i = mid+1;
        }
        return i+1; //这个细节，因为前缀和是从1开始的，所以这里我们返回加1
    }

    public static void main(String[] args) throws IOException {
        /**
         * 802. 区间和
         * 假定有一个无限长的数轴，数轴上每个坐标上的数都是 0。
         * 现在，我们首先进行 n次操作，每次操作将某一位置 x 上的数加 c。
         * 接下来，进行 m次询问，每个询问包含两个整数 l 和 r，你需要求出在区间 [l,r] 之间的所有数的和。
         * −109≤x≤109,
         * 1≤n,m≤105,
         * −109≤l≤r≤109,
         * −10000≤c≤10000
         *
         * 3 3
         * 1 2
         * 3 6
         * 7 5
         * 1 3
         * 4 6
         * 7 8
         *
         * 8
         * 0
         * 5
         */
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] str1 = in.readLine().split(" ");
        int n = Integer.valueOf(str1[0]);
        int m = Integer.valueOf(str1[1]);
        while (n-->0){
            String[] str2 = in.readLine().split(" ");
            int k = Integer.valueOf(str2[0]),v = Integer.valueOf(str2[1]);
            alls.add(k);
            add.add(new AbstractMap.SimpleEntry<>(k,v));
        } //扩充all集和add集
        while(m-->0){
            String[] str3 = in.readLine().split(" ");
            int l = Integer.valueOf(str3[0]),r = Integer.valueOf(str3[1]);
            alls.add(l);
            alls.add(r);
            query.add(new AbstractMap.SimpleEntry<>(l,r));
        } //扩充all集和query集
        //离散化：排序+去重
        Collections.sort(alls);
        int j = unique(alls);
        alls.subList(0,j);

        //法2：去find用map法
        for (int i = 0; i < alls.size(); i++) {
            map.put(alls.get(i),i+1);
        }

        //接下来是前缀和的部分，处理add集：
        int[] a = new int[alls.size()+1]; //我觉得在这儿定义会好一点，因为不一定用到N的长度
        int[] S = new int[alls.size()+1];

        for (int i = 0; i < add.size(); i++) {
            int k = add.get(i).getKey();
            int v = add.get(i).getValue();
            int k_all = map.get(k); //映射下标 用find也是可以的
            a[k_all] += v;
        }

        for(int i=1;i<=alls.size();i++) S[i] = S[i-1]+a[i];
        
        //处理query集
        for (Map.Entry<Integer,Integer> entry :
                query) { //换种写法
            int l = map.get(entry.getKey());
            int r = map.get(entry.getValue());
            System.out.println(S[r]-S[l-1]);
        }
    }
}
