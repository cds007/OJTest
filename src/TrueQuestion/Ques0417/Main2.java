package TrueQuestion.Ques0417;

import java.util.*;

public class Main2 {

    static Map<String,Set<String>> graph = new HashMap<>();//图
    static Set<String> fathers = new HashSet<>();
    static Map<String,Integer> lvl1s = new HashMap<>();
    static Map<String,Integer> lvl2s = new HashMap<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int DI = in.nextInt();
        int N = in.nextInt();
        in.nextLine();

        //a * 0 2
        //b a 0 3
        //构建图
        for (int i = 0; i < N; i++) {
            String[] temp = in.nextLine().split(" ");
            if (temp[1].equals("*")){
                //根节点
                fathers.add(temp[0]);
                if (temp[2].equals("0")){
                    lvl1s.put(temp[0],Integer.valueOf(temp[3]));
                }else{
                    lvl2s.put(temp[0],Integer.valueOf(temp[3]));
                }
            }else{
                if (!graph.containsKey(temp[1])){
                    Set<String> set = new HashSet<>();
                    set.add(temp[0]);
                    graph.put(temp[1],set);
                }else{
                    Set<String> set = graph.get(temp[1]);
                    set.add(temp[0]);
                    graph.put(temp[1],set);
                }
                if (temp[2].equals("0")){
                    lvl1s.put(temp[0],Integer.valueOf(temp[3]));
                }else{
                    lvl2s.put(temp[0],Integer.valueOf(temp[3]));
                }
            }
        }
        int cnt = 0;
        for (String root :
                fathers) {
            int[] arr = dfs(root);
            if (arr[0]*5+arr[1]*2>DI){
                cnt++;
            }
        }
        System.out.println(cnt);
    }

    public static int[] dfs(String root){
        //dfs求根节点的值
        int l1 = lvl1s.containsKey(root)?lvl1s.get(root):0;
        int l2 = lvl2s.containsKey(root)?lvl2s.get(root):0;
        //dfs每个子节点
        if (graph.containsKey(root)){
            Set<String> set = graph.get(root);
            if (!set.isEmpty()){
                for (String child :
                        set) {
                    int[] cArr = dfs(child);
                    l1+=cArr[0];
                    l2+=cArr[1];
                }
            }
        }
        int[] ret = new int[]{l1,l2};
        return ret;
    }
}
