package com.codeforcers.demi;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        int[] values = new int[]{1,12,123,3,12};
        int[] val = Arrays.copyOfRange(values, 1, values.length);
        for(int v: val) System.out.println(v);
    }

    private static void print(int[] array) {
        for (int a: array) {
            System.out.print(a+" ");
        }
        System.out.println();
    }

    private static void print(int[][] array) {
        for (int[] a: array) {
            for(int b: a)
                System.out.print(b+" ");
            System.out.println();
        }
    }

    private static void print(char[][] array) {
        for (char[] a: array) {
            for(char b: a)
                System.out.print(b+" ");
            System.out.println();
        }
    }

    private static void test(){

    }

    private static void testList(List<Integer> lists) {
        lists.stream().reduce(0, (a,b) -> a^b);
    }

    public static boolean solve(String s1, String s2) {
        System.out.println("String s1 : ["+s1.length()+"] String s2 : ["+s2.length()+"]");
        int[] s1CharArray = new int[26];
        for(char c : s1.toCharArray()) {
            s1CharArray[c-'a']+=1;
        }
        print(s1CharArray);
        int[] s2CharArray = new int[26];
        Map<Integer, Integer> charLastIndexPos = new HashMap<>(26);
        int count = 0, currItr = 0;
        for(int i=0; i<s2.length(); i++) {
            int cIndex = s2.charAt(i)-'a';
            if(s1CharArray[cIndex] > 0) {
                if(count ==0) {
                    currItr = i;
                }
                s2CharArray[cIndex]+=1;
                if(s2CharArray[cIndex] > s1CharArray[cIndex]) {
                    int index = charLastIndexPos.get(cIndex);
                    for(int temp = currItr; temp<index; temp++) {
                        s2CharArray[s2.charAt(temp)-'a']-=1;
                        count--;
                    }
                    charLastIndexPos.put(cIndex, s2.indexOf(s2.charAt(i), index+1));
                    currItr = index+1;
                } else {
                    charLastIndexPos.putIfAbsent(cIndex, i);
                    count++;
                    if(count == s1.length()) return true;
                }
            } else if(count >0) {
                charLastIndexPos.clear();
                count =0;
                s2CharArray = new int[26];
            }
        }
        return false;
    }

}
