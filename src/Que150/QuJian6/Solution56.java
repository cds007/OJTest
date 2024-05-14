package Que150.QuJian6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution56 {
    public int[][] merge(int[][] intervals) {
        //题解：1.合理：先根据左端点排序排序，再根据左端点右端点排序，左端点在右端点的右边就新增，否则在原基础上更新右端点。
        if (intervals.length == 0) {
            return new int[0][2];
        }
        Arrays.sort(intervals,(intervals1,intervals2)->{
            return intervals1[0]-intervals2[0];//左端点升序排序
        });
        List<int[]> merged = new ArrayList<int[]>();
        for (int i = 0; i < intervals.length; ++i) {
            int L = intervals[i][0], R = intervals[i][1];
            if (merged.size() == 0 || merged.get(merged.size() - 1)[1] < L) {
                merged.add(new int[]{L, R});
            } else {
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], R);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }
}
