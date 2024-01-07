package sorting;

/*
- 정렬이 거의 된 상태의 데이터에서는 Insertion Sorting이 더 효율적임.

[Quick Sorting]
'기준 데이터를 설정하고, 그 기준보다 큰 데이터와 작은 데이터의 위치를 바꾸면 어떨까?'
-Pivot : 큰 수와 작은 수를 교환할 때, 교환하기 위한 '기준'
-pivot 설정을 미리 명시해주어야함.
-pivot 설정하고 리스트를 분할하는 방법에 따라 여러 가지 퀵 정렬
-아래 소스 코드에서는 Hoare Partition 방식을 기준으로 퀵 정렬 구현
- O(NlogN)
- ⚠️Worst Case => O(N*N) : '이미 데이터가 정렬되어 있는 경우 -> Insertion Sorting을 사용하면 좋음'

[Hoare Partition]
1. 리스트에서 첫 번째 데이터를 pivot으로 설정
2. '왼쪽'부터 pivot보다 '큰'데이터 탐색 and '오른쪽'부터 pivot보다 '작은' 데이터 탐색
3. 큰 데이터와 작은 데이터를 swapping
4. 위 과정 반복
 */
public class QuickSort_ex {

    static int[] data = {5, 7, 9, 0, 3, 1, 6, 2, 4, 8};

    public static void swap(int a, int b){
        int temp = data[a];
        data[a] = data[b];
        data[b] = temp;
    }

    public static void quickSorting(int start, int end) {

        if(start >= end) return; // 분할된 리스트의 원소가 1개라면, 종료(정렬된 상태)

        int pivot = start;
        int left = start+1; //첫 번째 원소는 pivot이므로, start + 1
        int right = end;

        while (left <= right) {

            while (left <= end &&data[left] <= data[pivot]) { // 좌측 탐색
                //pivot보다 큰 값 나올때 까지 인덱스 증가
                left++;
            }

            while (right > start && data[right] >= data[pivot]) { // 우측 탐색
                //pivot보다 작은 값 나올 때 까지 인덱스 증가
                right--;
            }

            if (left>right) {
                // 엇갈렸다면, 작은 데이터와 피벗 값 swap
                swap(right,pivot);
            }else{
                // 엇갈리지 않았다면, 작은 데이터와 큰 데이터 값 swap
                swap(left, right);
            }
        }

        // Partition 이후 left와 right부분에서 각각 퀵정렬 재귀적 수행
        quickSorting(start,right-1);
        quickSorting(right+1, end);
    }
    public static void main(String[] args) {
        System.out.println("Before");
        show();

        quickSorting(0,data.length-1);

        System.out.println("After");
        show();
    }

    public static void show() {
        for (int i = 0; i < data.length; ++i) {
            System.out.print(data[i]+ " ");
        }
        System.out.println();
    }
}
