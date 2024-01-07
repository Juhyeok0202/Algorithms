package sorting;

/*
[선택 정렬]
가장 작은 데이터를 선택해 맨 앞에 있는 데이터와 바꾸고, 그 다음 작은 데이터를 선택해 앞에서
두 번째 데이터와 바꾸는 과정을 반복하는 것은 어떨까?

선택 정렬은 N-1번 만큼 가장 작은 수를 찾아서 맨 앞으로 보내야 한다. 또한 매번 가장 작은 수를 찾기 우해서 비교 연산이 필요하다.
구현 방식에 따라서 사소한 오차는 있을 수 있지만 아래와 같이 구현했을 경우
연산 횟수 : N + (N-1) + (N-2) + ... + 2 로 볼 수 있다. 따라서 근사치로 N X ( N+1) / 2번의 연산
이는 (N^2+N)/2로 표현가능 하다. 따라서, 간단히 O(NxN)이라고 표현 가능 하다.
 */
public class SelectionSort_ex {
    /*Selection Sorting example*/
    public static void main(String[] args) {
        int[] arr = {7, 5, 9, 0, 3, 1, 6, 2, 4, 8};
        selectionSorting(arr);
        show(arr);

    }

    public static void selectionSorting(int[] arr) {
        for (int i = 0; i < arr.length; ++i) {
            int min_index = i;
            for (int j = i + 1; j < arr.length; ++j) {
                if (arr[min_index] > arr[j]) min_index = j;
            }
            int temp = arr[min_index];
            arr[min_index] = arr[i];
            arr[i] = temp;
        }
    }

    public static void show(int[] arr) {
        for (int i = 0; i < arr.length; ++i) {
            System.out.print(arr[i] + " ");
        }
    }
}
