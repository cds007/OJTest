package AcWingQuestion._02数据结构;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CodeTemplate01 {
    /**
     * 实现一个单链表，链表初始为空，支持三种操作：向链表头插入一个数；删除第 k个插入的数后面的一个数；在第 k个插入的数后插入一个数。
     * H x，表示向链表头插入一个数 x。
     * D k，表示删除第 k个插入的数后面的数（当 k 为 0时，表示删除头结点）。
     * I k x，表示在第 k个插入的数后面插入一个数 x（此操作中 k 均大于 0）。
     * 10
     * H 9
     * I 1 1
     * D 1
     * D 0
     * H 6
     * I 3 6
     * I 4 5
     * I 4 5
     * I 3 4
     * D 6
     * 6 4 6 5
     */
    public static int N = 100010;
    public static int head;
    public static int[] e = new int[N]; //value
    public static int[] ne = new int[N]; //next
    public static int idx; //当前插入的位置

    public static void init(){
        head = -1;
        idx = 0;
    }

    public static void add_to_head(int x){
        e[idx] = x; ne[idx] = head; head = idx++;
    }

    public static void add(int k,int x){//在下标k之后插入值x
        e[idx] = x; ne[idx] = ne[k]; ne[k] = idx++;
    }

    public static void remove(int k){//删除下标k之后的元素
        ne[k] = ne[ne[k]];
    }


    /**
     * 用数组来实现链表的操作
     * @param args
     */
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.valueOf(in.readLine());
        int k=0,x=0;
        init(); //要先初始化
        while (M-->0){
            String str[] = in.readLine().split(" ");
            if (str[0].equals("H")){
                x = Integer.valueOf(str[1]);
                add_to_head(x);
            } else if (str[0].equals("I")) {
                k = Integer.valueOf(str[1]);
                x = Integer.valueOf(str[2]);
                add(k-1,x); //第k个元素对应的索引就是k-1
            }else {
                k = Integer.valueOf(str[1]);
                if (k==0) head = ne[head];
                else remove(k-1);
            }
        }
        for(int i=head;i!=-1;i=ne[i]){
            System.out.print(e[i]+" ");
        }
    }
}
