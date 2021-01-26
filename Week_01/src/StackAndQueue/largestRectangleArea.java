package StackAndQueue;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 84. 柱状图中最大的矩形
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 * <p>
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 */
class largestRectangleArea {
    public static void main(String[] args) {
        //暴力法。遍历每个柱子，以当前的柱子高度作为矩形的高h
        //从当前的柱子向作业两边遍历，找到矩形的宽度w
        //超出时间限制
        largestRectangleAreaOne(new int[]{});
        //2 栈：我们遍历每个柱体，若当前的柱体高度大于等于栈顶柱体的高度
        // ，就直接将当前柱体入栈，否则若当前的柱体高度小于栈顶柱体的高度，
        // 说明当前栈顶柱体找到了右边的第一个小于自身的柱体，那么就可以将栈顶柱体出栈来计算以其为高的矩形的面积了。
        largestRectangleAreaTwo(new int[]{});
    }

    private static int largestRectangleAreaTwo(int[] heights) {
        int [] temp = new int[heights.length+2];
        System.arraycopy(heights,0,temp,1,heights.length);

        Deque<Integer> deque = new ArrayDeque<>();
        int aera = 0;
        for (int i = 0; i < temp.length; i++) {
            //// 对栈中柱体来说，栈中的下一个柱体就是其「左边第一个小于自身的柱体」；
            //  若当前柱体 i 的高度小于栈顶柱体的高度，说明 i 是栈顶柱体的「右边第一个小于栈顶柱体的柱体」。
            // 因此以栈顶柱体为高的矩形的左右宽度边界就确定了
            while (!deque.isEmpty() &&temp[i] < temp[deque.peek()]){
                int h = temp[deque.pop()];
                aera = Math.max(aera,(i-deque.peek()-1)*h);
            }

            deque.push(i);
        }

        return aera;
    }

    private static int largestRectangleAreaOne(int[] ints) {
        int aera = 0;
        int n = ints.length;

        for (int i = 0; i < n; i++) {
            int w = 0;
            int h = ints[i];
            int j = i;

            while (--j >= 0 && ints[j] >= h) {
                w++;
            }

            j = i;

            while (++j < n && ints[j] >= h) {
                w++;
            }
            aera = Math.max(aera, w * h);
        }
        return aera;
    }
}
