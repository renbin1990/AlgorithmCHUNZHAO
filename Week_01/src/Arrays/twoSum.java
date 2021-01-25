package Arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * 1. 两数之和
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 的那 两个 整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 * 你可以按任意顺序返回答案。
 */
public class twoSum {
    public static void main(String[] args) {
        //暴力法，双重循环，相加等于目标值，返回他们的下标
        twoSumOne(new int[]{},5);
        //哈希解法 ，把数组值当key存到map中，value是索引，num[i] +map(key) = target
        //反之map(key) = target-num[i] ； 如果相等；说明这个key就是另外一个值，返回value
        twoSumThree(new int[]{},5);
    }

    private static int[] twoSumThree(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target-nums[i])){
                return new int[]{map.get(target-nums[i]),i};
            }
            map.put(nums[i],i);
        }

        return new int[]{0,0};
    }

    private static int[] twoSumOne(int[] nums, int target) {
        if (nums.length<=1){
            return new int[]{0,0};
        }

        for (int i = 0; i < nums.length-1; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i]+nums[j] == target){
                    return new int[]{i,j};
                }
            }
        }

        return new int[]{0,0};
    }
}
