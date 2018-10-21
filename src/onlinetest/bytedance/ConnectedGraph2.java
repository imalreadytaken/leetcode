package onlinetest.bytedance;

import java.util.*;

public class ConnectedGraph2 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int nodes = s.nextInt();
        int edgesNum = s.nextInt();
        int[][] edges = new int[edgesNum][];
        Set<Integer>[] graph = new Set[nodes];
        for (int i = 0; i < edgesNum; i++) {
            int row = s.nextInt() - 1;
            int col = s.nextInt() - 1;

            if (graph[row] == null)
                graph[row] = new HashSet<>();

            if (graph[col] == null)
                graph[col] = new HashSet<>();

            graph[row].add(col);
            graph[col].add(row);
            edges[i] = new int[2];
            edges[i][0] = row;
            edges[i][1] = col;
        }
        int[] cuts = new int[edgesNum];
        for (int i = 0; i < edgesNum; i++) {
            cuts[i] = s.nextInt();
        }
        for (int i = 0; i < edgesNum; i++) {
            int cut = cuts[i];
            int row = edges[cut - 1][0];
            int col = edges[cut - 1][1];
            graph[row].remove(col);
            graph[col].remove(row);
            if (!judegConnection(row, col, graph)){
                System.out.println(i + 1);
                break;
            }
        }

    }

    public static boolean judegConnection(int row, int col, Set<Integer>[] graph){
        int size = graph.length;
        if (size <= 1 || row == col)
            return true;

        Queue<Integer> que = new LinkedList<>();
        int[] arrived = new int[size];
        arrived[row] = 1;
        que.offer(row);
        while (!que.isEmpty()){
            int node = que.poll();
            for (int i = 0; i < size; i++) {
                if (graph[node].contains(i)){
                    if (i == col)
                        return true;
                    if (arrived[i] == 0){
                        arrived[i] = 1;
                        que.offer(i);
                    }
                }
            }
        }
        return false;
    }

}
