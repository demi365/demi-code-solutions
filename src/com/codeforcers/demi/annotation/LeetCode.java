package com.codeforcers.demi.annotation;

import com.codeforcers.demi.enums.Difficulty;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface LeetCode {
    int value();

    Difficulty difficulty();

}
