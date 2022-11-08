package com.code.preparations.demi.algo.leetcode;

import com.code.preparations.demi.annotation.CodeFactor;
import com.code.preparations.demi.annotation.LeetCode;
import com.code.preparations.demi.enums.Complexity;
import com.code.preparations.demi.enums.Difficulty;
import com.code.preparations.demi.enums.ProblemType;

import java.util.Stack;

/**
 * Given a string s of lower and upper case English letters.
 *<p></p>
 * A good string is a string which doesn't have two adjacent characters s[i] and s[i + 1] where:
 *<p></p>
 * 0 <= i <= s.length - 2
 * <p></p>
 * s[i] is a lower-case letter and s[i + 1] is the same letter but in upper-case or vice-versa.
 * <p></p>
 * To make the string good, you can choose two adjacent characters that make the string bad and remove them.
 * You can keep doing this until the string becomes good.
 *<p></p>
 * Return the string after making it good. The answer is guaranteed to be unique under the given constraints.
 *<p></p>
 * Notice that an empty string is also good.
 */
@LeetCode(value = 1544, difficulty = Difficulty.EASY)
@CodeFactor(time = Complexity.ON, space = Complexity.ON, type = ProblemType.DataStructure)
public class GreatString {

    private static final int diff = Math.abs('a'-'A');

    /**
     * We keep tracking of what is added to a stack, and keep on removing anything which is duplicate and then finally end up
     * with values which are only unique.
     */
    public String makeGood(String s) {
        Stack<Character> stack = new Stack<>();
        stack.push(s.charAt(0));
        int left = 1;
        while (left<s.length()) {
            if(stack.isEmpty()) {
                stack.push(s.charAt(left));
            } else {
                if(Math.abs(s.charAt(left)-stack.peek()) == diff) {
                    stack.pop();
                } else {
                    stack.push(s.charAt(left));
                }
            }
            left++;
        }
        StringBuilder good = new StringBuilder();
        while(!stack.isEmpty()) {
            good.append(stack.pop());
        }
        return good.reverse().toString();
    }

}
