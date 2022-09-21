package com.code.preparations.demi;

import com.code.preparations.demi.algo.leetcode.slidingwindow.SlidingWindowMaximum;
import com.code.preparations.demi.util.Helper;

public class Testing {

    public static void main(String[] args) {
        int[] val = new SlidingWindowMaximum().maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3);
        Helper.print("Output",val);
        int[] ans = {3,3,5,5,6,7};
        Helper.print("Expected",ans);
    }

}
