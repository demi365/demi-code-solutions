package com.code.preparations.demi.util;

public class Helper {

    public static void print(String context, int[] array) {
        System.out.print(context+" ".repeat(Math.max(0, 25-context.length())));
        print(array);
    }
    public static void print(int[] array) {
        for (int a: array) {
            System.out.print(a+" ");
        }
        System.out.println();
    }

    public static void print(int[][] array, int[] mat) {
        for (int[] a: array) {
            if(a == null) continue;
            for(int b: a)
                System.out.print(mat[b]+"["+b+"] ");
            System.out.println();
        }
    }

    public static void print(int[][] array) {
        for (int[] a: array) {
            if(a == null) continue;
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
