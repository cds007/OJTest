package Que150.ZuHe15;

import java.util.ArrayList;
import java.util.List;

public class Solution77 {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        backtracking(n,k,1);
        return result;
    }

    //回溯三部曲
    public void backtracking(int n,int k,int startIndex){
        //终止条件
        if (path.size()==k){
            result.add(new ArrayList<>(path));
            return;
        }
        //for循环
        for(int i=startIndex;i<=n;i++){
            //处理
            path.add(i);
            //递归
            backtracking(n,k,i+1);
            //回溯
            path.remove(path.size()-1);
        }
        return;
    }
}
