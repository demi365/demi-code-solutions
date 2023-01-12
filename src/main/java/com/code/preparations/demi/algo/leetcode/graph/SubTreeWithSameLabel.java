package com.code.preparations.demi.algo.leetcode.graph;

import com.code.preparations.demi.annotation.CodeFactor;
import com.code.preparations.demi.annotation.LeetCode;
import com.code.preparations.demi.enums.Complexity;
import com.code.preparations.demi.enums.Difficulty;
import com.code.preparations.demi.enums.ProblemType;

import java.util.*;

/**
 * You are given a tree (i.e. a connected, undirected graph that has no cycles) consisting of n nodes numbered from 0 to n - 1
 * and exactly n - 1 edges. The root of the tree is the node 0, and each node of the tree has a label which is a
 * lower-case character given in the string labels (i.e. The node with the number i has the label labels[i]).
 *<p></p>
 * The edges array is given on the form edges[i] = [ai, bi], which means there is an edge between nodes ai and bi in the tree.
 *<p></p>
 * Return an array of size n where ans[i] is the number of nodes in the subtree of the ith node which have the same label as node i.
 *<p></p>
 * A subtree of a tree T is the tree consisting of a node in T and all of its descendant nodes.
 */
@LeetCode(value = 1519, difficulty = Difficulty.MEDIUM)
@CodeFactor(time = Complexity.ON, space = Complexity.ON, type = ProblemType.DFS)
public class SubTreeWithSameLabel {


    Map<Integer, Integer> sameLabel;

    public int[] countSubTrees(int n, int[][] edges, String labels) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            graph.computeIfAbsent(edge[0], k -> new ArrayList<>());
            graph.get(edge[0]).add(edge[1]);
            graph.computeIfAbsent(edge[1], k -> new ArrayList<>());
            graph.get(edge[1]).add(edge[0]);
        }
        sameLabel = new HashMap<>();
        this.group(0, graph, labels.toCharArray(), new HashMap<>(), new HashSet<>());
        final int[] data = new int[n];
        sameLabel.forEach((key, value) -> data[key] = value);
        return data;
    }

    public Map<Character, Integer> group(int node, Map<Integer, List<Integer>> graph,
                                       char[] labels, Map<Character, Integer> counter, Set<Integer> visited) {
        char currC = labels[node];
        visited.add(node);
        counter.put(currC, counter.getOrDefault(currC, 0)+1);
        Map<Character, Integer> rootData = new HashMap<>(counter);
        for(int child : graph.getOrDefault(node, Collections.emptyList())) {
            if(!visited.contains(child)) {
                Map<Character, Integer> childData = this.group(child, graph, labels, new HashMap<>(), visited);
                childData.forEach((key, value) -> rootData.put(key, rootData.getOrDefault(key, 0) + value));
            }
        }
        sameLabel.put(node, rootData.get(currC));
        return rootData;
    }

}
