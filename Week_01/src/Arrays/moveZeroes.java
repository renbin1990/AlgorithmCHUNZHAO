package Arrays;

/**
 * 283. 移动零
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 说明:
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 */
public class moveZeroes {
    public static void main(String[] args) {
        //遍历数组，查询到有0的索引元素，和后一位元素交换位置，直到交换的元素为0
        moveZeroesOne(new int[]{});
        //指针法，遍历数组，遇到不为0的数字，赋值指针位置，指针+1，遍历完成，指针后所有的元素置为0
        moveZeroesTwo(new int[]{});
    }

    private static void moveZeroesTwo(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]!= 0){
                nums[index] = nums[i];
                index++;
            }
        }

        for (int i = index; i <nums.length ; i++) {
            nums[i] = 0;
        }
    }

    private static void moveZeroesOne(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]!=0){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j++;
            }
        }
    }
}
