package com.code.preparations.demi;

import java.util.*;

public class Testing {

    public static void main(String[] args) {
        Map<String, Integer> hash = new HashMap<>();

        TreeSet<String> tree = new TreeSet<>(Comparator.comparingInt(hash::get));
        tree.size();
        tree.pollFirst();
        tree.isEmpty();

        PriorityQueue<String> queue = new PriorityQueue<>(Comparator.comparingInt(hash::get));
        queue.poll();
        bitwiseOR(new int[]{1,0,2,1,3});
    }

    private static int[][] bitwiseOR(int [] arr) {
        int[] leftMax = new int[arr.length];
        leftMax[0] = arr[0];
        for(int i=1; i<arr.length; i++) {
            leftMax[i] = leftMax[i-1] | arr[i];
        }
        int[] rightMax = new int[arr.length];
        rightMax[arr.length-1] = arr[arr.length-1];
        for(int i=arr.length-2; i>=0; i--) {
            rightMax[i] = rightMax[i+1] | arr[i];
        }
        return new int[][]{leftMax, rightMax};
    }

}
