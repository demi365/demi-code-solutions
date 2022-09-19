package com.code.preparations.demi.algo.leetcode.math;

import com.code.preparations.demi.annotation.CodeFactor;
import com.code.preparations.demi.annotation.LeetCode;
import com.code.preparations.demi.enums.Complexity;
import com.code.preparations.demi.enums.Difficulty;
import com.code.preparations.demi.enums.ProblemType;

/**
 * Given a date, return the corresponding day of the week for that date.
 * <p></p>
 * The input is given as three integers representing the day, month and year respectively.
 * <p></p>
 * Return the answer as one of the following values {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"}
 */
@LeetCode(value = 1185, difficulty = Difficulty.EASY)
@CodeFactor(time = Complexity.O1, space = Complexity.O1, type = ProblemType.Math)
public class DayOfTheWeek {

    /**
     * Notice this set of days start from 'Saturday' for a weird reason
     */
    private static final String[] dayOfWeek = {"Saturday", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};

    /**
     * This is based on Zeller's congruence
     * <p>
     *     The logic is based on the formula below
     *     {@code h = (q + 13*(m+1)/5 + K + K/4 + J/4 + 5*J)%7 }
     * </p>
     * <p></p>
     * h is the day of the week (0 = Saturday, 1 = Sunday, 2 = Monday, …, 6 = Friday)
     * <p></p>
     * q is the day of the month
     * <p></p>
     * m is the month (3 = March, 4 = April, 5 = May, …, 14 = February)
     * <p></p>
     * K is the year of the century (year % 100).
     * <p></p>
     * J is the zero-based century (actually ⌊ year/100 ⌋) For example, the zero-based centuries for 1995 and 2000 are 19 and 20 respectively (to not be confused with the common ordinal century enumeration which indicates 20th for both cases).
     * <p></p>
     */
    public String dayOfTheWeek(int day, int month, int year) {

        if(month < 3) {
            month += 12;
            year -= 1;
        }
        int K = year%100;
        int J = year/100;

        int h = (day + 13*(month+1)/5 + K + K/4 + J/4 + 5*J)%7;

        return dayOfWeek[h];
    }

}
