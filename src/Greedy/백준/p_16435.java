package Greedy.백준;

import java.util.*;

/*
<요구사항>
과일 1개 섭취 -> 길이 1 증가
과일은 지상으로부터 h_i(i=0,1,2,...)만큼 떨어져있음

자신의 길이 >= 과일의 높이  ==> 섭취 가능

초기 길이 L일때, 과일들을 먹어 늘릴 수 있는 최대 길이는?

(Line1)
N: 과일의 개수
L: 초기 길이

(Line2)
과일의 높이 h_i(i=0,1,2,...)

<Idea>
먼저, N과 L을 초기화
그 다음, N개의 과일 높이 초기화

먼저, 초기 길이보다 작거나 같은 수가 있는지 파악한다.
그 다음, 팩맨 처럼 작은 수부터 차근차근 먹어가며 성장시킨다.

 */
public class p_16435 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int l = sc.nextInt();
        int[] h = new int[n];

        for (int i = 0; i < n; ++i) {
            h[i]=sc.nextInt();
        }

        Arrays.sort(h); //오름차순
        int size=h.length;
        for(int i=0; i<size; ++i) {
            if(l < h[i]) break;
            ++l;
        }

        System.out.println(l);
    }
}