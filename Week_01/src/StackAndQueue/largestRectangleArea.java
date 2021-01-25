package StackAndQueue;

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
