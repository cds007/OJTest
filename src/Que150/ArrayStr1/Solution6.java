package Que150.ArrayStr1;

import java.util.ArrayList;
import java.util.List;

public class Solution6 {
    public String convert(String s, int numRows) {
        //输入：s = "PAYPALISHIRING", numRows = 3
        //输出："PAHNAPLSIIGYIR"
        //1.我的第一个想法，用数组进行模拟，然后把数组打印出来，有点麻烦其实；
        //2.第二个想法，其实就是个数学问题吧，比如上面那个例子，就是从第一个开始，隔三个打印，然后再从第二个开始隔一个打印，类推，再做一些边界上的处理。但这个好像更麻烦。
        //3.题解的方法：题解这个太妙了！其实就是高中信息技术差不多学的内容。也是模拟，但是它的数据结构设计的巧妙，用sb来设计，其次转折点的设计用一个flag来设计，这真的很棒。
        if (numRows<2) return s;
        List<StringBuilder> list = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            list.add(new StringBuilder());
        }
        int i = 0;//标识行索引
        int flag = -1;//标识转折点
        for (char ch :
                s.toCharArray()) {
            list.get(i).append(ch);
            if (i==0||i==numRows-1) flag = -flag;
            i+=flag;
        }
        StringBuilder ret = new StringBuilder();
        for (int j = 0; j < list.size(); j++) {
            ret.append(list.get(j));
        }
        return ret.toString();
    }
}
