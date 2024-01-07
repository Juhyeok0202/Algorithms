package sorting;

/*
- 선택정렬(Selection sorting)은 알고리즘 문제 풀이에 사용하기에는 느린 편!!
- 새로운 아이디어 필요 => 삽입 정렬

[삽입 정렬]
'데이터를 하나씩 확인하며, 각 데이터를 적절한 위치에 삽입하면 어떨까?'
- 필요할 때만 위치를 바꾸므로 '데이터가 거의 정렬되어 있을 때' 훨씬 효율적이다.
- 앞전 데이터는 이미 정렬이 되어 있다고 가정한다.
 */
public class InsertionSort_ex {
    static int[] data = {7,5,9,0,3,1,6,2,4,8};

    public static void swap(int a, int b) {
        int temp = data[a];
        data[a] = data[b];
        data[b] = temp;
    }
    public static void main(String[] args) {
        //먼저 첫번째 data는 정렬이 되어 있다고 가정하고 두 번째 data부터 시작한다.
        for (int i = 1; i < data.length; ++i) {
            int targetIndex;
            for (int j = i; j > 0; --j) {
                // i부터 1까지 1씩 감소하며 반복
                // j : 현재 삽입하고자 하는 원소의 index
                if(data[j] < data[j-1]) swap(j,j-1);
                else break;
            }
        }

        showData();
    }

    public static void showData(){
        for (int i = 0; i < data.length; ++i) {
            System.out.print(data[i] + " ");
        }
    }
}
