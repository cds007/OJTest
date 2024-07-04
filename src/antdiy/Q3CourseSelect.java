package antdiy;

import java.util.Arrays;
import java.util.Comparator;

public class Q3CourseSelect {
    public static void main(String[] args) {
        /**
         * 小明选课，这题我觉得应该是一个0-1背包的问题，所以接下来用0-1背包来解决。
         */
        int[] startTimes = {0, 1, 3, 5, 8, 5};
        int[] endTimes = {6, 2, 4, 7, 9, 9};
        int[] priorities = {3, 1, 2, 4, 5, 6};
        System.out.println(maxPrioritySum(startTimes, endTimes, priorities));
    }

    public static int maxPrioritySum(int[] startTimes, int[] endTimes, int[] priorities) {
        int n = startTimes.length;
        int[][] courses = new int[n][3];

        // 将开始时间、结束时间和优先级组合到一个数组中
        for (int i = 0; i < n; i++) {
            courses[i] = new int[]{startTimes[i], endTimes[i], priorities[i]};
        }

        // 根据结束时间对所有课程进行排序
        Arrays.sort(courses, (a,b)->{
            return a[1]-b[1];
        });


        // dp[i] 表示到达第i个课程时能获得的最大优先级之和
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = courses[i][2]; // 初始化为当前课程的优先级
            for (int j = 0; j < i; j++) {
                // 如果当前课程开始时间不早于上一个课程的结束时间，则可以累加优先级
                if (courses[i][0] >= courses[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + courses[i][2]);
                }
            }
            /**
             * 1 0 0 0 0 0
             * 1 3 0 0 0 0
             * 1 3 3 0 0 0
             * 1 3 3 7 0 0
             * 1 3 3 7 12 0
             * 1 3 3 7 12 9
             */
        }
        // 找到最大的优先级之和
        int maxPrioritySum = 0;
        for (int i = 0; i < n; i++) {
            maxPrioritySum = Math.max(maxPrioritySum, dp[i]);
        }
        return maxPrioritySum;
    }

}
