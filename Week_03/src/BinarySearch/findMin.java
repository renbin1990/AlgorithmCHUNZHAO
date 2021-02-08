package BinarySearch;

/**
 * 153. 寻找旋转排序数组中的最小值
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] 。
 * <p>
 * 请找出其中最小的元素。
 */
public class findMin {
    public static void main(String[] args) {

    }

    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int mid;
        while (left < right){
            mid = (right - left) / 2 + left;
            //中间的大于右边的，说明在前半部分，最小值是在后半部分，左边界右移
            if (nums[mid] > nums[right]){
                left = mid+1;
            }else {
                right = mid;
            }
        }

        return nums[left];
    }

    public int findMinOne(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int min = Integer.MAX_VALUE;
        int left = 0;
        int right = nums.length - 1;

        if (nums[right] > nums[0]) {
            return nums[0];
        }

        int mid;
        while (left <= right) {
            mid = (right - left) / 2 + left;
            min = Math.min(min, mid);
            //如果中间数比它后一位数大 说明是降序，后一位元素，就是旋转后的最小数
            if (nums[mid] > nums[mid + 1]) {
                min = nums[mid + 1];
                break;
            }
            ////如果中间数比它前一位数小 说明是降序，中间数就是旋转后的最小数
            if (nums[mid - 1] > nums[mid]) {
                min = nums[mid];
                break;
            }
            //如果中间数 大于第一位元素，说明是在前半边，左边界右移，因为最小数肯定是在右边
            if (nums[mid] > nums[0]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return min;
    }
}
