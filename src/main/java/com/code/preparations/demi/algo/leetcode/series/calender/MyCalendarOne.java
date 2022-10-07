package com.code.preparations.demi.algo.leetcode.series.calender;

import com.code.preparations.demi.annotation.CodeFactor;
import com.code.preparations.demi.annotation.LeetCode;
import com.code.preparations.demi.enums.Complexity;
import com.code.preparations.demi.enums.Difficulty;
import com.code.preparations.demi.enums.ProblemType;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * You are implementing a program to use as your calendar. We can add a new event if adding the event will not cause a double booking.
 *<p></p>
 * A double booking happens when two events have some non-empty intersection (i.e., some moment is common to both events.).
 *<p></p>
 * The event can be represented as a pair of integers start and end that represents a booking on the
 * half-open interval [start, end), the range of real numbers x such that start <= x < end.
 *
 */
@LeetCode(value = 729, difficulty = Difficulty.MEDIUM)
@CodeFactor(time = Complexity.OLogN, space = Complexity.ON, type = ProblemType.DataStructure)
public class MyCalendarOne {

    private final TreeSet<int[]> bookings;

    /**
     * MyCalendar() Initializes the calendar object.
     */
    public MyCalendarOne() {
        bookings = new TreeSet<>(Comparator.comparingInt(a -> a[0]));
    }

    /**
     * boolean book(int start, int end) Returns true if the event can be added to the calendar successfully without
     * causing a double booking. Otherwise, return false and do not add the event to the calendar.
     */
    public boolean book(int start, int end) {
        int[] book = new int[]{start, end};
        int[] bookBefore = bookings.floor(book);
        int[] bookAfter = bookings.ceiling(book);
        if(  (bookBefore != null && bookBefore[1] > book[0])
                || ( bookAfter != null &&  bookAfter[0] < book[1])) {
            return false;
        }
        bookings.add(book);
        return true;
    }

}
