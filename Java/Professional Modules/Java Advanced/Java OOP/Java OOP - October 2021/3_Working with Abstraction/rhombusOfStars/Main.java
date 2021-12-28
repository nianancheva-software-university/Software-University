package rhombusOfStars;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        printRhombus(n);

//        for (int i = 0; i < n; i++) {
//            for (int j = n - i - 1; j > 0; j--) {
//                System.out.print(" ");
//            }
//            for (int j = 0; j <= i; j++) {
//                System.out.print("* ");
//            }
//            System.out.println();
//        }
//
//        for (int i = 0; i < n - 1; i++) {
//            for (int j = 0; j <= i; j++) {
//                System.out.print(" ");
//            }
//            for (int j = n - i - 1; j > 0; j--) {
//                System.out.print("* ");
//            }
//            System.out.println();
//        }


    }

    static void printRhombus(int n) {
        printTop(n);
        printMiddle(n);
        printBottom(n);
    }

    static void printTop(int n) {
        for (int i = 0; i < n - 1; i++) {
            for (int j = n - i - 1; j > 0; j--) {
                System.out.print(" ");
            }
            for (int j = 0; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void printMiddle(int n) {
        for (int i = 0; i < n; i++) {
            System.out.print("* ");
        }
        System.out.println();
    }

    static void printBottom(int n) {
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(" ");
            }
            for (int j = n - i - 1; j > 0; j--) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
