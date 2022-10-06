package com.code.preparations.demi.algo.leetcode.structure;

import com.code.preparations.demi.annotation.CodeFactor;
import com.code.preparations.demi.annotation.LeetCode;
import com.code.preparations.demi.enums.Complexity;
import com.code.preparations.demi.enums.Difficulty;
import com.code.preparations.demi.enums.ProblemType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Design a time-based key-value data structure that can store multiple values for the same key at different time stamps
 * and retrieve the key's value at a certain timestamp.
 *<p></p>
 * Implement the TimeMap class:
 *<p></p>
 * TimeMap() Initializes the object of the data structure.
 * <p></p>
 * void set(String key, String value, int timestamp) Stores the key key with the value value at the given time timestamp.
 * <p></p>
 * String get(String key, int timestamp) Returns a value such that set was called previously, with timestamp_prev <= timestamp.
 * <p></p>
 * If there are multiple such values, it returns the value associated with the largest timestamp_prev. If there are no values, it returns "".
 */
@LeetCode(value = 981, difficulty = Difficulty.MEDIUM)
@CodeFactor(time = Complexity.OLogN, space = Complexity.ON, type = ProblemType.DataStructure)
class TimeMap {

    Map<String, List<TimeValue>> keyMap;

    public TimeMap() {
        keyMap = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        List<TimeValue> timeValues = keyMap.get(key);
        if(timeValues == null) {
            timeValues = new ArrayList<>();
        }
        timeValues.add(new TimeValue(timestamp, value));
        keyMap.put(key, timeValues);
    }

    public String get(String key, int timestamp) {
        List<TimeValue> timeValues = keyMap.get(key);
        if (timeValues != null) {
            int low = 0;
            int high = timeValues.size()-1;
            String value = "";
            // using binary search to find the value closest to the key and timestamp
            while(low <= high) {
                int mid = low + (high-low)/2;
                TimeValue timeValue = timeValues.get(mid);
                if(timeValue.timestamp == timestamp) {
                    return timeValue.value;
                } else if(timeValue.timestamp < timestamp) {
                    value = timeValue.value;
                    low = mid+1;
                } else {
                    high = mid-1;
                }
            }
            return value;
        }
        return "";
    }

    private static class TimeValue {
        protected Integer timestamp;
        protected String value;
        protected TimeValue(Integer timestamp, String value) {
            this.timestamp = timestamp;
            this.value = value;
        }
    }

}