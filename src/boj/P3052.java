package boj;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class P3052 {

    static final int DEVIDE_NUM = 42;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Set set = new HashSet();

        for (int i = 0; i < 10; ++i) {
            set.add(sc.nextInt()%DEVIDE_NUM);
        }

        System.out.println(set.size());
    }
}