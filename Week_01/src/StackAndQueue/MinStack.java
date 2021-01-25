package StackAndQueue;

import java.util.Stack;

/**
 * 155. 最小栈
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 * push(x) —— 将元素 x 推入栈中。
 * pop() —— 删除栈顶的元素。
 * top() —— 获取栈顶元素。
 * getMin() —— 检索栈中的最小元素。
 *
 */
class MinStack {

    private final Stack<int []> mStack;

    public MinStack() {
        mStack = new Stack<>();
    }

    //把最小的元素放在索引1的位置上
    public void push(int x) {
        if (mStack.empty()){
            mStack.push(new int[]{x,x});
        }else {
            mStack.push(new int[]{x,Math.min(x,mStack.peek()[1])});
        }
    }

    public void pop() {
        mStack.pop();
    }

    public int top() {
        return mStack.peek()[0];
    }

    public int getMin() {
        return mStack.peek()[1];
    }
}
