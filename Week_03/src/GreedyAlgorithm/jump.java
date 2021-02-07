package GreedyAlgorithm;

/**
 * 45. 跳跃游戏 II
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 */
public class jump {

    public int jump(int[] nums) {
        int res = 0;
        int max = 0;
        int end = 0;

        for (int i = 0; i < nums.length-1; i++) {
            max = Math.max(max,nums[i]+i);

            if (i==end){
                end = max;
                res++;
            }
        }

        return res;
    }


    public int jumpOne(int[] nums) {
        int res = 0;
        int start = 0;
        int end = 1;

        while (end<nums.length){
            int max = 0;
            for (int i = start; i <end ; i++) {
                // 能跳到最远的距离
                max = Math.max(max,i+nums[i]);
            }

            start= end;  // 下一次起跳点范围开始的格子
            end = max+1;  // 下一次起跳点范围结束的格子
            res++;
        }
        return res;
    }
}
