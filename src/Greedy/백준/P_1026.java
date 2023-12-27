package Greedy.백준;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/*


<Idea>
가장 큰 수 x 가장 작은 수
        0 1 1 1 6
        8 7 3 2 1
        0 7 3 2 6 = 18
        이런 느낌으로 가면 되는데, B배열 요소 재배치가 안된다.

어? 제출하고 보니까 B배열 요소 재배치해도 통과..
 */
public class P_1026 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Integer[] a = new Integer[n];
        Integer[] b = new Integer[n];

        for (int i = 0; i < n; ++i) {
            a[i]=sc.nextInt();
        }
        for (int i = 0; i < n; ++i) {
            b[i]=sc.nextInt();
        }

        Arrays.sort(a, Collections.reverseOrder()); //내림차순 정렬
        Arrays.sort(b); //오름차순 정렬

        int result =0;
        for (int i = 0; i < n; ++i) {
            result += a[i]*b[i];
        }

        System.out.println(result);
        sc.close();
    }

}
