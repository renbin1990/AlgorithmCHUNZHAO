package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15. 三数之和
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 */
public class threeSum {
    public static void main(String[] args) {
        //暴力法，三重循环，超出时间限制
        //因为 i+j+k = 0,可以是 i+j =0-k;所以双重循环
        threeSumOne(new int[]{});
    }

    /**
     * 首先对数组进行排序，排序后固定一个数 nums[i]nums[i]，再使用左右指针指向 nums[i]nums[i]后面的两端，数字分别为 nums[L]nums[L] 和 nums[R]nums[R]，计算三个数的和 sumsum 判断是否满足为 00，满足则添加进结果集
     * 如果 nums[i]nums[i]大于 00，则三数之和必然无法等于 00，结束循环
     * 如果 nums[i]nums[i] == nums[i-1]nums[i−1]，则说明该数字重复，会导致结果重复，所以应该跳过
     * 当 sumsum == 00 时，nums[L]nums[L] == nums[L+1]nums[L+1] 则会导致结果重复，应该跳过，L++L++
     * 当 sumsum == 00 时，nums[R]nums[R] == nums[R-1]nums[R−1] 则会导致结果重复，应该跳过，R--R−−
     * 时间复杂度：O(n^2)O(n
     * 2)，nn 为数组长度
     */
    private static List<List<Integer>> threeSumOne(int[] nums) {
        List<List<Integer>> list = new ArrayList();
        if (nums.length <= 2) {
            return list;
        }

        //排序
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            //当前数字大于0，三数之和肯定大于0 因为排序了
            if (nums[i] > 0)
                break;

            //去重
            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            int L = i + 1;
            int R = nums.length - 1;

            while (L < R) {
                int sum = nums[i] + nums[L] + nums[R];
                if (sum == 0) {
                    //添加到集合中
                    list.add(Arrays.asList(nums[i], nums[L], nums[R]));
                    //去重
                    while (L < R && nums[L] == nums[L + 1]) {
                        L++;
                    }
                    //去重
                    while (L < R && nums[R] == nums[R - 1]) {
                        R--;
                    }

                    L++;
                    R--;
                } else if (sum < 0) {
                    L++;
                } else if (sum > 0) {
                    R--;
                }
            }
        }

        return list;
    }
}
