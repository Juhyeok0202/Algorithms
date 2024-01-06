package BFS_DFS.백준.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

/*
바닥 장식 모양은 다음과 같이 이루어진다.
'-' 'ㅣ'

두 개의 - 가 인접해 있고, 같은 행이면 => 두 개는 같은 나무 판자
--
두 개의 ㅣ가 인접해 있고, 같은 열이면 => 두 개는 같은 나무 판자
ㅣ
ㅣ
기훈이의 방 바닥을 장식하는데 필요한 나무 판자의 개수를 출력.

- : 좌우만 탐색
ㅣ: 상하만 탐색
 */
public class P_1388 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n;
    static int m;
    static char[][] graph = new char[51][51];
    static boolean[][] visited = new boolean[51][51];

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        initGraph();
        int wood = 0;

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if(dfs(i,j)) wood++;
            }
        }

        System.out.println(wood);
        br.close();
    }

    public static boolean dfs(int x, int y) {

        if (x < 0 || x >= n || y < 0 || y >= m || visited[x][y]==true) {
            // graph 범위를 벗어난 노드 or 이미 방문한 노드
            return false;
        }

        visited[x][y] = true; //방문처리

        if(graph[x][y] == '-'){
            // 같은 행에 있는 것(좌 우)만 탐색
            if( y>=0 && y<m && graph[x][y+1]=='-') dfs(x, y+1);
            return  true;
        }

        if(graph[x][y] == '|'){
            // 같은 열에 있는 것(상 하)만 탐색
            if( x>=0 && x<n && graph[x+1][y]=='|') dfs(x + 1, y);
            return true;
        }

        return false;
    }

    public static void initGraph() throws IOException{
        for (int i = 0; i < n; ++i) {
            String str = br.readLine();
            for (int j = 0; j < m; ++j) {
                graph[i][j] = str.charAt(j);
            }
        }
    }
}
