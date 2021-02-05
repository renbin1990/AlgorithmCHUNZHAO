package DivideConquer;

import java.util.*;

/**
 * 169. 多数元素
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 * <p>
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 */
public class majorityElement {
    public static void main(String[] args) {
        //第一中方法，遍历，存入与一个map集合，相同元素，value+1 ，获取最大valuse，输出key
        System.out.println(majorityElementOne(new int[]{2, 2, 1, 1, 1, 2, 2}));

    }

    public int majorityElement(int[] nums) {
        return majorityElementRec(nums, 0, nums.length - 1);
    }

    private int majorityElementRec(int[] nums, int level, int max) {
        // base case; the only element in an array of size 1 is the majority
        // element.
        if (level == max) {
            return nums[level];
        }

        // recurse on left and right halves of tmaxs slice.
        int mid = (max - level) / 2 + level;
        int left = majorityElementRec(nums, level, mid);
        int right = majorityElementRec(nums, mid + 1, max);

        // if the two halves agree on the majority element, return it.
        if (left == right) {
            return left;
        }

        // otherwise, count each element and return the "winner".
        int leftCount = countInRange(nums, left, level, max);
        int rightCount = countInRange(nums, right, level, max);

        return leftCount > rightCount ? left : right;
    }

    private int countInRange(int[] nums, int num, int level, int max) {
        int count = 0;
        for (int i = level; i <= max; i++) {
            if (nums[i] == num) {
                count++;
            }
        }
        return count;
    }


    public static int majorityElementTwo(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        //便利map集合
        Map.Entry<Integer, Integer> majorityEntry = null;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (majorityEntry != null || majorityEntry.getValue() < entry.getValue()) {
                majorityEntry = entry;
            }
        }
        return majorityEntry.getKey();
    }


    public static int majorityElementOne(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        //创建大顶堆
        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>((o1, o2) -> o2.getValue() - o1.getValue());
        //便利map集合
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            queue.add(entry);
        }
        return queue.poll().getKey();
    }
}
