package com.code.preparations.demi.algo.leetcode.structure;


import com.code.preparations.demi.annotation.CodeFactor;
import com.code.preparations.demi.annotation.LeetCode;
import com.code.preparations.demi.enums.Complexity;
import com.code.preparations.demi.enums.Difficulty;
import com.code.preparations.demi.enums.ProblemType;

import java.util.*;

/**
 * Implement the RandomizedSet class:
 *<p></p>
 * RandomizedSet() Initializes the RandomizedSet object.
 * <p></p>
 * bool insert(int val) Inserts an item val into the set if not present. Returns true if the item was not present, false otherwise.
 * <p></p>
 * bool remove(int val) Removes an item val from the set if present. Returns true if the item was present, false otherwise.
 * <p></p>
 * int getRandom() Returns a random element from the current set of elements (it's guaranteed that at least one element exists when this method is called). Each element must have the same probability of being returned.
 * <p></p>
 * You must implement the functions of the class such that each function works in average O(1) time complexity.
 * <p></p>
 * Your RandomizedSet object will be instantiated and called as such:<p></p>
 * RandomizedSet obj = new RandomizedSet();<p></p>
 * boolean param_1 = obj.insert(val);<p></p>
 * boolean param_2 = obj.remove(val);<p></p>
 * int param_3 = obj.getRandom();<p></p>
 */
@LeetCode(value = 380, difficulty = Difficulty.MEDIUM)
@CodeFactor(time = Complexity.O1, space = Complexity.ON, type = ProblemType.DataStructure)
class RandomizedSet {

    Set<Integer> elements;
    List<Integer> duplicate;
    Random random;

    public RandomizedSet() {
        elements = new HashSet<>();
        duplicate = new ArrayList<>();
        random = new Random();
    }

    public boolean insert(int val) {
        if(this.elements.add(val)) {
            this.duplicate.add(val);
            return true;
        }
        return false;
    }

    public boolean remove(int val) {
        if(this.elements.contains(val)) {
            this.elements.remove(val);
            return true;
        }
        return false;
    }

    public int getRandom() {
        int index = random.nextInt(duplicate.size());
        Integer ans = duplicate.get(index);
        if(!this.elements.contains(ans))
            return getRandom();
        return ans;
    }

}
