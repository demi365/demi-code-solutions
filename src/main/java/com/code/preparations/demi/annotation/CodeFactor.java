package com.code.preparations.demi.annotation;

import com.code.preparations.demi.enums.Complexity;
import com.code.preparations.demi.enums.ProblemType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Pointer to how the code is performing and how it behaves
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface CodeFactor {

    Complexity space();

    Complexity time();

    ProblemType type();

}
