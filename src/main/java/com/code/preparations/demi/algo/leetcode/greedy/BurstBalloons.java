package com.code.preparations.demi.algo.leetcode.greedy;

import com.code.preparations.demi.annotation.CodeFactor;
import com.code.preparations.demi.annotation.LeetCode;
import com.code.preparations.demi.enums.Complexity;
import com.code.preparations.demi.enums.Difficulty;
import com.code.preparations.demi.enums.ProblemType;

import java.util.PriorityQueue;
import java.util.Stack;

/**
 * There are some spherical balloons taped onto a flat wall that represents the XY-plane. The balloons are represented as a 2D integer array points where points[i] = [xstart, xend] denotes a balloon whose horizontal diameter stretches between xstart and xend. You do not know the exact y-coordinates of the balloons.
 *<p></p>
 * Arrows can be shot up directly vertically (in the positive y-direction) from different points along the x-axis. A balloon with xstart and xend is burst by an arrow shot at x if xstart <= x <= xend. There is no limit to the number of arrows that can be shot. A shot arrow keeps traveling up infinitely, bursting any balloons in its path.
 *<p></p>
 * Given the array points, return the minimum number of arrows that must be shot to burst all balloons.
 */
@LeetCode(value = 452, difficulty = Difficulty.MEDIUM)
@CodeFactor(time = Complexity.ONlogN, space = Complexity.ON, type = ProblemType.Greedy)
public class BurstBalloons {

    public int findMinArrowShots(int[][] points) {
        PriorityQueue<int[]> pointQueue = new PriorityQueue<>(
                (point1, point2) -> point1[0] == point2[0] ? point1[1]-point2[1] : point1[0]-point2[0]
        );

        for(int[] point : points) pointQueue.add(point);

        Stack<int[]> distinctPoint = new Stack<>();

        distinctPoint.push(pointQueue.poll());
        while(!pointQueue.isEmpty()) {
            int[] point = pointQueue.poll();
            int[] prev = distinctPoint.peek();
            int[] intersection = new int[] { Math.max(point[0], prev[0]), Math.min(point[1], prev[1]) };

            if( intersection[0] <= intersection[1] &&
                    intersection[0] >= prev[0] && intersection[1] <= prev[1] &&
                    intersection[0] >= point[0] && intersection[1] <= point[1]) {
                distinctPoint.pop();
                distinctPoint.push(intersection);
            } else {
                distinctPoint.push(point);
            }
        }

        return distinctPoint.size();
    }
}
