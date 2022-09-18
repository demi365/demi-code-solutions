package com.codeforcers.demi.algo.leetcode;

import com.codeforcers.demi.annotation.CodeFactor;
import com.codeforcers.demi.annotation.LeetCode;
import com.codeforcers.demi.enums.Complexity;
import com.codeforcers.demi.enums.Difficulty;
import com.codeforcers.demi.enums.ProblemType;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Given an array of intervals where intervals[i] = [start[i], end[i]], merge all overlapping intervals,
 * Return an array of the non-overlapping intervals that cover all the intervals in the input.
 */
@LeetCode(value = 56, difficulty = Difficulty.MEDIUM)
@CodeFactor(time = Complexity.ONlogN, space = Complexity.ON, type = ProblemType.Sorting)
public class MergeIntervals {

    /**
     * This is a pretty straight forward solution, we just sort and see if next value's start is less than the current
     * end and then merge them.
     *
     * @param intervals input intervals
     * @return merged intervals
     */
    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        Queue<int[]> overlaps = new LinkedList<>();
        for(int i=0; i<intervals.length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            while (i<intervals.length-1
                    && end >= intervals[i+1][0]) {
                i++;
                start = Math.min(intervals[i][0], start);
                end = Math.max(intervals[i][1], end);
            }
            overlaps.add(new int[]{start, end});
        }

        int[][] result = new int[overlaps.size()][2];
        int idx =0;
        while(!overlaps.isEmpty()) {
            result[idx++] = overlaps.poll();
        }

        return result;

    }

}
