package sorting;

/*

[계수정렬]
- 특정 조건이 부합할 때만 사용할 수 있지만, 매우 빠름
- 데이터 값이 무한한 범위 -> 사용 불가 (가령, 실수형 데이터)
- 일반적으로 가장 큰 데이터와 작은 데이터 Gap이 1,000,000을 초과하지 않을 때 효과적

- 모든 범위를 담을 수 있는 크기의 리스트(배열)를 선언 해야함.
    => IF 1~1000   Then 1001크기의 리스트(배열) 선언 필요.


(시간 복잡도 O(N+K) : 최악의 경우에도 같은 시간 복잡도를 보장함)
N: 데이터 개수
K: 데이터 중 최댓값

😄계수 정렬에 비해서 동작은 느리지만, 처리할 수 있는 정수의 크기가 더 큰.
그리고 사실상 현존하는 정렬 알고리즘 중에서 계수 정렬 만큼이나 가장 빠른
기수 정렬(Radix Sort)가 있다.

[공간복잡도 문제점]
데이터가 0과 999,999. 단 2개만 존재한다고 가정하자.
이 때에도 계수 리스트(배열)의 크기는 1,000,000 크기가 되도록 선언해야함.
즉, 동일한 값을 가지는 데이터가 여러 개 등장할 때 적합.]-

 */
public class CountSort_ex {

    static int[] data = {7, 5, 9, 0, 3, 1, 6, 2, 9, 1, 4, 8, 0, 5, 2};
    static int[] count;
    public static void main(String[] args) {
        System.out.println("Before");
        showData();

        countSorting();

        System.out.println("After");
        showData();
    }

    public static void countSorting() {
        int listSize = data.length;
        count = new int[findMax()+1];

        for (int i = 0; i < data.length; ++i) { // N
            count[data[i]]++;
        }

        int index =0;
        for (int i = 0; i < count.length; ++i) {
            for (int j = 0; j < count[i]; ++j) {
                data[index++] = i;
            }
        }
    }

    public static int findMax() {
        int max = -1;

        for (int i = 0; i < data.length; ++i) {
            if(max < data[i]) max = data[i];
        }

        return max;
    }

    public static void showData() {
        for (int i = 0; i < data.length; ++i) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }
}
