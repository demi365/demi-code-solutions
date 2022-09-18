package com.code.preparations.demi.annotation;

import com.code.preparations.demi.enums.Difficulty;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface LeetCode {
    int value();

    Difficulty difficulty();

}
