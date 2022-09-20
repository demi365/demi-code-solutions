package com.code.preparations.demi;

import com.code.preparations.demi.algo.leetcode.RandomNumberGeneration;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        RandomNumberGeneration randomNumberGeneration = new RandomNumberGeneration();

        int count = 10000;
        int[] freq = new int[10];

        System.out.println("After traditional method");
        for(int i = 0; i< count; i++) {
            freq[randomNumberGeneration.rand10()]++;
        }

        for (int i=0; i<freq.length; i++) {
            System.out.println("Frequency of "+i + " is "+ freq[i]);
        }

    }

}
