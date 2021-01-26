package StackAndQueue;

import java.util.Stack;

/**
 * 42. 接雨水
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * 提示：
 * n == height.length
 * 0 <= n <= 3 * 104
 * 0 <= height[i] <= 105
 */
public class trap {

    public static void main(String[] args) {
        trapOne(new int[]{});
        trapTwo(new int[]{});
        trapThree(new int[]{});
        trapFour(new int[]{});

    }

    //栈

    /**
     * 当遍历墙的高度的时候，如果当前高度小于栈顶的墙高度，说明这里会有积水，我们将墙的高度的下标入栈。
     * 如果当前高度大于栈顶的墙的高度，说明之前的积水到这里停下，我们可以计算下有多少积水了。计算完，就把当前的墙继续入栈，作为新的积水的墙。
     * 总体的原则就是，
     * 当前高度小于等于栈顶高度，入栈，指针后移。
     * 当前高度大于栈顶高度，出栈，计算出当前墙和栈顶的墙之间水的多少，然后计算当前的高度和新栈的高度的关系，重复第 2 步。直到当前墙的高度不大于栈顶高度或者栈空，然后把当前墙入栈，指针后移。
     * 作者：windliang
     * 链接：https://leetcode-cn.com/problems/trapping-rain-water/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-w-8/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param height
     * @return
     */
    private static int trapFour(int[] height) {
        int sum = 0;
        Stack<Integer> stack = new Stack<>();
        int currect = 0;
        while (currect < height.length) {
            //如果栈不空并且当前指向的高度大于栈顶高度就一直循环
            while (!stack.empty() && height[currect] > height[stack.peek()]) {
                //取出要出栈的元素
                int h = height[stack.peek()];
                stack.pop();
                //栈空了就出去
                if (stack.empty()) {
                    break;
                }
                //两堵墙之前的距离。
                int w = currect - stack.peek() - 1;
                int min = Math.min(height[stack.peek()], height[currect]);
                sum = sum + w * (min - h);
            }

            stack.push(currect);//当前指向的墙入栈
            currect++;//指针后移
        }
        return sum;
    }

    //动态规划解法二，优化
    private static int trapThree(int[] height) {
        int sum = 0;
        int maxleft = 0;
        int[] maxright = new int[height.length];

        //右边最大值
        for (int i = height.length - 2; i >= 0; i--) {
            maxright[i] = Math.max(maxright[i + 1], height[i + 1]);
        }

        for (int i = 1; i < height.length - 1; i++) {
            //左边最大值
            maxleft = Math.max(maxleft, height[i - 1]);
            //最大和最右的最小值
            int min = Math.min(maxleft, maxright[i]);
            //如果最小值大于当前值，则最小值减当前值，就是大小
            if (min > height[i]) {
                sum = sum + (min - height[i]);
            }

        }
        return sum;
    }

    //动态规划
    //创建左边最大和右边最大的数组，求出他们每个的最高的墙
    private static int trapTwo(int[] height) {
        int sum = 0;
        int[] maxleft = new int[height.length];
        int[] maxright = new int[height.length];

        for (int i = 1; i < height.length - 1; i++) {
            maxleft[i] = Math.max(maxleft[i - 1], height[i - 1]);
        }

        for (int i = height.length - 2; i >= 0; i--) {
            maxright[i] = Math.max(maxright[i + 1], height[i + 1]);
        }

        for (int i = 1; i < height.length - 1; i++) {
            int min = Math.min(maxleft[i], maxright[i]);
            if (min > height[i]) {
                sum = sum + (min - height[i]);
            }
        }

        return sum;
    }

    //按列求 求每一列的水，我们只需要关注当前列，以及左边最高的墙，右边最高的墙就够了。
    //装水的多少，当然根据木桶效应，我们只需要看左边最高的墙和右边最高的墙中较矮的一个就够了
    //较矮的墙的高度大于当前列的墙的高度
    //较矮的墙的高度小于当前列的墙的高度
    //较矮的墙的高度等于当前列的墙的高度。
    public static int trapOne(int[] height) {
        int sum = 0;
        //最两端的列不用考虑，因为一定不会有水。所以下标从 1 到 length - 2//因为第一个 和最后一个前后肯定没水
        for (int i = 1; i < height.length - 1; i++) {
            //左边最大值
            int maxleft = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (height[j] > maxleft) {
                    maxleft = height[j];
                }
            }

            //右边最大柱体
            int maxright = 0;
            for (int j = i + 1; j < height.length; j++) {
                if (height[j] > maxright) {
                    maxright = height[j];
                }
            }

            //找出两端较小的
            int min = Math.min(maxleft, maxright);

            //只有较小的大于当前高度才有水，其他的情况没有水
            if (min > height[i]) {
                sum = sum + (min - height[i]);
            }
        }

        return sum;
    }
}
