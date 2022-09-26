package com.code.preparations.demi.algo.codeforces.div2;

import com.code.preparations.demi.annotation.CodeForces;
import com.code.preparations.demi.enums.CodeForce;
import com.code.preparations.demi.enums.CodeForceType;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@CodeForces(div = CodeForce.DIV2, number = 823, problemType = CodeForceType.C)
public class Notation {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        List<String> results = new ArrayList<>();
        for (int i=0; i<tc; i++) {
            String s = sc.next();
            results.add(solve(s));
        }
        results.forEach(System.out::println);
    }

    private static String solve(String input) {
        int[] rightMin = new int[input.length()];
        rightMin[input.length()-1] = input.charAt(input.length()-1) -'0';
        for (int i=input.length()-2; i>=0; i--) {
            rightMin[i] = Math.min(input.charAt(i)-'0', rightMin[i+1]);
        }

        int[] digits = new int[10];

        for (int i=0; i<input.length(); i++) {
            int digit = input.charAt(i) - '0';

            if(rightMin[i] == digit) {
                digits[digit]++;
            } else {
                digits[Math.min(digit+1, 9)]++;
            }
        }

        StringBuilder result = new StringBuilder();
        for (int i=0; i<10; i++) {
            if (digits[i] > 0) {
                while(digits[i] >0) {
                    result.append(i);
                    digits[i]--;
                }
            }
        }
        return result.toString();
    }

}
