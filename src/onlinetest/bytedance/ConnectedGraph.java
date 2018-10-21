package onlinetest.bytedance;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ConnectedGraph {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int nodes = s.nextInt();
        int edgesNum = s.nextInt();
        int[][] graph = new int[nodes][nodes];
        int[][] edges = new int[edgesNum][];
        for (int i = 0; i < edgesNum; i++) {
            int row = s.nextInt();
            int col = s.nextInt();
            graph[row - 1][col - 1] = graph[col - 1][row - 1] = 1;
            edges[i] = new int[2];
            edges[i][0] = row - 1;
            edges[i][1] = col - 1;
        }
        int[] cuts = new int[edgesNum];
        for (int i = 0; i < edgesNum; i++) {
            cuts[i] = s.nextInt();
        }
        for (int i = 0; i < edgesNum; i++) {
            int cut = cuts[i];
            int row = edges[cut - 1][0];
            int col = edges[cut - 1][1];
            graph[row][col] = graph[col][row] = 0;
            if (!judegConnection(row, col, graph)){
                System.out.println(i + 1);
                break;
            }
        }
//        int i = 0;
//        while (i++ < edgesNum){
//            int cut = s.nextInt();
//            int row = edges[cut - 1][0];
//            int col = edges[cut - 1][1];
//            graph[row][col] = graph[col][row] = 0;
//            if (!judegConnection(row, col, graph)){
//                System.out.println(i);
//                break;
//            }
//        }

    }

    public static boolean judegConnection(int row, int col, int[][] graph){
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
                if (graph[node][i] == 1){
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
