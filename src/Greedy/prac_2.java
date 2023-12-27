package Greedy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/*
<PLAN>
Given
- N: 입력 받을 배열의 크기
- M: 더하는 연산 횟수
- K: 중첩 인덱싱 최대 횟수

When
- 정수 타입의 무작위 배열이 주어짐(직접 N개의 배열 요소 입력)

then
- 주어진 무작위 배열의 요소의 덧셈 연산을 통해 가장 큰 수를 만든다.(단, 동일 인덱싱 최대 K번 그리고 총 M번 연산하여 만든다.)

Idea
먼저, Line1에서 N M K 순으로 정수 입력을 받을 수 있도록
그 다음, Line2에서 N사이즈의 배열 요소를 입력받을 수 있도록 (여기 까지 delimeter는 space로 한다.)

먼저, 결과 출력을 위한 변수를 지정한다.
그 다음, 무작위로 만들어진 배열을 내림차순으로 정렬한다.
그 다음, 0번째 요소를 k번 더하고
그 다음, 1번째 요소를 k번 더하고
위 과정을 반복한다. 사실상 0과 1번째 인덱스만이 필요한 것 같다는 생각이 든다.

 */
public class prac_2 {
    public static void main(String[] args) {
        long beforeTime = System.currentTimeMillis();
 /*
      나의 답안.
      93p에 나온 답안보다 더욱 가독성 좋은 코드라고 생각이 든다. 그 이유는 m에 대한 연산을따로 하지 않고, i%(k+1)==0 일때만 second value를 더하는 방식이므로 간결하다.
      문제 분석도 정확히 한 것 같다. 이 문제에서의 key point는 1)배열을 정렬하고 2)1st와 2nd 의 수만이 필요하다는 것을 분석하는 것이라고 판단된다. 또한, 오름차순 보다 내림차순이 더욱 직관적이다.
 */
//        //Given
//        int n, m, k;
//        List<Integer> arr = new ArrayList<>();
//        Scanner in = new Scanner(System.in);
//
//        /*Line 1*/
//        n = in.nextInt();
//        m = in.nextInt();
//        k = in.nextInt();
//
//        /*Line 2*/
//        for (int i = 0; i < n; ++i) {
//            arr.add(in.nextInt());
//        }
//
//        //Result Process
//        /*result variable*/
//        int result=0;
//
//        /*Sorting*/
//        arr.sort(Comparator.reverseOrder());
//
//        for (int i = 0; i < m; ++i) {
//            if(i%(k+1)==0) result+=arr.get(1); // k+1 th operation is not permitted
//            else result+=arr.get(0); // others are permitted
//        }
//        in.close();
//        System.out.println(result);

        /*
        교안 답안(1)
         */
//        int n,m,k;
//        List<Integer> data = new ArrayList<>();
//        Scanner in = new Scanner(System.in);
//
//        n = in.nextInt();
//        m = in.nextInt();
//        k = in.nextInt();
//
//        for (int i = 0; i < n; ++i) {
//            data.add(in.nextInt());
//        }
//
//        data.sort(Comparator.naturalOrder()); //오름차순 정렬
//        int first = data.get(n - 1);
//        int second = data.get(n - 2);
//
//        int result = 0;
//
//        while (true) {
//            for (int i=0; i< k; ++i) { // 가장 큰 수 K번 더하기
//                if(m==0) break; // m==0이면 반복문 탈출
//                result += first;
//                m-=1; // 더할 때 마다 1씩 빼기
//            }
//            if(m==0) break; // m==0이면 반복문 탈출
//            result += second;
//            m-=1;
//        }
//
//        System.out.println(result);


        /*
        교안 답안(2): 수학적 접근
        위 2개의 답안과 다르게 m값이 아무리 커져도 m에 대한 연산은 count에 값을 할당할 때 뿐이다.
        위 2개의 답안은 loop를 통해 m에 값에 크게 의존된다.

        따라서, m의 값이 100억 이상처럼 커진다면, 아래와 같은 수학적인 접근이 답안이 될 수 있음을 알고 있자.
        직관적인 접근도 좋은데 수학적인 공식을 만들어 접근하는 방향도 연습해두자!
         */
        int n,m,k;
        List<Integer> data = new ArrayList<>();
        Scanner in = new Scanner(System.in);

        n = in.nextInt();
        m = in.nextInt();
        k = in.nextInt();

        for (int i = 0; i < n; ++i) {
            data.add(in.nextInt());
        }
        data.sort(Comparator.reverseOrder());


        int count;
        count = (m/(k+1))*k + m%(k+1);

        int result=0;
        result += count * data.get(0);
        result += (m - count) * data.get(1);

        System.out.println(result);

        long afterTime = System.currentTimeMillis();
        System.out.println("Time_Diff(ms) : " + (afterTime-beforeTime));
    }
}
