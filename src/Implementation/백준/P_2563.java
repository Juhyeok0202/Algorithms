//package Implementation.백준;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.Scanner;
//import java.util.StringTokenizer;
//
///*
/* [⚠️틀린 이유]
 테스트 케이스에 나온 케이스에만 유효한 코드임.
 모든 종이의 일부가 겹치는 경우는 해결하지 못함. 즉, 2개의 종이가 겹칠 때만 유효한 코드임
// */
//public class P_2563 {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int num = sc.nextInt();
//        int totArea = num * 100;
//        /**
//         * 첫번째 자연수: 왼쪽 아랫 모서리 x좌표
//         * 두번째 자연수: 왼쪽 아랫 모서리 y좌표
//         */
//        Rectangle[] rectangles = new Rectangle[num];
//        for (int i = 0; i < num; ++i) {
//            Rectangle newRectangle = new Rectangle(sc.nextInt(), sc.nextInt());
//            rectangles[i] = newRectangle;
//        }
//
//        for (int i = 0; i < num-1; ++i) {
//            Rectangle base = rectangles[i];
//            for (int j = i+1; j < num; ++j) {
//                if(i==j) continue;
//                Rectangle target = rectangles[j];
//                int overlapArea = overlapArea(base, target);
//                if (overlapArea > 0) {
//                    totArea -= overlapArea;
//                }
//            }
//        }
//
//        System.out.println(totArea);
//    }
//
//    public static int overlapArea(Rectangle base, Rectangle target) {
//
//        int overlapArea = 0;
//        int gapX = Math.abs(base.getX() - target.getX());
//        int gapY = Math.abs(base.getY() - target.getY());
//        /**
//         * true: 겹침
//         * false: 안겹침
//         */
//        boolean isOverlap_X = gapX < 10;
//        boolean isOverlap_Y = gapY < 10;
//
//        if (isOverlap_X && isOverlap_Y) {
//            overlapArea = (10 - gapX) * (10 - gapY);
//        }
//
//        return overlapArea;
//    }
//
//    static class Rectangle{
//        private int x;
//        private int y;
//
//        private int area;
//
//        public Rectangle(int x, int y) {
//            this.x=x;
//            this.y=y;
//        }
//
//        public void setX(int x) {
//            this.x=x;
//        }
//
//        public void setY(int y) {
//            this.y = y;
//        }
//
//        public int getX() {
//            return x;
//        }
//
//        public int getY() {
//            return y;
//        }
//    }
//
//
//}
