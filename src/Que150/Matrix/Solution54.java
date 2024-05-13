package Que150.Matrix;

import java.util.ArrayList;
import java.util.List;

public class Solution54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        //输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
        //输出：[1,2,3,6,9,8,7,4,5]
        //就看怎么模拟了，按照代码随想录的螺旋矩阵II那样去写这个代码
        //直接上模拟代码，还是有很大值得学习的地方的
        List<Integer> order = new ArrayList<>();
        if (matrix==null||matrix.length==0||matrix[0].length==0){
            return order;//特殊情况考虑
        }
        int rows = matrix.length,columns = matrix[0].length;//所有行列
        boolean[][] visited = new boolean[rows][columns];
        int total = rows*columns;
        int[][] directions = {{0,1},{1,0},{0,-1},{-1,0}};//四个方向值得学习
        int directionIndex = 0;
        int row = 0,column = 0;//当前的行和列
        for (int i = 0; i < total; i++) {//遍历所有数字
            order.add(matrix[row][column]);
            visited[row][column] = true;
            int nextRow = row+directions[directionIndex][0];
            int nextColumn = column+directions[directionIndex][1];
            if (nextRow<0||nextRow>=rows||nextColumn<0||nextColumn>=columns||visited[nextRow][nextColumn]){//判断顺序条件,visited转一圈就能想明白
                directionIndex = (directionIndex+1)%4;
            }//其实nextRow<0可以不需要
            row+=directions[directionIndex][0];
            column+=directions[directionIndex][1];
        }
        return order;
    }
}
