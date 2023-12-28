package Implementation;

import java.util.Scanner;

public class Prac2_ndb {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 현재 나이트의 위치 입력받기
        String inputData = sc.nextLine();
        int row = inputData.charAt(1) - '0';
        int column = inputData.charAt(0) - 'a' + 1;

        int[] dx ={2,2,-2,-2,1,1,-1,-1};
        int[] dy ={-1,1,-1,1,2,-1,2,-2};

        // 8가지 방향에 대하여 각 위치로 이동이 가능한지 확인
        int result=0;
        for (int i = 0; i < 8; ++i) {
            //이동하고자 하는 위치 확인
            int nextRow = row + dx[i];
            int nextColumn = column + dy[i];
            // 해당 위치로 이동이 가능하다면 카운트 증가
            if(nextRow >= 1 && nextRow <= 8 && nextColumn >=1 && nextColumn <= 8) result++;
        }
        System.out.println(result);
    }
}
