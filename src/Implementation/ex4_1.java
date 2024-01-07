package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
<IDEA>
먼저, Line1에서 공간의 크기 N을 입력 받는다.
그 다음, Line2에서 여행가의 이동 계획을 입력 받는다. L R U D

먼저, 현재 위치 변수를 1 1로 초기화해둔다.
그 다음, L R U D 에 따라 위치 변수를 증감해준다.
그 다음, 움직임 명령 리스트 길이만큼 했으면 종료.

<노트>
처음에 List가 아니라, int[101] 배열 형태로 했더니, 입력된 움직임 다음의 NullPointerException이 터짐. 사용하지 않는 공간이라 예외 없을 것이라고 생각했는데..
그래서 완전 가변적인 메모리 공간을 가지는 List로 바꿈.

처음에는 Scanner가 편해서 Scanner로 구현하려했는데, 움직임에 대한 입력 문자 개수가 가변적이기 때문에 입력 받은 문자열을 모두 Buffer에 넣고,
공백 기준 토큰화하여 'hasMoreTokens'를 사용하기 위해 입력 방식을 바꿈(사실 이게 더 빠르기도 해서 이거 사용하는게 좋았겠지만, 생각 하지 못한 문제점을 마주치기에는
단순한 Scanner 활용이 더 좋아보였음.)
 */
public class ex4_1 {
    public static void main(String[] args) throws IOException {

        /* Input */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        List<String> move = new ArrayList<>();

        int index=0;
        while (st.hasMoreTokens()) {
            move.add(st.nextToken());
        }

        int current_x=1;
        int current_y=1;

        /* 행동 횟수만큼 진행 */
        for (String action : move) {
            if(action.equals("R") && current_y < n) current_y++;
            if (action.equals("L") && current_y > 1) current_y--;
            if (action.equals("U") && current_x > 1) current_x--;
            if (action.equals("D") && current_x < n) current_x++;
        }

        System.out.println(current_x+" "+current_y);
    }
}
