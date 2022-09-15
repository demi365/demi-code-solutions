package com.codeforcers.demi.util;

public class Helper {

    public static void print(int[] array) {
        for (int a: array) {
            System.out.print(a+" ");
        }
        System.out.println();
    }

    public static void print(int[][] array) {
        for (int[] a: array) {
            for(int b: a)
                System.out.print(b+" ");
            System.out.println();
        }
    }

    public static void print(char[][] array) {
        for (char[] a: array) {
            for(char b: a)
                System.out.print(b+" ");
            System.out.println();
        }
    }

}
