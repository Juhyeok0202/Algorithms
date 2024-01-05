package Implementation.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
c읽은거 기억
나중에 또 c 나오면 그룹x 안나오면 그룹 o
 */
public class P_1316 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int count =0;

        for (int i = 0; i < n; ++i) {
            if (checkStr(br.readLine())) {
                count++;
            }
        }
        br.close();
        System.out.println(count);
    }

    static boolean checkStr(String str) {

        boolean[] checkAlpha = new boolean[26]; //알파벳 개수만큼 공간 생성
        int prev=-1;

        for (int i = 0; i < str.length(); ++i) {
            int now = str.charAt(i); //현재의 문자의 ASCII 코드값을 저장

            if(prev!=now){ //이전 문자와 i번째 문자가 같지 않다면 about ascii code
                if(checkAlpha[now-97] == false){ // 첫 등장한 문자의 경우
                    // false : 처음 나온 문자
                    // true : 첫 등장이 아닌 문자
                    checkAlpha[now-97] = true; // 1번 초과로 나왔으므로 true 할당
                    prev = now;
                }else { //아니라는 것은 이미 나온 적이 있는 경우 => 그룹 문자 X
                    return false;
                }
            }else{ //이전 문자와 i번째 문자가 같다면
                continue;
            }
        }

        return true;
    }
}
