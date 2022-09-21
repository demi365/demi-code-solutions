package com.code.preparations.demi;

import com.code.preparations.demi.annotation.LeetCode;
import lombok.extern.slf4j.Slf4j;
import org.reflections.Reflections;

import java.util.Set;

@Slf4j
public class Main {

    public static void main(String[] args) {
        Reflections reflections = new Reflections("com.code.preparations");
        Set<Class<?>> classes = reflections.getTypesAnnotatedWith(LeetCode.class);
        log.info("Scanned classes size {}", classes.size());
    }

}
