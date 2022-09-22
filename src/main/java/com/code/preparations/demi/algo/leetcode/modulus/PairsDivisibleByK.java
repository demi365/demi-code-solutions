package com.code.preparations.demi.algo.leetcode.modulus;

import com.code.preparations.demi.annotation.CodeFactor;
import com.code.preparations.demi.annotation.LeetCode;
import com.code.preparations.demi.enums.Complexity;
import com.code.preparations.demi.enums.Difficulty;
import com.code.preparations.demi.enums.ProblemType;

/**
 * Given an array of integers arr of even length n and an integer k.
 *<p></p>
 * We want to divide the array into exactly n / 2 pairs such that the sum of each pair is divisible by k.
 *<p></p>
 * Return true If you can find a way to do that or false otherwise.
 */
@LeetCode(value = 1497, difficulty = Difficulty.MEDIUM)
@CodeFactor(time = Complexity.ON, space = Complexity.ON, type = ProblemType.Modulus)
public class PairsDivisibleByK {

    /**
     * Given an array, pairs exists only if the number elements with complementing modulus are same.
     */
    public boolean canArrange(int[] arr, int k) {
        if(arr.length%2 == 1) return false;
        int[] modFreq = new int[k];
        for(int a : arr) {
            int x = a%k;
            // for negative numbers, let's say -1 mod 3 is -1, but the actual mod complement of this is 2 in positive terms.
            if(x<0) x = k+x;
            modFreq[x]++;
        }

        // for any number 0 and even middle number is its own modulus complement, hence it should have even number
        if(modFreq[0]%2 != 0) return false;
        if(k%2== 0 && modFreq[k/2]%2 != 0) return false;

        for(int i = 1; i< modFreq.length/2+k%2; i++) {
            // for each modulus frequency, the complementary modulus frequency should be equal
            if(modFreq[i] != modFreq[k-i]) {
                return false;
            }
        }


        return true;
    }

}
