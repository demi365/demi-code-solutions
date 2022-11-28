package com.code.preparations.demi.algo.leetcode.hashing;

import com.code.preparations.demi.annotation.CodeFactor;
import com.code.preparations.demi.annotation.LeetCode;
import com.code.preparations.demi.enums.Complexity;
import com.code.preparations.demi.enums.Difficulty;
import com.code.preparations.demi.enums.ProblemType;

import java.util.*;

/**
 * You are given an integer array matches where matches[i] = [winneri, loseri] indicates that the player winneri defeated player loseri in a match.
 *<p></p>
 * Return a list answer of size 2 where:
 *<p></p>
 * answer[0] is a list of all players that have not lost any matches.
 * <p></p>
 * answer[1] is a list of all players that have lost exactly one match.
 * <p></p>
 * The values in the two lists should be returned in increasing order.
 *<p></p>
 * Note:
 *<p></p>
 * You should only consider the players that have played at least one match.
 * <p></p>
 * The testcases will be generated such that no two matches will have the same outcome.
 */
@LeetCode(value = 2225, difficulty = Difficulty.MEDIUM)
@CodeFactor(space = Complexity.ON, time = Complexity.ONlogN, type = ProblemType.HashTable)
public class ZerosAndOnes {

    /**
     * Returns the list of ones and zero loss members.
     */
    public List<List<Integer>> findWinners(int[][] matches) {
        Map<Integer,Integer> outcomes = new HashMap<>();
        for (int[] match : matches) {
            outcomes.put(match[0], outcomes.getOrDefault(match[0], 0));
            outcomes.put(match[1], outcomes.getOrDefault(match[1], 0) + 1);
        }

        List<Integer> zeros = new ArrayList<>();
        List<Integer> ones = new ArrayList<>();
        for(int val : outcomes.keySet()) {
            if(outcomes.get(val) == 0) {
                zeros.add(val);
            } else if (outcomes.get(val) == 1) {
                ones.add(val);
            }
        }

        Collections.sort(zeros);
        Collections.sort(ones);
        return Arrays.asList(zeros, ones);
    }

}
