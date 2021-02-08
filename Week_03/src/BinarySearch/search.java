package BinarySearch;

import java.util.Arrays;

/**
 * 33. 搜索旋转排序数组
 * 升序排列的整数数组 nums 在预先未知的某个点上进行了旋转（例如， [0,1,2,4,5,6,7] 经旋转后可能变为 [4,5,6,7,0,1,2] ）。
 * <p>
 * 请你在数组中搜索 target ，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 */
public class search {

    public static void main(String[] args) {
        System.out.println(search(new int[]{1},1));
    }
    /**
     * 如果num[0] > target  说明这个值在后半部分
     * 否则，这个值在前半部分
     * @param nums
     * @param target
     * @return
     */
    public static int search(int[] nums, int target) {
        if (nums.length==0){
            return -1;
        }

        if (nums.length==1 && nums[0] ==target){
            return 0;
        }

        int left = 0;
        int right=nums.length - 1;
        int mid;
        while (left <= right) {
            mid = (right - left) / 2 + left;
            if (nums[mid] == target) {
                return mid;
            }

            //在前半部分 升序
            if (nums[mid] >= nums[0]) {
                if (nums[0] <= target && target < nums[mid]){
                    right = mid - 1;
                }else {
                    left = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[nums.length - 1]) {
                    left = mid + 1;
                }else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
