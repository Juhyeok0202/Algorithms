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

        for (int i = 0; i < data.length; ++i) {
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
