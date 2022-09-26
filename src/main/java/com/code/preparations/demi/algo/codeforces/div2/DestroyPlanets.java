package com.code.preparations.demi.algo.codeforces.div2;

import com.code.preparations.demi.annotation.CodeForces;
import com.code.preparations.demi.enums.CodeForce;
import com.code.preparations.demi.enums.CodeForceType;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

@CodeForces(div = CodeForce.DIV2, number = 823, problemType = CodeForceType.A)
public class DestroyPlanets {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        for (int i=0; i<tc; i++) {
            int n = sc.nextInt();
            int c = sc.nextInt();

            int[] arr = new int[n];
            for(int j=0; j<n; j++) {
                arr[j] = sc.nextInt();
            }

            solve(arr, c, n);
        }
    }

    private static void solve(int[] arr, int cost, int len) {
        Map<Integer, Integer> vales = new HashMap<>();
        for (int val : arr) {
            vales.put(val, vales.getOrDefault(val, 0)+1);
        }

        int totalCost = 0;
        for(Integer value : vales.values()) {
            totalCost += Math.min(value, cost);
        }
        System.out.println(totalCost);
    }

}
