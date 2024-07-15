package AcWingQuestion._02数据结构;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CodeTemplate02 {
    /**
     * 双链表:
     * 实现一个双链表，双链表初始为空，支持 5种操作：
     * 在最左侧插入一个数；
     * 在最右侧插入一个数；
     * 将第 k个插入的数删除；
     * 在第 k个插入的数左侧插入一个数；
     * 在第 k个插入的数右侧插入一个数
     * 10
     * R 7
     * D 1
     * L 3
     * IL 2 10
     * D 3
     * IL 2 7
     * L 8
     * R 9
     * IL 4 7
     * IR 2 2
     * 8 7 7 3 2 9
     */

    public static int N = 100010;
    public static int[] e = new int[N];
    public static int[] l = new int[N];
    public static int[] r = new int[N];
    public static int idx;

    /**
     * 在a的右边插入一个x
     * @param a
     * @param x
     */
    public static void insert(int a,int x){
        e[idx] = x;
        l[idx] = a;r[idx] = r[a];
        l[r[a]] = idx;
        r[a] = idx++;
    }

    /**
     * 删除节点a
     * @param a
     */
    public static void remove(int a){
        r[l[a]] = r[a];
        l[r[a]] = l[a];
    }

    public static void init(){
        r[0] = 1;
        l[1] = 0;
        idx = 2;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.valueOf(in.readLine());
        int k = 0,x=0;
        init();
        while (M-->0){
            String[] str = in.readLine().split(" ");
            if (str[0].equals("L")){
                x =  Integer.valueOf(str[1]);
                insert(0,x);
            } else if (str[0].equals("R")) {
                x =  Integer.valueOf(str[1]);
                insert(l[1],x);
            } else if (str[0].equals("D")) {
                k = Integer.valueOf(str[1]);
                remove(k+1);
            } else if (str[0].equals("IL")) {
                k = Integer.valueOf(str[1]);
                x = Integer.valueOf(str[2]);
                insert(l[k+1],x);
            }else {
                k = Integer.valueOf(str[1]);
                x = Integer.valueOf(str[2]);
                insert(k+1,x);
            }
        }
        for(int i=r[0];i!=1;i = r[i]){
            System.out.print(e[i]+" ");
        }
    }
}
