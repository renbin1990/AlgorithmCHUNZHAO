package GreedyAlgorithm;

/**
 * 55. 跳跃游戏
 * 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
 * <p>
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * <p>
 * 判断你是否能够到达最后一个下标。
 */
public class canJump {


    public boolean canJump(int[] nums) {
        int count = 0, len = nums.length - 2;
        while (len >= 0) count = nums[len--] > count ? 0: ++count;
        return count == 0;
    }

    /**
     * 如果某一个作为 起跳点 的格子可以跳跃的距离是 3，那么表示后面 3 个格子都可以作为 起跳点。
     * 可以对每一个能作为 起跳点 的格子都尝试跳一次，把 能跳到最远的距离 不断更新。
     * 如果可以一直跳到最后，就成功了。
     * @param nums
     * @return
     */
    public boolean canJumpTwo(int[] nums) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i>k){
                return false;
            }

            k = Math.max(k,i+nums[i]);
        }

        return true;
    }
    //贪心算法。倒序遍历，遍历索引就是跳跃步数，只要当前值+当前索引> 结尾索引，说明就能跳过去
    public boolean canJumpOne(int[] nums) {
        if (nums.length == 0) {
            return false;
        }

        int end = nums.length - 1;

        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] + i >= end) {
                end = i;
            }
        }
        return end == 0;
    }
}
