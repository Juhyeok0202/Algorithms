package Greedy;

/*
<요구사항: 각 행에서 가장 작은 수를 선택하고, 각 행에서 선택된 수들 중 가장 큰 수를 출력하는 프로그램>
 N: #Row
 M: #Col

 숫자 카드가 N x M 형태로 놓임.

먼저, Line1에서 N,M을 입력 받는다. (단, delimeter는 space)
그 다음, NxM 행렬을 입력 받아 구성한다.(단, 입력 format이 행렬과 같이 입력되어야 함.)

먼저, (0번째 행부터 순차적으로) colnm을 조사하여 가장 작은 수를 기억해둔다.
그 다음, 그 중 가장 큰 수를 출력한다.(정렬? 굳이 해야할까 Max 라이브러리 사용하자.)

 */

import java.util.Scanner;

public class Prac_3 {
    public static void main(String[] args) {

        /*
            나의 답안
            : 행렬의 입력값은 2D 배열로 할당한다. 각 행마다의 최소 수를 찾는 방법은 List에 해당 행의 모든 column을 모두 할당한 뒤,
            오름 차순으로 정렬한다. 그 뒤, 각 행의 최소값을 담는 List인 result에 0번째 요소를 add해준다.

            위 과정을 행의 개수만큼 반복한다.

            최종적으로 만들어진 result의 List를 내림차순으로 정렬하여, 0번째 요소를 출력한다.

            일단, 2번의 정렬(list의 사이즈에 종속되는 연산량)이 이루어지고 nxm번의 연산이 이루어진다.
         */
//        /* Given Variables */
//        int n,m;
//        int[][] matrix;
//        Scanner in = new Scanner(System.in);
//        n = in.nextInt();
//        m = in.nextInt();
//        matrix = new int[n][m];
//
//        /* Construct NxM matrix */
//        for (int i = 0; i < n; ++i) {
//            for (int j = 0; j < m; ++j) {
//                matrix[i][j] = in.nextInt();
//            }
//        }
//
//        /* Find to minimum value in the ith row of matrix */
//        List<Integer> result = new ArrayList<>();
//        for (int i = 0; i < n; ++i) {
//            List<Integer> data = new ArrayList<>();
//            for (int j = 0; j < m; ++j) {
//                data.add(matrix[i][j]);
//                if(j%m==2){
//                    data.sort(Comparator.naturalOrder());
//                    result.add(data.get(0)); //min_value
//                }
//            }
//        }
//        result.sort(Comparator.reverseOrder());
//        in.close();
//        System.out.println(result.get(0));

        /*
        교안 답안(1)
        훨씬 코드가 간결해졌다. 컬렉션을 활용하는 것도 좋지만, Math 라이브러리도
        활용할 수 있으면 하는 쪽이 가독성에 좋은듯.

        또, 입력을 하면서 비교 연산을 수행하니 가독성이 눈에 띄게 좋아진건..기분탓? 문제를
        모르고 봤을 때는 각 행위를 나누어 하는 것이 보기에는 좋은 것 같음.

        하지만, 🌟이중 loop를 한 번만 사용하는 점에서 연산이 훨씬 효율적임.
         */
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int result = 0;

        for (int i = 0; i < n; ++i) {
            int min_value=10001; // 각 수자가 1~10,000이므로 10,001까지
            for (int j = 0; j < m; ++j) {
                /*입력을 받으면서 비교연산을 수행하네*/
                int x = sc.nextInt();
                min_value = Math.min(min_value, x);
            }
            result = Math.min(result, min_value);
        }
        System.out.println(result);
    }
}
