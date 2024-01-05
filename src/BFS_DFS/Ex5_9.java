package BFS_DFS;

import java.util.LinkedList;
import java.util.Queue;

/*
간단한 이해를 위한 BFS 구현
Adjacency List 방식 이용
 */
public class Ex5_9 {
    static boolean[] visited = new boolean[9];
    static int[][] graph = {{},
            {2,3,8},
            {1,7},
            {1,4,5},
            {3,5},
            {3,4},
            {7},
            {2,6,8},
            {1,7}};
    static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) {
        bfs(graph, 1, visited);
    }

    public static void bfs(int[][] graph, int v, boolean[] visited) {

        queue.offer(v);
        visited[v] = true;

        while(!queue.isEmpty()){
            int currentNode = queue.poll();
            System.out.print(currentNode + " -> ");

            for (int adjNode : graph[currentNode]) {
                if (!visited[adjNode]) {
                    queue.offer(adjNode);
                    visited[adjNode] = true;
                }
            }
        }

    }
}
