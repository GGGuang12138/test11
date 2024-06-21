package com.lt.MyQueue;

import java.util.Stack;

/**
 * @author Alan
 * @Description
 * @date 2024.01.15 23:04
 */
public class MyQueue {
    Stack<Integer> pushSt;
    Stack<Integer> popSt;

    // 一个栈负责队列的push存元素，将里面的元素pop后放在另外一个栈时，最先放入的会放在最上面，可用来做队列的pop
    public MyQueue() {
        pushSt = new Stack<>();
        popSt = new Stack<>();
    }

    public void push(int x) {
        pushSt.push(x);
    }

    public int pop() {
        if(popSt.isEmpty()){
            while(!pushSt.isEmpty()){
                popSt.push(pushSt.pop());
            }
        }
        return popSt.pop();
    }

    public int peek() {
        if(popSt.isEmpty()){
            while(!pushSt.isEmpty()){
                popSt.push(pushSt.pop());
            }
        }
        return popSt.peek();
    }

    public boolean empty() {
        return pushSt.isEmpty() && popSt.isEmpty();
    }
}
