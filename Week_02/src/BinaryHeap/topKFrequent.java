package BinaryHeap;

import java.util.*;

/**
 * 347. 前 K 个高频元素
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 * 提示：
 *
 * 你可以假设给定的k总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
 * 你的算法的时间复杂度必须优于 O(n log n) ,是数组的大小。
 * 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的。
 * 你可以按任意顺序返回答案。
 */
public class topKFrequent {
    public static void main(String[] args) {
        topKFrequentOne(new int[]{1,1,1,2,2,3},2);
    }

    public static int[] topKFrequentOne(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();

        //统计数组元素出现的次数
        for (int n : nums){
            map.put(n,map.getOrDefault(n,0)+1);
        }

        System.out.println(map);

        //创建大顶堆
        PriorityQueue<Map.Entry<Integer,Integer>> queue = new PriorityQueue<>((o1, o2) -> o2.getValue()-o1.getValue());

        //便利map集合
        for (Map.Entry<Integer,Integer> entry:map.entrySet()){
            queue.add(entry);
        }

        //创建接受结果集合
        int [] res = new int[k];
        for (int i = 0; i < k; i++) {
            Map.Entry<Integer, Integer> poll = queue.poll();
            res[i]=poll.getKey();
        }
        return res;
    }
}
