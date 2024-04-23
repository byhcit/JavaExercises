package site;

import java.util.Arrays;
import java.util.Scanner;

public class HelloWorld {

    private static Scanner scanner;

    public static void main(String[] args) {
//        System.out.println("Hellow LH");
//        float ff1 = 123123123f;
//        float ff2 = ff1 + 1;
//        System.out.println(ff1);
//        System.out.println(ff2);
//        System.out.println(ff1 == ff2);
        Scanner scan = new Scanner(System.in);
        System.out.println("scan = " + scan);
        System.out.println("args = " + Arrays.deepToString(args));
        System.out.println(scan);
        System.out.printf("scan", scan);
        System.out.println("scan = " + scan);
        if (scan == null) {
            System.out.println("Hellow LH");
        }
        if (scan != null) {

        }
        int m = 10,n = 20;
        System.out.println("m = " + m);
    }

}