package huaweiExam.t3;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        in.nextLine();
        int[][] nums = new int[N][100000];
        List<Map<Integer,Integer>> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String[] str = in.nextLine().split(" ");
            int n1 = Integer.valueOf(str[0]);
            int n2 = Integer.valueOf(str[1]);
            list.add(new HashMap<>(n1,n2));
            for (int j = n2; j <= 100000; j+=n1) {
                nums[i][j] = 1;
            }
        }
        int min = 0;
        int[] cnt = new int[N];
        boolean flag = false;
        int start = 0;
        for (int i = 0; i < 100000; i++) {
            for (int j = 0; j < N; j++) {
                if (!flag){
                    flag = true;
                    start = i;
                    for (int k = 0; k < N; k++) {
                        cnt[k] = 0;
                    }
                }
                if (nums[j][i]==1){
                    cnt[j]=1;
                }
            }
            int j = 0;
            for ( j = 0; j < N; j++) {
                if (cnt[j]==0){
                    break;
                }
            }
            if (j==N){
                min = Math.min(min,start);
            }
        }
        System.out.println(min);
    }
}
