package Implementation;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Scanner;

/*
<IDEA>
N : Hour num

하루는 60초*60*24 = 86,400 초로 모든 경우의 수는 86400가지 존재한다. 이 중에서 3이 포함되는 경우의 수를 출력해야한다.
또한, 이는 완전 탐색으로 접근하여도 1초에 2000만번 연산을 수행한다는 가정하에 1초 내에 수행 가능하다고 판단된다.

00시 00분 00초 ~ N시 59분 59초 중 3이 하나라도 포함되는 모든 경우의 수를 구하자.

그냥 완전 탐색하면 될듯.



 */
public class Ex4_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String result ="";
        int cnt=0;
        for (int i = 0; i <= n; ++i) {
            for (int j = 0; j < 60; ++j) {
                for (int k = 0; k < 60; ++k) {
                    result = String.valueOf(i) + String.valueOf(j) + String.valueOf(k);

                    if(result.contains("3")) cnt++;
                }
            }
        }

        System.out.println(cnt);
    }
}
