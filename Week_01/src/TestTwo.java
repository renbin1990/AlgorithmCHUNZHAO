import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

/**
 * 五毒解法：1.读题+思考；直接看解法并比较不同解法的优缺点
 * 2.直接写，提交-->优化
 * 3.一天后再进行练习
 * 4、一周后练习
 * 5、面试之前进行薄弱环节的练习（恢复性）
 */
public class TestTwo {
    public void main(String[] args) {
        //移动0
        moveZeroes(new int[]{0,1,0,3,12});
        //盛最多水的容器
        maxArea(new int[]{0,1,0,3,12});
        //两数之和
        twoSum(new int[]{0,2,0,3,7},9);
    }

    /**
     * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 的那 两个 整数，并返回它们的数组下标。
     *
     * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
     *
     * 你可以按任意顺序返回答案。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/two-sum
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param nums
     * @param target
     */
    private int[] twoSum(int[] nums, int target) {

        if (nums==null && nums.length<=1){
            return new int[]{0,0};
        }

        int j = 0;
        int k = 0;
        int index = 0;
        for (int i = 0; i < nums.length-1; i++) {
            index++;
            if (nums[i]+nums[index]!=target){

            }else {
                j = i;
                k = index;
            }
        }

        return new int[]{j,k};
    }

    /**
     * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0) 。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
     *
     * 说明：你不能倾斜容器。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/container-with-most-water
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param nums
     */
    private void maxArea(int[] nums) {
        //1、本质是求两个数的乘积最大值，
    }

    /**
     * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
     *
     * 示例:
     *
     * 输入: [0,1,0,3,12]
     * 输出: [1,3,12,0,0]
     * 说明:
     *
     * 必须在原数组上操作，不能拷贝额外的数组。
     * 尽量减少操作次数
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/move-zeroes
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        //1、遍历数组，查询到有0的索引元素，和后一位元素交换位置，直到交换的元素为0
        //2、指针 index
        //3、遍历整个数组，遇到0 删除 末尾+0

        moveZeroesOne(nums);
        moveZeroesTwo(nums);
        moveZeroesThree(nums);
    }

    private void moveZeroesOne(int[] nums) {
        if (nums.length==0){
            return;
        }

        int j = 0;
        for (int i = 0; i < nums.length ;i++) {
            if (nums[i]!= 0){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;

                j++;
            }
        }
    }

    /**
     * 声明一个索引，遍历数组，如果当前索引元素不等于0，声明的索引为的元素等于这个索引的元素，声明元素自增，直到遍历完成，
     * 知道声明元素的个数，在循环，从个数开始后面的元素都置空
     * @param nums
     */
    private void moveZeroesTwo(int[] nums) {
        if (nums.length==0){
            return;
        }

        int last = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0){
                nums[last++] = nums[i];
            }
        }

        for (int i = last; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    private void moveZeroesThree(int[] nums) {
        if (nums.length==0){
            return;
        }

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
        }


        for (int i = 0; i < list.size(); i++) {
            if (list.get(i)==0){
                list.remove(i);
                i--;
                list.add(list.size()-1,0);
            }
        }

        for (int i = 0; i < list.size(); i++) {
            nums[i] = list.get(i);
        }

        System.out.println(nums);
    }

}
