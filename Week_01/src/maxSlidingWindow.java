import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 *
 * 返回滑动窗口中的最大值。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sliding-window-maximum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class maxSlidingWindow {

    public static void main(String[] args) {
        //暴力,可解决/超出时间限制
        maxSlidingWindowOne(new int[]{1,3,-1,-3,5,3,6,7},3);
        //双端队列,创建一个长度为K的队列。
        maxSlidingWindowTwo(new int[]{1,3,-1,-3,5,3,6,7},3);
    }

    private static int[] maxSlidingWindowTwo(int[] nums, int k) {
        Deque<Integer> deque = new LinkedList<>();
        // 结果数组
        int[] result = new int[nums.length-k+1];
        for (int i = 0; i < nums.length; i++) {
            // 保证从大到小 如果前面数小则需要依次弹出，直至满足要求
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]){
                deque.pollLast();
            }
            // 添加当前值对应的数组下标
            deque.offerLast(i);
            // 判断当前队列中队首的值是否有效
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

    //循环数组长度减三，
    private static int[] maxSlidingWindowOne(int[] nums, int k) {
        //创建数组，添加最大值
        int[] num = new int[nums.length-k+1];
        //循环数组长度-k次
        for (int i = 0; i <= nums.length-k; i++) {
            //创建K长度数组，每次循环，把从i到k-1的元素添加进去
            int [] max = new int[k];
            for (int j = 0; j < k; j++) {
                max[j] = nums[i+j];
            }
            //求这个数组最大值
            int maxNum = Arrays.stream(max).max().getAsInt();
            num[i] = maxNum;
        }

        return num;
    }
}
