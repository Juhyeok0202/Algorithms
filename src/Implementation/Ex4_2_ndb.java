package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex4_2_ndb {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int cnt=0;

        for (int i = 0; i <= n; ++i) {
            for (int j = 0; j < 60; ++j) {
                for (int k = 0; k < 60; ++k) {
                    if(checker(i,j,k)) cnt++;
                }
            }
        }

        System.out.println(cnt);
    }

    private static boolean checker(int h, int m, int s){
        /*
        t = X3 -> t%10 == 3
        t = 3X -> t/10 == 3
        ※Hour에서는 3X 경우가 존재하지 않음
         */
        if(h%10==3 || m/10==3 || m%10==3 || s/10==3 || s%10==3) return true;
        return false;
    }
}
