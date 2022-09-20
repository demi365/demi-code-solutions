package com.code.preparations.demi.algo.leetcode.matrix;

import com.code.preparations.demi.annotation.CodeFactor;
import com.code.preparations.demi.annotation.LeetCode;
import com.code.preparations.demi.enums.Complexity;
import com.code.preparations.demi.enums.Difficulty;
import com.code.preparations.demi.enums.ProblemType;

import java.util.HashMap;
import java.util.Map;

/**
 * You are given a 0-indexed 8 x 8 grid board, where board[r][c] represents the cell (r, c) on a game board. On the board, free cells are represented by '.', white cells are represented by 'W', and black cells are represented by 'B'.
 *<p></p>
 * Each move in this game consists of choosing a free cell and changing it to the color you are playing as (either white or black). However, a move is only legal if, after changing it, the cell becomes the endpoint of a good line (horizontal, vertical, or diagonal).
 *<p></p>
 * A good line is a line of three or more cells (including the endpoints) where the endpoints of the line are one color, and the remaining cells in the middle are the opposite color (no cells in the line are free).
 */
@LeetCode(value = 1958, difficulty = Difficulty.MEDIUM)
@CodeFactor(time = Complexity.ON, space = Complexity.ON, type = ProblemType.Matrix)
public class ChessValidMove {

    private static final int[][] DIRECTIONS = {{0,-1}, {-1,-1}, {-1,0}, {-1,1}, {0,1}, {1,1}, {1,0}, {1,-1}};
    private static final Map<Character, Character> OPPOSITES = new HashMap<>();
    static {
        OPPOSITES.put('W', 'B');
        OPPOSITES.put('B', 'W');
    }

    /**
     * We are just doing a simple check on all four directions
     */
    public boolean checkMove(char[][] board, int rMove, int cMove, char color) {

        for(int[] dir : DIRECTIONS) {
            int row = rMove;
            int col = cMove;
            if(isValid(rMove, cMove, dir) && board[row+dir[0]][col+dir[1]] == OPPOSITES.get(color)) {
                row += dir[0];
                col += dir[1];
                while(isValid(row, col, dir)) {
                    row += dir[0];
                    col += dir[1];
                    if(board[row][col] == color) {
                        return true;
                    } else if(board[row][col] == '.') {
                        break;
                    }
                }
            }
        }
        return false;
    }

    private boolean isValid(int row, int col, int[] dir) {
        return row + dir[0] < 8
                && row + dir[0] >= 0
                && col + dir[1] < 8
                && col + dir[1] >= 0;
    }

}
