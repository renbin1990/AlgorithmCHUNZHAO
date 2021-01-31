package BinaryHeap;

import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * 239. 滑动窗口最大值
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 *
 * 返回滑动窗口中的最大值。
 *
 */
public class maxSlidingWindow {
    public static void main(String[] args) {
        //队列,队列入栈要从大到小，前面小数要弹出，只到满足需求
        maxSlidingWindowOne(new int[]{1,3,-1,-3,5,3,6,7},2);
        //堆,创建大顶堆，便利数组，吧元素添加到大顶堆中，当大顶堆的大小等于k，说明
        //当前大顶堆已经k个元素了，取出其中的最大值，同时，一处大顶堆开始的元素，继续循环
        maxSlidingWindowTwo(new int[]{1,3,-1,-3,5,3,6,7},2);
    }
    public static int[] maxSlidingWindowTwo(int[] nums, int k) {
        if (nums.length==0 || k==0){
            return new int[]{0,0};
        }

        int n = nums.length;
        int [] result = new int[n-k+1];

        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2-o1);

        for (int i = 0; i < n; i++) {
            int start = i-k;
            if (start>=0){
                queue.remove(nums[start]);
            }

            queue.offer(nums[i]);

            if (queue.size()==k){
                result[i-k+1] = queue.peek();
            }
        }

        return result;
    }

    public static int[] maxSlidingWindowOne(int[] nums, int k) {
        Deque<Integer> deque = new LinkedList<>();
        int [] result = new int[nums.length-k+1];

        for (int i = 0; i < nums.length; i++) {
            while (!deque.isEmpty() && nums[deque.peekLast()]<=nums[i]){
                deque.pollLast();
            }

            deque.offerLast(i);

            if (deque.peekFirst()<=i-k){
                deque.pollFirst();
            }

            if (i+1 >= k){
                result[i+1-k] = nums[deque.peekFirst()];
            }
        }
        return result;
    }
}
