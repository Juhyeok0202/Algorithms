package Implementation;

import java.util.Scanner;

/*
NxM크기.
각 1x1은 육지 또는 바다(A,B)
캐릭터는 동서남북 중 한 곳을 바라봄.
(A,B)라는 위치에서
A: 북쪽으로 부터 떨어진 칸의 개수 (Row)
B: 서쪽으로 부터 떨어진 칸의 개수 (Col)
바다는 갈 수 X

1. 반시계 방향으로 90도 회전한 방향부터 차례대로 갈 곳을 정함.
2. 캐릭터 바로 왼쪽 방향에 아직 가보지 않은 칸 있으면, 왼쪽방향으로 회전한 다음 전진.(그렇지 않다면, 회전만하고 1로 복귀)
3. 네 방향 모두 가봄 or 바다 -> 바라 보는 방향을 유지한 채로 뒤로 한 칸 + 1단계로 복귀(단, 뒤에 바다라면 움직임 멈추고 1로 복귀)
 */
public class Prac3 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n= sc.nextInt(); // 세로 크기(#row)
        int m= sc.nextInt(); // 가로 크기(#col)

        int a= sc.nextInt(); // x좌표
        int b= sc.nextInt(); // y좌표
        int d= sc.nextInt(); // 0:북, 1:동, 2:남, 3:서(바라보는 방향)

        /*맵 구성(육지:0 or 바다:1) 단, 처음 캐릭터가 위치한 곳은 반드시 육지*/
        int[][] map = new int[n][m];
        constructMap(map);

        int numOfvisit = 0;

        /*
        d 기준 방향을 어떻게 구분할건데?
        0 -> 3 -> 2 -> 1 -> ...  양의 정수 0~3 범위에서 -- 해나가야겠다.

        북(0) : (-1,0)
        동(1) : (0,+1)
        남(2) : (+1,0)
        서(3) : (0,-1)
         */
        int[] dx = {-1,0,1,0}; // 북 동 남 서 순서.
        int[] dy = {0,1,0,-1};
        int[][] visit = new int[n][m];
        visit[a][b]=1; //현재 위치는 방문 처리
        int numOfturn=0;

        int nx,ny;
        while (true) {
            /*왼쪽으로 시선 회전*/
            d= turnLeft(d);

            /*좌향좌 후, 바라보고 있는 곳의 전진 좌표*/
            nx= a + dx[d];
            ny = b + dy[d];

            if (visit[nx][ny] == 0 && map[nx][ny] == 0) { // 미방문 and 육지
                numOfturn=0; // 턴 횟수 초기화

                /*전진*/
                a=nx;
                b=ny;

                /*전진 한 곳 방문 표시 및 카운트*/
                visit[a][b]=1;
                numOfvisit++;

            }else{ // 이미 방문 or 바다(전진X)
                numOfturn++; // 턴 횟수 증가
            }

            if (numOfturn == 4) { // 네 방향 모두 이미 가 봄 이동 불가
                nx = a - dx[d];
                ny = b - dy[d];

                if(map[nx][ny]==1) break; // 뒤에도 바다인 경우 움직임 정지(끝)
                else{
                    a = nx;
                    b = ny;
                    numOfvisit++;
                }
            }
        }
        System.out.println(numOfvisit);
        sc.close();
    }

    public static void constructMap(int[][] map){
        for (int i = 0; i < map.length; ++i) {
            for (int j = 0; j < map[0].length; ++j) {
                map[i][j]=sc.nextInt();
            }
        }
    }

    public static int turnLeft(int direction){
        direction--;
        if(direction==-1) direction=3;
        return direction;
    }
}

