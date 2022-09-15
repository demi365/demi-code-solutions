package com.codeforcers.demi.annotation;

public @interface LeetCode {
    int value();

    Difficulty difficulty() default Difficulty.EASY;

}
