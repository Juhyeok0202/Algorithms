package Greedy;

import java.util.Scanner;

public class Prac_4 {
    static int  result =0;

    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int k = sc.nextInt();
//
//        while(n>1){
//            if(n%k==0) n = divideByK(n, k);
//            else n = minusOne(n);
//        }
//
//        System.out.println(result);


        /*
        교안 답안:
         */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int result=0;

        while (true) {
            // N이 K로 나누어 떨어지는 수가 될 때까지만 1씩 빼기
            int target = (n/k)*k;
            result += (n-target);
            n=target;
            // N이 K보다 작을 때 (더 이상 나눌 수 없을 때) 반복문 탈출
            if(n<k) break;
            // K로 나누기
            result +=1;
            n /= k;
        }

        // 마지막으로 남은 수에 대하여 1씩 빼기
        result += (n-1);
        System.out.println(result);
    }

//    public static int minusOne(int n){
//        result++;
//        return n-1;
//    }
//
//    public static int divideByK(int n, int k){
//        result++;
//        return n/k;
//    }
}
