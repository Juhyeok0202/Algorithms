package Implementation;

import java.util.Scanner;

public class ex4_1_ndb {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //N을 입력받기
        int n = sc.nextInt();
        sc.nextLine(); // 버퍼 비우기 💡: 이런 방법도 있다.(개행 문자를 버퍼에서 없애주는 방법)
        String[] plans = sc.nextLine().split(" "); // 속도는 느릴 지언정 간단하다.

        int x = 1, y = 1; // 초기 위치

        // L, R, U, D에 따른 이동 방향
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};
        char[] moveTypes = {'L', 'R', 'U', 'D'}; // 새로운 방향이 없겠지만, 확장성에 훨씬 좋아보임

        // 이동 계획을 하나씩 확인
        for (int i = 0; i < plans.length; ++i) {
            char plan = plans[i].charAt(0);
            // 이동 후 좌표 구하기
            int nx = -1, ny = -1;
            for (int j = 0; j < 4; ++j) {
                if(plan==moveTypes[j]){
                    nx = x + dx[j];
                    ny = y + dy[j];
                }
            }
            //공간을 벗어나는 경우 무시
            if(nx < 1 || ny < 1 || nx > n || ny > n)continue;
            x =nx;
            y =ny;
        }

        System.out.println(x+" "+y);
    }
    /*
    가독성이나 효율성 면에서 내 코드가 더 좋아보인다. 다만, 코드 확장성과 예외 처리를 고려한다면 위 코드가 더 좋아보인다.
     */
}
