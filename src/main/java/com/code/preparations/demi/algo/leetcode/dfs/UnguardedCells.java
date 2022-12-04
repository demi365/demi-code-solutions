package com.code.preparations.demi.algo.leetcode.dfs;

import com.code.preparations.demi.annotation.CodeFactor;
import com.code.preparations.demi.annotation.LeetCode;
import com.code.preparations.demi.enums.Complexity;
import com.code.preparations.demi.enums.Difficulty;
import com.code.preparations.demi.enums.ProblemType;

/**
 * You are given two integers m and n representing a 0-indexed m x n grid.
 * You are also given two 2D integer arrays guards and walls where guards[i] = [rowi, coli] and walls[j] = [rowj, colj]
 * represent the positions of the ith guard and jth wall respectively.
 *<p></p>
 * A guard can see every cell in the four cardinal directions (north, east, south, or west) starting from their position
 * unless obstructed by a wall or another guard. A cell is guarded if there is at least one guard that can see it.
 *<p></p>
 * Return the number of unoccupied cells that are not guarded.
 */
@LeetCode(value = 2257, difficulty = Difficulty.MEDIUM)
@CodeFactor(time = Complexity.ONM, space = Complexity.ONM, type = ProblemType.DFS)
public class UnguardedCells {

    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] arr = new int[m][n];

        // filling matrix with walls
        for(int[] wall : walls) {
            arr[wall[0]][wall[1]] = 2;
        }
        // filling matrix with guards
        for(int[] guard : guards) {
            arr[guard[0]][guard[1]] = 1;
        }
        // filling matrix occupied positions
        for(int[] guard : guards) {
            dp(arr, guard[0], guard[1]);
        }

        int unguarded = 0;
        for(int i =0; i<m; i++) {
            for(int j =0; j<n; j++) {
                if(arr[i][j] == 0)
                    unguarded++;
            }
        }

        return unguarded;
    }

    public void dp(int[][] arr, int row, int col) {
        int tempRow = row;
        while(fill(arr, tempRow+1, col)) {
            tempRow+=1;
        }
        tempRow = row;
        while(fill(arr, tempRow-1, col)) {
            tempRow-=1;
        }
        int tempCol = col;
        while(fill(arr, row, tempCol+1)) {
            tempCol+=1;
        }
        tempCol = col;
        while(fill(arr, row, tempCol-1)) {
            tempCol-=1;
        }
    }

    public boolean fill(int[][] arr, int row, int col) {
        if(row == arr.length || row < 0 || col == arr[row].length || col < 0)
            return false;
        if(arr[row][col] == 1 || arr[row][col] == 2) {
            return false;
        }
        arr[row][col] = 3;
        return true;
    }
}
