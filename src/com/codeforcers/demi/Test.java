package com.codeforcers.demi;

import com.codeforcers.demi.algo.leetcode.RangeSumMatrix;

public class Test {

    public static void main(String[] args){
        int[][] values = new int[][]{{1,2,3},{4,5,6}, {7,8,9}};
        RangeSumMatrix sumMatrix = new RangeSumMatrix(values);
        System.out.println(sumMatrix.sumRegion(1,1,2,2));
        System.out.println(sumMatrix.sumRegion(1,1,2,1));
        System.out.println(sumMatrix.sumRegion(0,0,2,2));
    }

}
