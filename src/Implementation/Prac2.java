package Implementation;

import java.util.Scanner;

/*
115page
<요구사항>
체스판 규격: 8x8 좌표평면
 a b . . h
1
.
.
8

나이트 이동 규칙(L)
1) 수평 2칸 + 수직 1칸
오른쪽 2칸 + (위 or 아래)
왼쪽 2칸 + (위 or 아래)

2) 수직 2칸 + 수평 1칸
위 2칸 + (오른 or 왼)
아래 2칸 + (오른 or 왼)

가장 자유로운 나이트는 총 8가지의 최대 경우를 가짐.

나이트 위치 주어지면, 이동할 수 있는 경우의 수 출력 프로그램.

<IDEA>
먼저, 나이트의 위치를 a1과 같이 입력 받는다.
그 다음, a1을 좌표 평면 상의 x,y좌표로 치환한다.(연산하기 편하게)

현재 자리가 x,y라면,
x + 2, (y + 1 or y - 1)
x - 2, (y + 1 or y - 1)
y + 2, (x + 1 or x - 1)
y - 2, (x + 1 or x - 1)
위와 같은 경우의 수가 생기며, 위 경우가 체스판을 벗어나지 않는 경우만 계산한다.


 */
public class Prac2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String loc = sc.next();
        int row = loc.charAt(1)-48;
        int col = loc.charAt(0)-96; // using ascii code
        int cnt=0;

        /*
        먼저 가장 직관적으로 풀어봤다.
         */
        if(row+2<9 && col+1<9) cnt++;
        if(row+2<9 && col-1>0) cnt++;
        if(row-2>0 && col+1<9) cnt++;
        if(row-2>0 && col-1>0) cnt++;
        if(col+2<9 && row+1<9) cnt++;
        if(col+2<9 && row-1>0) cnt++;
        if(col-2>0 && row+1<9) cnt++;
        if(col-2>0 && row-1>0) cnt++;


        System.out.println(cnt);
    }
}
