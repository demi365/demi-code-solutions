package com.code.preparations.demi.algo.dev;

import com.code.preparations.demi.annotation.CodeFactor;
import com.code.preparations.demi.annotation.LeetCode;
import com.code.preparations.demi.enums.Complexity;
import com.code.preparations.demi.enums.Difficulty;
import com.code.preparations.demi.enums.ProblemType;

/**
 * Find if n is a happy number or not
 * A happy number is a number defined by the following process:
 * <p>
 * <p>
 *     Starting with any positive integer, replace the number by the sum of the squares of its digits.
 * </p>
 * <p>
 *     Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
 * </p>
 * <p>
 *     Those numbers for which this process ends in 1 are happy.
 * </p>
 *
 * Return true if n is a happy number, and false if not.
 *
 */
@LeetCode(value = 202, difficulty = Difficulty.EASY)
@CodeFactor(space = Complexity.O1, time = Complexity.ON, type = ProblemType.Special)
public class HappyNumber {

    /**
     * The logic is when we encounter, 2 or 3 or 4 then the sum will never match to 1.
     * <p>
     *     So if we saw any number between 2 to 4, we return false. And there is no cycle possible without going through
     *     2 or 3 or 4. So passing the visited values to the array won't add much.
     * </p>
     *
     * @param n the number n, which can be a candidate for happy number
     * @return true if the number is a happy number
     */
    public static boolean isHappy(int n) {
        if(n == 1) return true;
        if(n > 1 && n <=4) return false;
        int sum = 0;
        while(n >0) {
            int r = n%10;
            sum += r*r;
            n = n/10;
        }
        return isHappy(sum);
    }

}
