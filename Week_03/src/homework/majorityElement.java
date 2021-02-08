package homework;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 169. 多数元素
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 */
public class majorityElement {
    public static void main(String[] args) {

    }

    //排序，找中位数，中位数是频率最高的
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length >> 1];
    }


    //遍历整个数组，对记录每个数值出现的次数(利用HashMap，其中key为数值，value为出现次数)；
    //接着遍历HashMap中的每个Entry，寻找value值> nums.length / 2的key即可。
    public int majorityElementOne(int[] nums) {
        if (nums.length==0){
            return 0;
        }

        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }

        Map.Entry<Integer,Integer> temp = null;
        for (Map.Entry<Integer,Integer> entry : map.entrySet()){
            if (entry.getValue() > nums.length/2){
                temp = entry;
            }
        }

        return temp==null?0:temp.getKey();
    }
}
