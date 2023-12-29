package Implementation.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
<IDEA> ⚠️
무한히 큰 배열이기에 미리 만들어 두고 완전탐색하는 방식은 힘들 것이라고 판단이 된다.

1/1 와 같이 분수 꼴로 표현된 값이 2차원 배열인 행렬의 좌표라고 생각할 수 있음.
1 -> 1,1

2 -> 1,2
3 -> 2,1

4 -> 3,1
5 -> 2,2
6 -> 1,3

7 -> 1,4
8 -> 2,3
9 -> 3,2
10-> 4,1

규칙성이 보인다
1번째 는 1,1로 고정
2번째는 최대 2까지 2개
3번째는 최대 3까지 3개
4번째는 최대 4까지 4개
...
1 : 1
2~3 : 2
4~6 : 3
7~10: 4

1  1+1  1+1+2  1+1+2+3  1+1+2+3+4

1   2    4       7       11

n =
 */
public class P_1193 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());

        int cross_cnt = 1; // 현재 T(대각선)의 원소 개수
        int prev_count_sum = 0; // 1부터 T-1대각선 까지의 원소 개수

        while(true){

            //직선 대각선 누적합 + 해당 대각선 개수 이용한 범위 판별
            if (x <= prev_count_sum + cross_cnt) {

                // 대각선의 개수가 홀수라면
                if (cross_cnt % 2 == 1) {
                    // 분자가 큰 수부터 시작
                    // 분자는 대각선상 내의 블럭 개수 - (X번째 - 직전 대각선까지의 블럭 개수 - 1 )
                    // 분모는 X 번째 - 직전 대각선까지의 블럭 개수
                    // ex) 1/4
                    // 분자: 4 - (7 - 3 - 1) = 1
                    // 분모: 7 - 3
                    int numerator = cross_cnt - (x - prev_count_sum - 1);
                    int denominator = x - prev_count_sum;
                    System.out.println(numerator+"/"+denominator);
                    break;
                }
                // 대각선상의 블럭의 개수가 짝수라면
                else {
                    // 대각선상의 블럭의 개수가 홀수일 때랑 반대로 출력해주면 됨.
                    int denominator = cross_cnt - (x - prev_count_sum - 1);
                    int numerator = x - prev_count_sum;

                    System.out.println(numerator + "/" + denominator);
                    break;
                }
            }else {
                prev_count_sum += cross_cnt;
                cross_cnt++;
            }
        }
    }
}
