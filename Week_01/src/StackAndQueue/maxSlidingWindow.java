package StackAndQueue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 239. 滑动窗口最大值
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 *
 * 返回滑动窗口中的最大值。
 */
class maxSlidingWindow {
    public static void main(String[] args) {

    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new LinkedList<>();

        int [] result = new int[nums.length-k+1];

        for (int i = 0; i < nums.length; i++) {
            // 保证从大到小 如果前面数小则需要依次弹出，直至满足要求
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]){
                deque.pollLast();
            }

            //添加当前数组下标
            deque.offerLast(i);

            //判断当前队首的值是否有效
            if (deque.peekFirst() <= i-k){
                deque.pollFirst();
            }
            // 当窗口长度为k时 保存当前窗口中最大值
            if (i+1 >=k){
                result[i+1-k] = nums[deque.peekFirst()];
            }
        }
    return result;
    }
}
