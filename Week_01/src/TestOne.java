/**
 * 五毒解法：1.读题+思考；直接看解法并比较不同解法的优缺点
 * 2.直接写，提交-->优化
 * 3.一天后再进行练习
 * 4、一周后练习
 * 5、面试之前进行薄弱环节的练习（恢复性）
 */
public class TestOne {
    public static void main(String[] args) {

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
        int len = 0;
        int last;

        if (nums.length==0){
            return;
        }

        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i]==len){
                last = nums[i+1];
                nums[i+1] = len;
                nums[i] = last;
            }

        }
    }
}
