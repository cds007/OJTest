package TrueQuestion.Ques0424;

import java.util.*;

public class Main2 {
    //用三个数组来存，用类与对象来存，都可以的，这个代码写的太漂亮了。
    static class Player {
        int id;
        int totalGoals;
        int maxConsecutiveGoals;
        List<Integer> missTimestamps;
        //11100
        //1011100111 1011101101
        Player(int id, String shots) {
            this.id = id;
            this.totalGoals = 0;
            this.maxConsecutiveGoals = 0;
            this.missTimestamps = new ArrayList<>();
            int consecutiveGoals = 0;
            for (int i = 0; i < shots.length(); i++) {
                if (shots.charAt(i) == '1') {
                    totalGoals++;
                    consecutiveGoals++;
                    if (consecutiveGoals > maxConsecutiveGoals) {
                        maxConsecutiveGoals = consecutiveGoals;
                    }
                } else {
                    missTimestamps.add(i + 1); // 保存射失的时间戳
                    consecutiveGoals = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // 足球队员数
        int m = scanner.nextInt(); // 射门训练次数
        scanner.nextLine(); // 消耗换行符

        String line = scanner.nextLine();
        String[] shots = line.split(" ");
        Player[] players = new Player[n];
        for (int i = 0; i < n; i++) {
            players[i] = new Player(i + 1, shots[i]);
        }

        Arrays.sort(players, (a, b) -> {//lamba表达式自定义比较器
            if (a.totalGoals != b.totalGoals) {
                return b.totalGoals - a.totalGoals;//这个是降序排序
            }
            if (a.maxConsecutiveGoals != b.maxConsecutiveGoals) {
                return b.maxConsecutiveGoals - a.maxConsecutiveGoals;//降序排序
            }
            int minSize = Math.min(a.missTimestamps.size(), b.missTimestamps.size());//这个可以不用，因为到这了丢球数肯定是一样的
            for (int i = 0; i < minSize; i++) {
                if (a.missTimestamps.get(i) != b.missTimestamps.get(i)) {
                    return b.missTimestamps.get(i) - a.missTimestamps.get(i);//应该也得降序排序
                }
            }
            return a.id - b.id;//这个是升序排序，没毛病
        });

        for (Player player : players) {
            System.out.print(player.id + " ");
        }
    }
}
