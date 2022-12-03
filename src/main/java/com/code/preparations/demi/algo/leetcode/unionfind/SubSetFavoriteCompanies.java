package com.code.preparations.demi.algo.leetcode.unionfind;

import com.code.preparations.demi.annotation.CodeFactor;
import com.code.preparations.demi.annotation.LeetCode;
import com.code.preparations.demi.enums.Complexity;
import com.code.preparations.demi.enums.Difficulty;
import com.code.preparations.demi.enums.ProblemType;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given the array favoriteCompanies where favoriteCompanies[i] is the list of favorites companies for the ith person (indexed from 0).
 *<p></p>
 * Return the indices of people whose list of favorite companies is not a subset of any other list of favorites companies. You must return the indices in increasing order.
 */
@LeetCode(value = 1452, difficulty = Difficulty.MEDIUM)
@CodeFactor(space = Complexity.ON, time = Complexity.ON2, type = ProblemType.UnionFind)
public class SubSetFavoriteCompanies {

    public List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
        List<Set<String>> companies = new ArrayList<>();
        for(List<String> company : favoriteCompanies)
            companies.add(new HashSet<>(company));

        List<Integer> uniques = new ArrayList<>();
        Set<Integer> duplicates = new HashSet<>();

        for(int i = 0; i < companies.size(); i++) {
            Set<String> favorite = companies.get(i);
            boolean unique = true;
            for(int j=0; j<companies.size(); j++) {
                if(i != j && !duplicates.contains(j)) {
                    // System.out.println("Comparing "+favorite+" with "+companies.get(j));
                    if(companies.get(j).containsAll(favorite)) {
                        // System.out.println("Company "+favorite+" is a sub-set of "+companies.get(j));
                        unique = false;
                        break;
                    }
                }
            }
            if(unique)
                uniques.add(i);
            else
                duplicates.add(i);
        }

        return uniques;
    }

}
