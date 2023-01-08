package com.code.preparations.demi.algo.leetcode.math;

import com.code.preparations.demi.annotation.CodeFactor;
import com.code.preparations.demi.annotation.LeetCode;
import com.code.preparations.demi.enums.Complexity;
import com.code.preparations.demi.enums.Difficulty;
import com.code.preparations.demi.enums.ProblemType;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane,
 * return the maximum number of points that lie on the same straight line.
 */
@LeetCode(value = 149, difficulty = Difficulty.HARD)
@CodeFactor(time = Complexity.ON2, space = Complexity.ON, type = ProblemType.Math)
public class MaxPoints {

    public int maxPoints(int[][] points) {
        int n = points.length;

        if (n <= 2) {
            return n;
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n - 1; i++) {
            HashMap<Float, Set<String>> hm = new HashMap<>();
            for (int j = i + 1; j < n; j++) {
                float temp = getSlope(points[i][0], points[i][1], points[j][0], points[j][1]);
                if (hm.containsKey(temp)) {
                    Set<String> st = hm.get(temp);
                    st.add(points[i][0] + "," + points[i][1]);
                    st.add(points[j][0] + "," + points[j][1]);
                    hm.put(temp, st);
                } else {
                    Set<String> st = new HashSet<>();
                    st.add(points[i][0] + "," + points[i][1]);
                    st.add(points[j][0] + "," + points[j][1]);
                    hm.put(temp, st);
                }
                max = Math.max(max, hm.get(temp).size());
            }
        }
        return max;
    }

    public float getSlope(int x1, int y1, int x2, int y2) {
        float a = y2 - y1;
        float b = x2 - x1;
        if (b == 0.0) {
            return 0f;
        }
        if (a == 0.0) {
            return Integer.MAX_VALUE;
        }
        return (a / b);
    }
}
