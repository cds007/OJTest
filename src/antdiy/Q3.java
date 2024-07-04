package antdiy;

public class Q3 {

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
        //这个方法还不完善，因为还需要根据结束时间进行排序
        int len = 0;
        for (int i = 0; i < endTimes.length; i++) if (endTimes[i] > len) len = endTimes[i];
        //dp数组表示到第i个时间为止最大的优先级是dp[i]
        int[] dp = new int[len + 1];
        //dp数组初始化
        for (int i = endTimes[0]; i <= len; i++) dp[i] = priorities[0];
        for (int j = 0; j <= len; j++) {
            System.out.print(dp[j] + " ");
        }
        System.out.println();
        //dp数组的遍历
        for (int i = 1; i < startTimes.length; i++) {//先遍历课程
            for (int j = len; j >= endTimes[i]; j--) {//再遍历时间线
                //如果j小于endTimes那肯定不会选这门课，所以j肯定大于等于endTimes
                dp[j] = Math.max(dp[j], dp[j] - (dp[endTimes[i]] - dp[startTimes[i]]) + priorities[i]);
            }
            for (int j = 0; j <= len; j++) {
                System.out.print(dp[j] + " ");
            }
            System.out.println();
        }
        return dp[len];
    }
}
