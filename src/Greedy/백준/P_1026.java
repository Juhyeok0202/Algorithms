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

새로운 임시 배열 만들어서 하면 간단할 듯.
 */
public class P_1026 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Integer[] A = new Integer[n];
        Integer[] B = new Integer[n];

        for (int i = 0; i < n; ++i) {
            A[i] = sc.nextInt();
        }
        for (int i = 0; i < n; ++i) {
            B[i] = sc.nextInt();
        }

        Integer[] temp = new Integer[n];
        for (int i = 0; i < n; ++i) {
            temp[i]=B[i];
        }
        Arrays.sort(A);
        Arrays.sort(temp,Collections.reverseOrder());

        int result=0;
        for (int i = 0; i < n; ++i) {
            result += A[i]*temp[i];
        }
        System.out.println(result);

    }
}
