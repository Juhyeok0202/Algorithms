package Greedy.백준;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

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

        List<Integer> h = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            h.add(sc.nextInt());
        }
        h.sort(Comparator.naturalOrder()); // 오름차순 정렬(아직까진 정렬은 필수라고 생각됨)
        int index=0;
        while(index < h.size()){
            if(h.get(index++)<=l){ // 작거나 같은 수가 있는가?
                l++;
            }else{
                break;
            }
        }
        sc.close();
        System.out.println(l);
    }
}