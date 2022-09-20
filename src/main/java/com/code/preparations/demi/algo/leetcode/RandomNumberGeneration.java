package com.code.preparations.demi.algo.leetcode;

import com.code.preparations.demi.annotation.CodeFactor;
import com.code.preparations.demi.annotation.LeetCode;
import com.code.preparations.demi.enums.Complexity;
import com.code.preparations.demi.enums.Difficulty;
import com.code.preparations.demi.enums.ProblemType;

import java.util.Random;

@LeetCode(value = 470, difficulty = Difficulty.MEDIUM)
@CodeFactor(type = ProblemType.Special, time = Complexity.O1, space = Complexity.O1)
public class RandomNumberGeneration {

    Random random = new Random();

    public int rand10() {
        int rand1 = rand7();
        int rand2 = rand7();
        int rand10 = (rand1-1)*7+rand2;
        if(rand10 > 40)
            return rand10();
        return rand10%10 + 1;
    }


    private int rand7() {
        return random.nextInt(7)+1;
    }

}
