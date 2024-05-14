package Que150.Matrix4;

public class Solution36 {
    public boolean isValidSudoku(char[][] board) {
        //判断数独是否有效
        //1.我的想法：直接模拟，三个规则，每行，每列，每个格子，那么是O(n2)的时间复杂度，空间复杂度一个O1的set就行了。
        //2.题解：遍历一次，可以使用哈希表记录每一行、每一列和每一个小九宫格中，每个数字出现的次数。
        //只需要遍历数独一次，在遍历的过程中更新哈希表中的计数，并判断是否满足有效的数独的条件即可。
        //想法跟我差不多，但是用三个哈希表（或者哈希数组）来存的话，时间是会减少很多O(n)。
        int[][] rows = new int[9][9];
        int[][] columns = new int[9][9];
        int[][][] subboxes = new int[3][3][9];//第（i，j）个格子中的哈希索引值的个数为...
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c!='.'){
                    int index = c-'0'-1;
                    rows[i][index]++;//第i行的值为c的计数加1，有点像计数数组
                    columns[j][index]++;//第j列值为c的计数加1
                    subboxes[i/3][j/3][index]++;//通过ij值取得方格坐标
                    if (rows[i][index]>1||columns[j][index]>1||subboxes[i/3][j/3][index]>1){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
