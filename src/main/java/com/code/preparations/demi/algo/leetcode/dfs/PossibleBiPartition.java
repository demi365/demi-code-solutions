package com.code.preparations.demi.algo.leetcode.dfs;

import com.code.preparations.demi.annotation.CodeFactor;
import com.code.preparations.demi.annotation.LeetCode;
import com.code.preparations.demi.enums.Complexity;
import com.code.preparations.demi.enums.Difficulty;
import com.code.preparations.demi.enums.ProblemType;

/**
 * We want to split a group of n people (labeled from 1 to n) into two groups of any size.
 * <p></p>
 * Each person may dislike some other people, and they should not go into the same group.
 *<p></p>
 * Given the integer n and the array dislikes where dislikes[i] = [ai, bi] indicates that the person
 * <p></p>
 * labeled a[i] does not like the person labeled b[i], return true if it is possible to split everyone into two groups in this way.
 */
@LeetCode(value = 886, difficulty = Difficulty.MEDIUM)
@CodeFactor(time = Complexity.ON, space = Complexity.ON, type = ProblemType.Tree)
public class PossibleBiPartition {

    public boolean possibleBiPartition(int N, int[][] dislikes) {
        int[][] graph = new int[N][N];
        for (int[] d : dislikes) {
            graph[d[0] - 1][d[1] - 1] = 1;
            graph[d[1] - 1][d[0] - 1] = 1;
        }
        int[] group = new int[N];
        for (int i = 0; i < N; i++) {
            if (group[i] == 0 && !dfs(graph, group, i, 1)) {
                return false;
            }
        }
        return true;
    }
    private boolean dfs(int[][] graph, int[] group, int index, int g) {
        group[index] = g;
        for (int i = 0; i < graph.length; i++) {
            if (graph[index][i] == 1) {
                if (group[i] == g) {
                    return false;
                }
                if (group[i] == 0 && !dfs(graph, group, i, -g)) {
                    return false;
                }
            }
        }
        return true;
    }

}
