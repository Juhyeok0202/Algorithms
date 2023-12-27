package Greedy;

import java.util.Scanner;

public class ex3_1 {
    public static void main(String[] args) {
        long beforeTime = System.currentTimeMillis();

//        /*
//            나의 초기 답안.(16ms)
//
//        */
//        Scanner in = new Scanner(System.in);
//        int N = 500000000; // 거슬러 주어야할 돈
//
//        int[] changes = {500,100,50,10};
//        int cnt = 0;
//        int i=0;
//
//        while(i<4){
//            if(N-changes[i]<0) ++i;
//            else{
//                N -= changes[i];
//                cnt++;
//            }
//        }
//        System.out.println(cnt);
//        System.out.println(N);


        /*
            모범답안이 훨씬 간결함.(14ms)(O(k), k is the type of coins)
            For-Each Statment를 사용하여 증감변수를 사용하지 않고 몫과 나머지 개념을 적절히 사용함.

        */
        Scanner in = new Scanner(System.in);
        int N = 500000000;
        int cnt=0;
        int[] coin_types = {500, 100, 50, 10};

        for (int coin : coin_types) {
            cnt += N/coin;
            N = N%coin;
        }

        System.out.println(cnt);
        System.out.println(N);

        long afterTime=System.currentTimeMillis();
        long secDiffTime = (afterTime-beforeTime);
        System.out.println("시간차이(ms): " + secDiffTime);
    }
}