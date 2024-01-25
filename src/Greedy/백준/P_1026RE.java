package Greedy.백준;

import java.io.*;
import java.util.*;

public class P_1026RE {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        //내림차순 정렬을 하려면 int가 아닌 Integer로 선언
        Integer[] B = new Integer[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
            B[i] = Integer.parseInt(st2.nextToken());
        }
        //A 올림, B 내림
        Arrays.sort(A);
        Arrays.sort(B, Collections.reverseOrder());

        int sum = 0;

        for (int i = 0; i < N; i++) {
            sum += (A[i] * B[i]);
        }

        bw.write(sum + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
