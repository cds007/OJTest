package Que150.ZuHe15;

import java.util.ArrayList;
import java.util.List;

public class Solution17 {

    List<String> list = new ArrayList<>();
    StringBuilder temp = new StringBuilder();
    String[] numString = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        if (digits==null||digits.length()==0) return list;
        //初始对应所有的数字，为了直接对应2-9，新增了两个无效的字符串""
        backtracking(digits,0);
        return list;
    }

    public void backtracking(String digits,int startIndex){
        if (startIndex==digits.length()){
            list.add(temp.toString());
            return;
        }

        String str = numString[digits.charAt(startIndex)-'0'];

        for(int i=0;i<str.length();i++){
            temp.append(str.charAt(i));
            backtracking(digits,startIndex+1);
            temp.deleteCharAt(temp.length() - 1);
        }

    }

}
