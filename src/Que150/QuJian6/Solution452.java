package Que150.QuJian6;

import java.util.Arrays;
import java.util.Comparator;

public class Solution452 {
    public int findMinArrowShots(int[][] points) {
        //我的想法：1.这题跟合并区间那题挺像的，排序+贪心算法
        //1.先根据右端点升序排序；2.取最小的右端点，判断如果左端点大小大于右端点，那么返回数量+1；
        //原理：任意一只满足条件的最优值都能向右靠到一个气球的右端点上并满足同样的最优效果，所以我们只需要考虑气球的右端点即可。
        if (points.length == 0) {
            return 0;
        }
        Arrays.sort(points, new Comparator<int[]>() {
            public int compare(int[] point1, int[] point2) {
                if (point1[1] > point2[1]) {
                    return 1;
                } else if (point1[1] < point2[1]) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
        int pos = points[0][1];
        int ans = 1;
        for (int[] balloon: points) {
            if (balloon[0] > pos) {
                pos = balloon[1];
                ++ans;
            }
        }
        return ans;
    }
}
