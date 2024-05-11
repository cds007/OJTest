package Que150.ArrayStr;

public class Solution134 {
    //输入: gas = [1,2,3,4,5], cost = [3,4,5,1,2]
            //    0,1,2,3,4
    //输出: 3
    //模拟的话，On2暴力法
    //优化的话,不太会
    //1.模拟法
    public int canCompleteCircuit2(int[] gas, int[] cost) {
        boolean flag = false;
        for (int i = 0; i < gas.length; i++) {
            if (gas[i]>=cost[i]){
                //可以启动
                flag = true;
                int curGas = gas[i];//当前汽油
                for (int j = 0; j < gas.length; j++) {//这一步并不简单
                    if (curGas<cost[(i+j)%gas.length]){
                        flag = false;
                        break;
                    }
                    curGas = curGas-cost[(i+j)%gas.length]+gas[(i+j+1)%gas.length];
                }
                if (flag){
                    return i;
                }
            }
        }
        return -1;
    }
    //2.模拟法超时，优化思路：
    //题解法：我们首先检查第 0 个加油站，并试图判断能否环绕一周；如果不能，就从第一个无法到达的加油站开始继续检查。
    //这个是On的思路（或者可以说O(2n)），反正不可能是On2。
    //基于是思想是第一个无法到达的加油站前都不可能是起点
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int i = 0;
        while (i<n){
            int cnt = 0;
            int gasSum = 0;
            int costSum = 0;
            while (cnt<n){
                int j = (i+cnt)%n;
                gasSum+=gas[j];
                costSum+=cost[j];
                if (gasSum<costSum){//1.基本定理1
                    break;
                }
                cnt++;
            }
            if (cnt==n){
                return i;
            }else{
                i = i+cnt+1;//2.推论1
            }
        }
        return -1;
    }

}
