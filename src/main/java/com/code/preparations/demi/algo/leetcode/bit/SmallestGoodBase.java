package com.code.preparations.demi.algo.leetcode.bit;

import com.code.preparations.demi.annotation.CodeFactor;
import com.code.preparations.demi.annotation.LeetCode;
import com.code.preparations.demi.enums.Complexity;
import com.code.preparations.demi.enums.Difficulty;
import com.code.preparations.demi.enums.ProblemType;

import java.math.BigInteger;

/**
 * Given an integer n represented as a string, return the smallest good base of n.
 *<p></p>
 * We call k >= 2 a good base of n, if all digits of n base k are 1's.
 */
@LeetCode(value = 483, difficulty = Difficulty.MEDIUM)
public class SmallestGoodBase {

    /**
     * The most optimized solution which came up from the internet on leetcode.
     */
    @CodeFactor(time = Complexity.O1, space = Complexity.O1, type = ProblemType.BitManipulation)
    public String smallestGoodBase(String n) {
        long x = Long.parseLong(n);
        String maxBase = Long.toBinaryString(x);
        if(maxBase.indexOf('0') == -1) return "2";
        int bit = maxBase.length();
        while(bit >= 2) {
            // This is the most important logic, here we are taking the root to the power of base to get the number
            // which is most equivalent to the base we need. Back tracking the number, to get the most equivalent option
            int base = (int) Math.floor(Math.pow(x, 1.0/bit));
            long sum = 1; long prod = 1;
            for(int i=1; i<=bit; i++) {
                prod *= base;
                sum += prod;
            }

            if(sum == x)
                return String.valueOf(base);
            bit--;
        }
        return String.valueOf(x-1);
    }

    /**
     * Good base using binary search, which is a bit of a round about way, still acceptable and working.
     * It uses BigInteger to solve the overflow issues with long multiplication
     */
    @CodeFactor(space = Complexity.ON, time = Complexity.ONlogN, type = ProblemType.BitManipulation)
    public String smallestGoodBases(String n) {
        long x = Long.parseLong(n);
        String maxBase = Long.toBinaryString(x);
        BigInteger xBig = BigInteger.valueOf(x);
        // System.out.println(maxBase+" index of 0 is "+maxBase.indexOf('0'));
        if(maxBase.indexOf('0') == -1)
            return "2";
        int base = maxBase.length()-1;
        while(base >2) {
            long low = 3;
            long high = x-1;
            while(low <= high) {
                long mid = low + (high-low)/2;
                BigInteger baseVal = baseValue(mid, base);
                int compare = baseVal.compareTo(xBig);
                if(compare == 0) {
                    return String.valueOf(mid);
                } else if (compare < 0) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            base--;
        }
        // System.out.println("Default value is being returned");
        return String.valueOf(x-1);
    }

    public static BigInteger baseValue(Long n, int bit) {
        BigInteger val = BigInteger.ONE;
        BigInteger res = BigInteger.ONE;
        BigInteger nV = BigInteger.valueOf(n);
        for(int i=1; i<bit; i++) {
            val = val.multiply(nV);
            res = res.add(val);
        }
        return res;
    }

}
