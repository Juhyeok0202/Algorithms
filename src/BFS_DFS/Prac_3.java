package BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Prac_3 {

    static int[][] tray = new int[1001][1001];
    static int n;
    static int m;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException{

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        initTray();

        int numOfIceCream=0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if(dfs(i,j)) numOfIceCream++;
            }
        }
        System.out.println(numOfIceCream);
        br.close();
    }

    public static void initTray() throws IOException{
        for (int i = 0; i < n; ++i) {
            String str = br.readLine();
            for (int j = 0; j < m; ++j) {
                tray[i][j] = str.charAt(j) - '0';
            }
        }
    }

    public static boolean dfs(int x, int y) {

        // bound out of tray
        if (x < 0 || x >= n || y < 0 || y >= m) {
            return false;
        }

        if (tray[x][y] == 0) {
            // 구멍이 뚫려있다면(미방문 이라면)
            tray[x][y] = 1;

            dfs(x - 1, y);
            dfs(x + 1, y);
            dfs(x, y - 1);
            dfs(x, y + 1);
            return true;
        }
        return false;
    }
}
