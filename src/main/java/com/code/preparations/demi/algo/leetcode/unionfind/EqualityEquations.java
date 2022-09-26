package com.code.preparations.demi.algo.leetcode.unionfind;

import com.code.preparations.demi.annotation.CodeFactor;
import com.code.preparations.demi.annotation.LeetCode;
import com.code.preparations.demi.enums.Complexity;
import com.code.preparations.demi.enums.Difficulty;
import com.code.preparations.demi.enums.ProblemType;

import java.util.ArrayList;
import java.util.List;

/**
 * You are given an array of strings equations that represent relationships between variables where each string equations[i] is of
 * length 4 and takes one of two different forms: "xi==yi" or "xi!=yi".
 * <p></p>
 * Here, xi and yi are lowercase letters (not necessarily different) that represent one-letter variable names.
 *<p></p>
 * Return true if it is possible to assign integers to variable names to satisfy all the given equations, or false otherwise.
 */
@LeetCode(value = 990, difficulty = Difficulty.MEDIUM)
public class EqualityEquations {

    /**
     * We have to do a union find for this to search through what elements match to a specific parent.
     *
     * @param equations list of equations
     * @return if equations can be satisfied or not
     */
    @CodeFactor(time = Complexity.ON, space = Complexity.ON, type = ProblemType.UnionFind)
    public boolean equationsPossibleV1(String[] equations) {

        char[] groups = new char[128];

        for(char c = 'a'; c <= 'z'; c++) groups[c] = c;

        // parallely processing both equalities and in equalities is harder,
        // Better approach would be to store inequalities for analysing later.
        List<String> inequalities = new ArrayList<>();
        for(String equation : equations) {
            char x1 = equation.charAt(0);
            char x2 = equation.charAt(3);

            switch(equation.charAt(1)) {
                case '=':
                    char x1p = findParent(x1, groups);
                    char x2p = findParent(x2, groups);

                    // set parent of x2 as x1 parent, makes them share the same parent
                    groups[x2p] = x1p;
                    break;
                case '!':
                    // in equalities will be stored for analysis later
                    inequalities.add(equation);
                    break;
            }
        }

        for(String inEqual : inequalities) {

            char x1 = inEqual.charAt(0);
            char x2 = inEqual.charAt(3);
            char x1p = findParent(x1, groups);
            char x2p = findParent(x2, groups);
            // if parent of x1 and x2 is same within in equalities, we will return false, else true
            if(x1p == x2p)
                return false;
        }

        return true;
    }

    private char findParent(char c, char[] groups) {
        return groups[c] == c ? c : findParent(groups[c], groups);
    }

    /**
     * This is the same solution, but with O1 space, by swapping all the in equality operation at the end of the list.
     *
     * @param equations list of equations
     * @return if equations can be satisfied or not
     */
    @CodeFactor(time = Complexity.ON, space = Complexity.O1,type = ProblemType.UnionFind)
    public boolean equationsPossible(String[] equations) {

        char[] groups = new char[128];

        for(char c = 'a'; c <= 'z'; c++) groups[c] = c;

        sort(equations);
        for(String equation : equations) {
            char x1 = equation.charAt(0);
            char x2 = equation.charAt(3);
            char x1p = findParent(x1, groups);
            char x2p = findParent(x2, groups);

            switch(equation.charAt(1)) {
                case '=':
                    groups[x2p] = x1p;
                    break;
                case '!':
                    if(x1p == x2p)
                        return false;
                    break;
            }
        }

        return true;
    }

    public void sort(String[] equations) {
        int left = 0; int right = equations.length-1;
        while(left < right) {
            if(equations[left].charAt(1) == '=') {
                left++;
            } else if (equations[right].charAt(1) == '!') {
                right--;
            } else {
                String temp = equations[left];
                equations[left] = equations[right];
                equations[right] = temp;
                left++; right--;
            }
        }
    }

}
