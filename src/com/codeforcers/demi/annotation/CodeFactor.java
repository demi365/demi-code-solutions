package com.codeforcers.demi.annotation;

import com.codeforcers.demi.enums.Complexity;
import com.codeforcers.demi.enums.ProblemType;

/**
 * Pointer to how the code is performing and how it behaves
 */
public @interface CodeFactor {

    Complexity space();

    Complexity time();

    ProblemType type();

}
