package com.code.preparations.demi.algo.leetcode.math;

import com.code.preparations.demi.annotation.CodeFactor;
import com.code.preparations.demi.annotation.LeetCode;
import com.code.preparations.demi.enums.Complexity;
import com.code.preparations.demi.enums.Difficulty;
import com.code.preparations.demi.enums.ProblemType;

/**
 * Given the coordinates of two rectilinear rectangles in a 2D plane, return the total area covered by the two rectangles.
 *<p></p>
 * The first rectangle is defined by its bottom-left corner (ax1, ay1) and its top-right corner (ax2, ay2).
 *<p></p>
 * The second rectangle is defined by its bottom-left corner (bx1, by1) and its top-right corner (bx2, by2).
 */
@LeetCode(value = 223, difficulty = Difficulty.MEDIUM)
@CodeFactor(time = Complexity.O1, space = Complexity.O1, type = ProblemType.Math)
public class RectangleArea {

    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int awidth = Math.abs(ay1-ay2);
        int aheight = Math.abs(ax1-ax2);

        int bwidth = Math.abs(by1-by2);
        int bheight = Math.abs(bx1-bx2);

        int sum = awidth*aheight + bwidth*bheight;

        int left = Math.max(ax1, bx1);
        int right = Math.min(ax2, bx2);
        int bottom = Math.max(ay1, by1);
        int top = Math.min(ay2, by2);

        if(right > left && top > bottom) {
            sum -= (right-left)*(top-bottom);
        }

        return sum;
    }
}
