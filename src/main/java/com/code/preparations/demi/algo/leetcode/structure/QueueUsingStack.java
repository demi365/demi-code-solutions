package com.code.preparations.demi.algo.leetcode.structure;

import com.code.preparations.demi.annotation.CodeFactor;
import com.code.preparations.demi.annotation.LeetCode;
import com.code.preparations.demi.enums.Complexity;
import com.code.preparations.demi.enums.Difficulty;
import com.code.preparations.demi.enums.ProblemType;

import java.util.Stack;

/**
 * Implement a first in first out (FIFO) queue using only two stacks. 
 * The implemented queue should support all the functions of a normal queue (push, peek, pop, and empty).
 *<p></p>
 * Implement the QueueUsingStack class:
 *<p></p>
 * void push(int x) Pushes element x to the back of the queue.
 * <p></p>
 * int pop() Removes the element from the front of the queue and returns it.
 * <p></p>
 * int peek() Returns the element at the front of the queue.
 * <p></p>
 * boolean empty() Returns true if the queue is empty, false otherwise.
 */
@LeetCode(value = 232, difficulty = Difficulty.EASY)
@CodeFactor(time = Complexity.ON, space = Complexity.ON, type = ProblemType.DataStructure)
public class QueueUsingStack {

    private final Stack<Integer> push;
    private final Stack<Integer> pop;

    public QueueUsingStack() {
        push = new Stack<>();
        pop = new Stack<>();
    }

    /**
     * pushes the passed element to the push stack
     */
    public void push(int x) {
        push.push(x);
    }

    /**
     * @return returns the last element in the stack
     */
    public int pop() {
        this.populatePopStack();
        if(pop.isEmpty())
            return 0;
        return pop.pop();
    }

    /**
     * @return take a peek at the last element in the queue
     */
    public int peek() {
        this.populatePopStack();
        if(!pop.isEmpty())
            return pop.peek();
        return 0;
    }

    /**
     * If we haven't populated pop stack, populate it in the reverse of the push stack.
     * <p></p>
     * This way when we populate the pop stack, whatever we pull from top will be now a push operation.
     */
    public void populatePopStack() {
        if(pop.isEmpty()) {
            while(!push.isEmpty()) {
                pop.push(push.pop());
            }
        }
    }

    public boolean empty() {
        return pop.isEmpty() && push.isEmpty();
    }

}
