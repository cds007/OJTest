package TrueQuestion.Ques0424;

import java.util.*;

public class MicroserviceGroups {
    static class Graph {
        //1.图的数据结构可以学习一下，用ListList来存，而且这个是有向图
        List<List<Integer>> adjList;

        Graph(int n) {
            adjList = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                adjList.add(new ArrayList<>());
            }
        }

        void addEdge(int from, int to) {
            adjList.get(from).add(to);
        }
    }

    static class Cycle {
        List<Integer> services;
        int startService;
        int maxService;

        Cycle() {
            services = new ArrayList<>();
            startService = Integer.MAX_VALUE;
            maxService = Integer.MIN_VALUE;
        }

        void addService(int service) {
            services.add(service);
            startService = Math.min(startService, service);
            maxService = Math.max(maxService, service);
        }

        int getH() {
            return services.size() - 1; // V is always 1 less than the size of the cycle
            //2.这个计算不太对
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] edges = new int[n];
        for (int i = 0; i < n; i++) {
            edges[i] = scanner.nextInt();
        }

        Graph graph = new Graph(n);
        for (int i = 0; i < n; i++) {
            graph.addEdge(i, edges[i]);
        }

        List<Cycle> cycles = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (!visited.contains(i)) {
                flag = false;
                Cycle cycle = new Cycle();
                dfs(graph, i, -1, visited, cycle);
                if (!cycle.services.isEmpty()) {
                    cycles.add(cycle);
                }
            }
        }

        cycles.sort((a, b) -> {
            int hCompare = b.getH() - a.getH();
            if (hCompare != 0) {
                return hCompare;
            }
            return b.maxService - a.maxService;
        });//3.细节比较器

        Cycle topCycle = cycles.get(0);
        for (int service : topCycle.services) {
            System.out.print(service + " ");
        }
    }

    public static boolean flag = false;//是否找到圈

    private static void dfs(Graph graph, int current, int parent, Set<Integer> visited, Cycle cycle) {
        visited.add(current);//5.细节dfs，可以学习这个思路
        cycle.addService(current);
        for (int neighbor : graph.adjList.get(current)) {
            if (neighbor == parent) {
                continue;
            }
            if (visited.contains(neighbor)) {
                // We found a cycle, no need to continue DFS
                flag = true;
                return;
            }//4.这个判断是否有环的思路不对
            dfs(graph, neighbor, current, visited, cycle);
        }
        // If we didn't find a cycle, remove the last service from the cycle
        if (!flag){
            cycle.services.remove(cycle.services.size() - 1);
        }
    }
}

