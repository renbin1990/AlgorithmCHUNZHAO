import java.util.Stack;

/**
 * 五毒解法：1.读题+思考；直接看解法并比较不同解法的优缺点
 * 2.直接写，提交-->优化
 * 3.一天后再进行练习
 * 4、一周后练习
 * 5、面试之前进行薄弱环节的练习（恢复性）
 */
//z最小栈
public class MinStack {

    private final Stack<int []> mStack;

    /** initialize your data structure here. */
    public MinStack() {
        mStack = new Stack<>();
    }

    /**
     * 每次新元素入栈时，要求新的栈内最小值：比较当前新插入元素 x 和 当前栈内最小值（即栈顶元组的第二个值）的大小。
     * 新元素入栈：当栈为空，保存元组 (x, x)；当栈不空，保存元组 (x, min(此前栈内最小值， x)))
     * 出栈：删除栈顶的元组。
     * @param x
     */
    public void push(int x) {
        if (mStack.empty()){
            mStack.push(new int[]{x,x});
        }else {
            mStack.push(new int[]{x, Math.min(x, mStack.peek()[1])});
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
