package BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
0: 괴물이 없는 부분
1: 괴물이 있는 부분

시작 위치: (1,1)
미로의 출구: (N,M) (행열의 가장 오른쪽 아래)

1칸씩 이동 가능

탈출을 위한 최소한의 칸 개수(시작 칸과 마지막 칸 개수까지 계산)
 */
public class Prac_4 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n;
    static int m;
    static int[][] map = new int[5][201];

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        initMap();

        /*
        0은 못가니까 무시
        1이면, 이전 값을 더해서 prev + 1 값으로 변경.
        그렇게 모두 변경하고 난 뒤, N,M의 value를 읽으면 됨.

        인접 => 현재 노드 기준 상하좌우

         */
        bfs(0, 0);
    }

    static class Node{
        private int x;
        private int y;

        public Node() {

        }

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
        public int getX() {
            return this.x;
        }

        public int getY() {
            return this.y;
        }
    }

    public static void bfs(int x, int y) {
        Node node = new Node(x, y);
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);

        // 상하좌우 변화량 정의
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();
            x = currentNode.getX();
            y = currentNode.getY();

            for (int i = 0; i < 4; ++i) {
                // Search about the all of avaliable direction
                int nx = x + dx[i];
                int ny = y + dy[i];

                // CASE: the out of bound of Map
                if ( nx<0 || nx>=n || ny<0 || ny>=m) continue; // Ignorance
                // CASE: wall
                if ( map[nx][ny]==0 ) continue; // Ignorance
                // CASE: First visited
                if( map[nx][ny] == 1 ){
                    map[nx][ny] = map[x][y] + 1;
                    queue.offer(new Node(nx, ny));
                }
            }
        }

        int answer = map[n - 1][m - 1];
        System.out.println(answer);
    }

    public static void initMap() throws IOException{
        for (int i = 0; i < n; ++i) {
            String str = br.readLine();
            for (int j = 0; j < m; ++j) {
                map[i][j] = str.charAt(j) - '0';
            }
        }
    }
}
