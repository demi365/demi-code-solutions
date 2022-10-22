package com.code.preparations.demi.algo.leetcode;

import com.code.preparations.demi.annotation.CodeFactor;
import com.code.preparations.demi.annotation.LeetCode;
import com.code.preparations.demi.enums.Complexity;
import com.code.preparations.demi.enums.Difficulty;
import com.code.preparations.demi.enums.ProblemType;

/**
 * The count-and-say sequence is a sequence of digit strings defined by the recursive formula:
 *<p></p>
 * countAndSay(1) = "1"
 * countAndSay(n) is the way you would "say" the digit string from countAndSay(n-1),
 * which is then converted into a different digit string.
 */
@CodeFactor(time = Complexity.ON, space = Complexity.ON, type = ProblemType.Recursion)
@LeetCode(value = 38, difficulty = Difficulty.MEDIUM)
public class CountAndSay {

    /**
     * This should be mostly coming from a recursion, but this is quite difficult to judge.
     */
    public String countAndSay(int n) {
        String x = "1";
        while (n > 1) {
            StringBuilder y = new StringBuilder();
            int count = 1;
            for(int i = 1; i< x.length(); i++) {
                if(x.charAt(i) != x.charAt(i-1)) {
                    y.append(count);
                    y.append(x.charAt(i-1));
                    count = 1;
                } else {
                    count++;
                }
            }
            y.append(count);
            y.append(x.charAt(x.length()-1));
            x = y.toString();
            n--;
        }
        return x;
    }

}
