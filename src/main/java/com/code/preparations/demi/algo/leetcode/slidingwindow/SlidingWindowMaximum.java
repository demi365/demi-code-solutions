package com.code.preparations.demi.algo.leetcode.slidingwindow;

import com.code.preparations.demi.annotation.CodeFactor;
import com.code.preparations.demi.annotation.LeetCode;
import com.code.preparations.demi.enums.Complexity;
import com.code.preparations.demi.enums.Difficulty;
import com.code.preparations.demi.enums.ProblemType;

@LeetCode(value = 239, difficulty = Difficulty.HARD)
public class SlidingWindowMaximum {

    /**
     * This was my initial approach, which gave a "Took too long" on Leetcode.
     * Basic idea is to not find max among numbers, when we look at the previous max index still being within range.
     * If new max is found while the old max is within range, extend range.
     * If we lose max out of the range, we should find max again.
     */
    @CodeFactor(space = Complexity.ON, time = Complexity.ON2, type = ProblemType.SlidingWindow)
    public int[] maxSlidingWindowInitial(int[] nums, int k) {
        int maxIndex = findMaxIndex(nums, 0, k);

        int[] maxValues = new int[nums.length-k+1];
        maxValues[0] = nums[maxIndex];
        int count = 1;
        for(int i=k; i< nums.length; i++) {
            if (maxIndex <= i-k) {
                maxIndex = findMaxIndex(nums, i-k+1, i+1);
            } else if (nums[i] == nums[maxIndex]) {
                maxIndex = i;
            } else if (nums[i] > nums[maxIndex]) {
                maxIndex = i;
            }
            maxValues[count++] = nums[maxIndex];
        }

        return maxValues;
    }

    public int findMaxIndex(int[] nums, int start, int end) {
        int maxIndex = start;
        for(int i=start+1; i<end; i++) {
            if(nums[i] >= nums[maxIndex]) {
                maxIndex = i;
            }
        }

        return maxIndex;
    }

    /**
     * The most efficient and understandable solution I could find in discussions, this is based on logic,
     * where the max at each point can be from left or right.
     * <p></p>
     * We split the elements into small windows of size 1 to k, and individually reset the max within these indices whenever
     * we cross the size of k. Else we keep track of each left maximum. Then we can iterate again to find right max on each side.
     * This will give us a window based left max and right max.
     * <p></p>
     * Then the final max will be the max of the left max value on the window's corner, and the right windows start corner.
     *
     * @param nums input array
     * @param k window size
     * @return max in the individual windows
     */
    @CodeFactor(time = Complexity.ON, space = Complexity.ON, type = ProblemType.SlidingWindow)
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] leftMax = new int[nums.length];
        leftMax[0] = nums[0];
        for(int i=1; i< nums.length; i++){
            int prevMax = i%k == 0 ? nums[i] : leftMax[i-1];
            leftMax[i] = Math.max(prevMax, nums[i]);
        }
        int[] rightMax = new int[nums.length];
        rightMax[nums.length-1] = nums[nums.length-1];
        for(int i=nums.length-2; i>=0; i--){
            int prevMax = i%k == 0 ? nums[i] : rightMax[i+1];
            rightMax[i] = Math.max(prevMax, nums[i]);
        }

        int[] res = new int[nums.length-k+1];
        for(int i =0; i< nums.length-k+1; i++) {
            res[i] = Math.max(rightMax[i], leftMax[i+k-1]);
        }

        return res;
    }


}
