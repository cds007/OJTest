package TrueQuestion.Ques0424;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main2Imi {
    //模仿一下
    static class Player{
        int id;
        int goals;
        int maxGoal;
        List<Integer> miss;

        Player(int id,String goalStr){
            this.id = id;
            this.goals = 0;
            this.maxGoal = 0;
            this.miss = new ArrayList<>();
            int temp = 0;//记录连续进球
            for (int i = 0; i < goalStr.length(); i++) {
                char ch = goalStr.charAt(i);
                if (ch=='1'){
                    goals++;
                    temp++;
                    if (temp>maxGoal) maxGoal = temp;
                }else{
                    miss.add(i);
                    temp = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        Player[] players = new Player[n];
        in.nextLine();//重载换行符
        String[] str = in.nextLine().split(" ");
        for (int i = 0; i < n; i++) {
            players[i] = new Player(i+1,str[i]);
        }
        Arrays.sort(players,(a,b) -> {
            if (a.goals!= b.goals){
                return b.goals-a.goals;//降序
            }
            if (a.maxGoal!=b.maxGoal){
                return b.maxGoal-a.maxGoal;//降序
            }
            for (int i = 0; i < a.miss.size(); i++) {
                if (a.miss.get(i)!=b.miss.get(i)){
                    return b.miss.get(i) - a.miss.get(i);//降序
                }
            }
            return a.id-b.id;//升序
        });
        for (Player p :
                players) {
            System.out.print(p.id+" ");
        }
    }
}
