package com.code.preparations.demi;

import com.code.preparations.demi.annotation.CodeFactor;
import com.code.preparations.demi.annotation.LeetCode;
import com.code.preparations.demi.enums.ProblemType;
import lombok.extern.slf4j.Slf4j;
import org.reflections.Reflections;

import java.lang.reflect.Method;
import java.util.*;
import java.util.stream.Collectors;

@Slf4j
public class Main {

    public static void main(String[] args) {
        Reflections reflections = new Reflections("com.code.preparations");
        Set<Class<?>> classes = reflections.getTypesAnnotatedWith(LeetCode.class);

        Set<Class<?>> classCodeFactors = reflections.getTypesAnnotatedWith(CodeFactor.class);
        Set<Method> methodCodeFactors = reflections.getMethodsAnnotatedWith(CodeFactor.class);

        List<CodeFactor> classCodeFactor = classCodeFactors.stream().map(clazz -> clazz.getAnnotation(CodeFactor.class)).collect(Collectors.toList());
        List<CodeFactor> methodCodeFactor = methodCodeFactors.stream().map(method -> method.getAnnotation(CodeFactor.class)).collect(Collectors.toList());
        List<CodeFactor> allCodeFactors = new ArrayList<>(classCodeFactor.size()+methodCodeFactor.size());
        allCodeFactors.addAll(classCodeFactor);
        allCodeFactors.addAll(methodCodeFactor);

        log.info("Total number of leetcode solutions available is {} and number of variations of solutions {}", classes.size(), allCodeFactors.size());

        Map<ProblemType, List<CodeFactor>> problemTypeListMap = allCodeFactors.stream()
                .collect(Collectors.groupingBy(CodeFactor::type));

        for(Map.Entry<ProblemType, List<CodeFactor>> value : problemTypeListMap.entrySet()) {
            log.info("Total number of solutions available in {} type is {}", value.getKey(), value.getValue().size());
        }

        log.info("Enter problem number to search : ");
        final Scanner sc = new Scanner(System.in);
        final int challengeNumber = sc.nextInt();

        final Optional<Class<?>> challengeSolvedOptional = classes.stream()
                .filter(challenge -> {
                    LeetCode leetCode = challenge.getAnnotation(LeetCode.class);
                    return challengeNumber == leetCode.value();
                })
                .findAny();

        challengeSolvedOptional.ifPresent(challenge -> {
            log.info("Challenge is already solved " + challenge.getCanonicalName());
        });
        if (challengeSolvedOptional.isEmpty()) {
            log.info("Challenge is not solved yet!");
        }

    }

}
