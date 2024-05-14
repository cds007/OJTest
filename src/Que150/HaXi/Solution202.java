package Que150.HaXi;

public class Solution202 {
    public boolean isHappy(int n) {
        //1.我的想法：这题我还真没什么想法，false条件就是出现一个循环，循环的常见判断方式有：1.快慢指针；2.集合存储；3.递归
        //2.这题我们参考题解的快慢指针解法
        //4 → 16 → 37 → 58 → 89 → 145 → 42 → 20 → 4
        int slow = n,fast = n;
        do{
            slow = sum(slow);
            fast = sum(fast);
            fast = sum(fast);
        }while (slow!=fast);
        return slow==1;
    }

    public int sum(int n){
        int s = 0;
        while (n>0){
            int bit = n%10;
            s += bit*bit;
            n = n/10;
        }
        return s;
    }
}
