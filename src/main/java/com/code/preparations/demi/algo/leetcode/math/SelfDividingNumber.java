package com.code.preparations.demi.algo.leetcode.math;

import com.code.preparations.demi.annotation.CodeFactor;
import com.code.preparations.demi.annotation.LeetCode;
import com.code.preparations.demi.enums.Complexity;
import com.code.preparations.demi.enums.Difficulty;
import com.code.preparations.demi.enums.ProblemType;

import java.util.ArrayList;
import java.util.List;

/**
 * A self-dividing number is a number that is divisible by every digit it contains.
 *<p></p>
 * For example, 128 is a self-dividing number because 128 % 1 == 0, 128 % 2 == 0, and 128 % 8 == 0.
 * A self-dividing number is not allowed to contain the digit zero.
 *<p></p>
 * Given two integers left and right, return a list of all the self-dividing numbers in the range [left, right].
 */
@LeetCode(value = 728, difficulty = Difficulty.EASY)
@CodeFactor(time = Complexity.ON, space = Complexity.ON, type = ProblemType.Math)
public class SelfDividingNumber {

    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> selfDividing = new ArrayList<>();

        for(int i=left; i<=right; i++) {
            if(selfDividing(i)) {
                selfDividing.add(i);
            }
        }
        return selfDividing;
    }

    public boolean selfDividing(int num) {
        if(num == 0)
            return false;

        int original = num;
        while(num > 0) {
            int rem = num%10;
            if(rem ==0 || original%rem != 0)
                return false;
            num = num/10;
        }
        return true;
    }
}
