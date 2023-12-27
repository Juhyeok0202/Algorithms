package Greedy.백준;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/*
<요구사항>
N : 로프의 개수(1 <= N <= 100,000)

로프의 굵기, 길이는 각각 상이
로프 병렬 연결 => 로프에 걸리는 중량 분산 가능

k개 루프로 w중량 물체 ==> 각 로프에 걸리는 중량 w/k

로프들을 이용하여 '들어 올릴 수 있는 물체 최대 중량'

굳이 모든 로프 사용 X

<Idea>
먼저, 로프의 개수 N을 입력 받는다.
그 다음, N개의 로프 배열에 각 로프가 견딜 수 있는 최대 중량을 입력해준다.

먼저, 물체의 최대 하중이 로프의 n/k(특정 로프가 버팀 가능한 중량)에만 맞춰지면 된다.
그 중에서 가장 작은 중량을 버티는 로프를 기준으로 최대 중량을 계산한다.
그 다음, 내림차순 정렬한다.(강도가 센 로프부터 테스트)
그 다음, 0부터 n(n=0,1,2,...)번째 로프를 함께 사용했을 때의 중량을 구한다.(뒤쪽 요소 기준에 맞춘다.)
그 다음, 위 과정에서 가장 큰 수를 찾아 출력한다.

<오답원인>
1T: 항상 모든 로프를 사용하려고 했음
 */
public class P_2217 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Integer[] ropes = new Integer[n];

        for (int i = 0; i < n; ++i) {
            ropes[i] = sc.nextInt();
        }

        Arrays.sort(ropes, Collections.reverseOrder()); //내림차순 정렬

        int maxWeight =0;
        for (int i = 0; i < ropes.length; ++i) {
            maxWeight = Math.max(maxWeight,ropes[i]*(i+1));
        }
        System.out.println(maxWeight);
    }
}
