package Arrays;

/**
 * 11. 盛最多水的容器
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0) 。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/container-with-most-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class maxArea {
    public static void main(String[] args) {
        //暴力法，两层循环，求最大面积
        maxAreaOne(new int[]{1,8,6,2,5,4,8,3,7});
        //双指针法，定义两个指针，从两侧往中心移动，如果左比又小，则当前面积是（右索引-左索引*左），左移动一位，反之 右移动一位
        maxAreaTwo(new int[]{1,8,6,2,5,4,8,3,7});
    }

    private static int maxAreaTwo(int[] nums) {
        int aera  = 0,i = 0,j = nums.length-1;
        while (i<j){
            int res;
         if (nums[i]<nums[j]){
             res = (j-i)*nums[i];
             i++;
         }  else {
             res = (j-i)*nums[j];
             j--;
         }

         aera = Math.max(aera,res);
        }

        return aera;
    }

    private static int maxAreaOne(int[] nums) {
        int aera = 0;
        for (int i = 0; i < nums.length-1; i++) {
            for (int j = i+1; j < nums.length; j++) {
                //获取高度差,计算面积
                int h = (j-i)*Math.min(nums[i],nums[j]);
                aera = Math.max(aera,h);
            }
        }

        return aera;
    }
}
