package com.code.preparations.demi.algo.leetcode.graph;

import com.code.preparations.demi.annotation.CodeFactor;
import com.code.preparations.demi.annotation.LeetCode;
import com.code.preparations.demi.enums.Complexity;
import com.code.preparations.demi.enums.Difficulty;
import com.code.preparations.demi.enums.ProblemType;

import java.util.*;

/**
 * Given an undirected tree consisting of n vertices numbered from 0 to n-1,
 * which has some apples in their vertices. You spend 1 second to walk over one edge of the tree.
 * <p></p>
 * Return the minimum time in seconds you have to spend to collect all apples in the tree, starting at vertex 0 and coming back to this vertex.
 *<p></p>
 * The edges of the undirected tree are given in the array edges, where edges[i] = [ai, bi] means that
 * exists an edge connecting the vertices ai and bi.
 * <p></p>
 * Additionally, there is a boolean array hasApple, where hasApple[i] = true means that vertex i has an apple; otherwise, it does not have any apple.
 */
@LeetCode(value = 1443, difficulty = Difficulty.MEDIUM)
@CodeFactor(time = Complexity.ON, space = Complexity.ON, type = ProblemType.DFS)
public class MinimumTimeForApple {

    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            graph.computeIfAbsent(edge[0], k -> new ArrayList<>());
            graph.get(edge[0]).add(edge[1]);
            graph.computeIfAbsent(edge[1], k -> new ArrayList<>());
            graph.get(edge[1]).add(edge[0]);
        }
        return this.collect(0, hasApple, graph, new HashSet<>());
    }

    public int collect(int root, List<Boolean> hasApple, Map<Integer, List<Integer>> graph, Set<Integer> visited) {
        int curr = 0;
        visited.add(root);
        for (int child : graph.getOrDefault(root, Collections.emptyList())) {
            if (!visited.contains(child))
                curr += collect(child, hasApple, graph, visited);
        }
        if (root != 0 && (curr != 0 || hasApple.get(root))) {
            curr += 2;
        }
        return curr;
    }

}
