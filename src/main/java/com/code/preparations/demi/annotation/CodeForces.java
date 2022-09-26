package com.code.preparations.demi.annotation;

import com.code.preparations.demi.enums.CodeForce;
import com.code.preparations.demi.enums.CodeForceType;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface CodeForces {

    CodeForce div();

    int number();

    CodeForceType problemType();

}
