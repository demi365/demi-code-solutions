package com.code.preparations.demi.algo.leetcode.math;

import com.code.preparations.demi.annotation.CodeFactor;
import com.code.preparations.demi.annotation.LeetCode;
import com.code.preparations.demi.enums.Complexity;
import com.code.preparations.demi.enums.Difficulty;
import com.code.preparations.demi.enums.ProblemType;

import java.util.HashMap;
import java.util.Map;

/**
 * You are given a 0-indexed integer array tasks, where tasks[i] represents the difficulty level of a task.
 * <p></p>
 * In each round, you can complete either 2 or 3 tasks of the same difficulty level.
 * <p></p>
 * Return the minimum rounds required to complete all the tasks, or -1 if it is not possible to complete all the tasks.
 */
@LeetCode(value = 2244, difficulty = Difficulty.MEDIUM)
@CodeFactor(time = Complexity.ON, space = Complexity.ON, type = ProblemType.Math)
public class CompleteTasks {

    public int minimumRounds(int[] tasks) {

        int count = 0;
        Map<Integer, Integer> taskFrequency = new HashMap<>();

        for(int task : tasks) {
            taskFrequency.put( task, taskFrequency.getOrDefault(task, 0)+1 );
        }
        for(Integer key : taskFrequency.keySet()) {
            int frequency = taskFrequency.get(key);
            if(frequency == 1) {
                return -1;
            } else {
                count += frequency/3;
                frequency = frequency%3;
                count += frequency/2;
                count += frequency%2;
            }
        }
        return count;
    }
}
