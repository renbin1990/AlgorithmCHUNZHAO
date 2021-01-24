import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

/**
 * 柱状图中最大的矩形
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 * https://leetcode-cn.com/problems/largest-rectangle-in-histogram/
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 */
public class largestRectangleArea {

    public static void main(String[] args) {
        //    largestRectangleAreaOne(new int[]{2,1,5,6,2,3});
        //   largestRectangleAreaTwo(new int[]{2,1,5,6,2,3});
        //第二种解法，从最大和最小索引循环，找到面积最大的，返回
     //   largestRectangleAreaFour(new int[]{2, 1, 5, 6, 2, 3});
        //第三种，栈解决 TODO 不懂,再看
         largestRectangleAreaThree(new int[]{2,1,5,6,2,3});
    }

    private static int largestRectangleAreaThree(int[] heights) {
        //创建一个临时数组，长度是原数组长度+2
        int [] temp = new int[heights.length+2];
        //吧原数组复制到新数组第一个位置开始，正好新数组首尾都是空元素
        System.arraycopy(heights,0,temp,1,heights.length);

        Deque<Integer> stack = new ArrayDeque<>();
        int area = 0;
        for (int i = 0; i < temp.length; i++) {
            // 对栈中柱体来说，栈中的下一个柱体就是其「左边第一个小于自身的柱体」；
            // 若当前柱体 i 的高度小于栈顶柱体的高度，说明 i 是栈顶柱体的「右边第一个小于栈顶柱体的柱体」。
            // 因此以栈顶柱体为高的矩形的左右宽度边界就确定了，可以计算面积
            while (!stack.isEmpty() && temp[i]<temp[stack.peek()]){
                int h = temp[stack.pop()];
                area = Math.max(area,(i-stack.peek()-1)*h);
            }
            stack.push(i);
        }

        return area;
    }

    private static void largestRectangleAreaFour(int[] heights) {


    }



    //找到最大数，找到比这个数小的另外一个数，索引相减*1 就是宽 * 比最大数小的数的数字，就是面积，如果是0 最大值就是面积
    //不知道怎么判断两个相同的数的索引位置，耗时 放弃
    private static int largestRectangleAreaTwo(int[] heights) {
        if (heights.length == 0) {
            return 0;
        }

        if (heights.length == 1) {
            return heights[0] * 1;
        }
        int maxNum = Arrays.stream(heights).max().getAsInt();

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < heights.length; i++) {
            list.add(heights[i]);
        }
        Collections.sort(list);
        int num = list.get(list.size() - 2);

        if (num == 0) {
            return maxNum;
        }

        int maxImdex = 0;
        int numImdex = 0;
        for (int i = 0; i < heights.length; i++) {
            if (maxNum == heights[i])
                maxImdex = i;
            if (num == heights[i])
                numImdex = i;
        }

        if (maxImdex > numImdex) {
            return (maxImdex - numImdex + 1) * num;
        } else if (maxImdex < numImdex) {
            return (numImdex - maxImdex + 1) * num;
        } else {
            return num * 2;
        }
    }

    //理解错误，重写
    //循环，找到最大的数，判断数的前一个和后一个数字的大小，找到最大的，求面积
    private static int largestRectangleAreaOne(int[] heights) {

        if (heights.length == 0) {
            return 0;
        }

        if (heights.length == 1) {
            return heights[0] * 1;
        }

        int maxNum = Arrays.stream(heights).max().getAsInt();
        int index = 0;
        for (int i = 0; i < heights.length; i++) {
            if (maxNum == heights[i]) {
                index = i;
            }
        }

        if (index != 0 && index != heights.length - 1) {
            int before = heights[index - 1];
            int after = heights[index + 1];
            if (heights[index + 1] == 0)
                return heights[index];

            if (heights[index - 1] == 0)
                return heights[index];

            if (before > after) {
                return before * 2 * 1;
            } else {
                return after * 2 * 1;
            }
        } else if (index == 0) {
            if (heights[index + 1] == 0)
                return heights[index];
            return heights[index + 1] * 2 * 1;
        } else if (index == heights.length - 1) {
            if (heights[index - 1] == 0)
                return heights[index];
            return heights[index - 1] * 2 * 1;
        }

        return 0;
    }

}
