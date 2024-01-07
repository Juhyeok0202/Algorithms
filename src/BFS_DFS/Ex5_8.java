package BFS_DFS;

/*
이해를 위한 간단한 DFS 구현 예제
Adjacency List 방식
 */
public class Ex5_8 {
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
    public static void main(String[] args) {
        dfs(graph,1,visited);
    }

    public static void dfs(int[][] graph, int v, boolean[] visited) {

        //현재 노드를 방문 처리
        visited[v]=true;
        System.out.println(v);
        //현재 노드와 연결된 다른 노드를 재귀적으로 방문
        for (int adjNode : graph[v]) {
            //인접한 노드가 방문한 적이 없다면 DFS수행
            if (!visited[adjNode]) {
                dfs(graph,adjNode,visited);
            }
        }
    }
}