package com.codeforcers.demi.algo.leetcode;

import com.codeforcers.demi.annotation.CodeFactor;
import com.codeforcers.demi.enums.Difficulty;
import com.codeforcers.demi.annotation.LeetCode;
import com.codeforcers.demi.enums.Complexity;
import com.codeforcers.demi.enums.ProblemType;

import java.util.*;

@LeetCode(value = 2007, difficulty = Difficulty.MEDIUM)
@CodeFactor(space = Complexity.ON, time = Complexity.ON, type = ProblemType.HashTable)
public class DoubledArray {

    public int[] findOriginalArray(int[] changed) {
        if(changed.length%2==1) return new int[0];
        Map<Integer, Integer> hash = new HashMap<>();
        for(int x: changed) {
            hash.put(x, hash.getOrDefault(x, 0)+1);
        }
        int count = 0;
        int[] original = new int[changed.length/2];

        Set<Integer> hashSet = new TreeSet<>(hash.keySet());
        System.out.println(hash);
        for(Integer key : hashSet) {

            int appearances = hash.get(key);

            System.out.printf("Found value %d as %d\n", key, appearances);
            if(appearances > 0) {
                if(key == key*2) {
                    for(int i=0; i< appearances/2; i++)
                        original[count++] = key;
                    appearances=0;
                } else{
                    int doubleCount = Math.min(hash.getOrDefault(key*2, 0), appearances);
                    hash.put(key*2, hash.getOrDefault(key*2, 0)-doubleCount);
                    System.out.printf("Found doubles for %d are %d\n", key, doubleCount);
                    while (doubleCount>0) {
                        original[count++] = key;
                        doubleCount--;
                        appearances--;
                    }
                }
            } else if(appearances<0) {
                return new int[0];
            }
            if(appearances>0)
                return new int[0];
            hash.put(key, appearances);
        }

        return original;
    }

}
