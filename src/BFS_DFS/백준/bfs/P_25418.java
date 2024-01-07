package BFS_DFS.백준.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
두 갈림길 처럼 이진 트리 형태로 그래프를 생각해보면 어떨까?

근데 이거 그리디 아닌가..?
 */
public class P_25418 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int a;
    static int k;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        a = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        int cnt=0;
        int cal_1 = 0;
        int cal_2 = 0;
        while (true) {
            if(a==k) break;

            if(a*2 <= k) {
                a*=2;
                cal_2++;
            }
            else {
                a += 1;
                cal_1++;
            }
            cnt++;
        }
        System.out.println("a = " + a);
        System.out.println("cal_1 = " + cal_1);
        System.out.println("cal_2 = " + cal_2);
        System.out.println(cnt);
        br.close();
    }
}
