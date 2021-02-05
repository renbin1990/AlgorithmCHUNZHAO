package DivideConquer;

import java.util.ArrayList;
import java.util.List;

/**
 * 78. 子集
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 *
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 */
public class subsets {
    public static void main(String[] args) {
        //递归。
        subsetsOne(new int[]{1,2,3,4});
        //d迭代法
        subsetsTwo(new int[]{1,2,3});
    }

    private static List<List<Integer>> subsetsTwo(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int size = nums.length;
        int n = 1 << size;
        for (int i = 0; i < n; i++) {
            List<Integer> cur = new ArrayList<>();
            for (int j = 0; j < size; j++) {
                if (((i >> j) & 1) == 1) {
                    cur.add(nums[j]);
                }
            }
            result.add(cur);
        }

        return result;
    }

    public static List<List<Integer>> subsetsOne(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length==0){
            return result;
        }
        dfsSubsets(0,nums,result,new ArrayList<Integer>());
        return result;
    }

    private static void dfsSubsets(int level, int[] nums, List<List<Integer>> result, ArrayList<Integer> list) {
        //递归终止条件，如果level与数组长度相等，递归终止，把数据添加到集合中
        if (level == nums.length){
            result.add(new ArrayList<Integer>(list));
            return;
        }

        //递归单数
        //下探到下一层
        //不选当前数字的索引
        dfsSubsets(level+1,nums,result,list);
        list.add(nums[level]);
        //选择当前数字的索引
        dfsSubsets(level+1,nums,result,list);
         //清理当前层;
        list.remove(list.size()-1);
    }
}
