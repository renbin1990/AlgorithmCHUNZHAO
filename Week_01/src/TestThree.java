import java.util.*;

/**
 * 五毒解法：1.读题+思考；直接看解法并比较不同解法的优缺点
 * 2.直接写，提交-->优化
 * 3.一天后再进行练习
 * 4、一周后练习
 * 5、面试之前进行薄弱环节的练习（恢复性）
 */
public class TestThree {
    public static void main(String[] args) {
        //盛最多水的容器
        maxArea(new int[]{0,1,0,3,12});
        //移动0
        moveZeroes(new int[]{0,1,0,3,12});
        //爬楼梯
        climbStairs(3);
        //两数之和
        twoSum(new int[]{0,1,0,3,12},13);
        //三数之和
        threeSum(new int[]{-1,0,1,2,-1,-4});
    }

    //给你一个包含 n 个整数的数组nums，判断nums中是否存在三个元素 a，b，c ，使得a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
    //注意：答案中不可以包含重复的三元组。


    private static void threeSum(int[] ints) {
        //暴力：三重循环
        threeSumOne(ints);
        //hash：两重暴力+hash

        //夹逼：因为不需要下标，可以排序后夹逼
    }


    public static List<List<Integer>> threeSumOne(int[] nums) {
        //暴力法，三重循环 结果集使用了set集合，避免了返回值重复
        Set<List<Integer>> list= new HashSet<>();

        if (nums.length<3){
            return new ArrayList<>(list);
        }

        Arrays.sort(nums);
        for (int i = 0; i < nums.length-2; i++) {
            for (int j = i+1; j < nums.length-1; j++) {
                for (int k = j+1; k < nums.length; k++) {
                    if (nums[i]+nums[j]+nums[k]==0){
                        List<Integer> integerList= new ArrayList<>();
                        integerList.add(nums[i]);
                        integerList.add(nums[j]);
                        integerList.add(nums[k]);
                        list.add(integerList);
                    }
                }
            }
        }
        return new ArrayList<>(list);
    }

    public static int[] twoSum(int[] nums, int target) {
        if (nums.length<=1){
            return  new int[]{0,0};
        }

        int j = 0;
        int k = 0;

        for (int i = 0; i < nums.length-1; i++) {
            for (int l = i+1; l < nums.length; l++) {
                if (nums[i]+nums[l]==target){
                    j = i;
                    k = l;
                }
            }

        }

        return new int[]{j,k};
    }

    //假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
    //每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
    private static void climbStairs(int n) {
        //1 1
        //2  2
        //3  1+2
        //4  3+2
        //n  (n-1)+(n-2)  斐波那契数列

        climbStairsOne(n);
        climbStairsTwo(n);

    }

    private static int climbStairsTwo(int n) {
        int i ,j = 0,last = 1;
        for (int k = 0; k < n; k++) {
            i = j;
            j = last;
            last = i +j;
        }

        return last;
    }

    private static int climbStairsOne(int n) {
        if (n<=2){
            return n;
        }


        int i = 1;
        int j = 2;
        for (int k = 3; k <= n; k++) {
            int temp = i+j;
            i= j;
            j = temp;
        }

        return j;
    }

    //给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0) 。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
    private static void maxArea(int[] nums) {
        //1、暴力法,双层循环，求出面积
        maxAreaOne(nums);
        //2、左右边界向中间收缩
        maxAreaTwo(nums);
        maxAreaThree(nums);

    }

    private static int maxAreaThree(int[] nums) {
        int i = 0; int j = nums.length-1;int max = 0;
        while (i<j){
            //1、如果i<j , 当前最大值就是 j-i 乘以 i  反之，就是j-i 乘以 j
            max = nums[i]<nums[j]?Math.max(max,(j-i)*nums[i++]):Math.max(max,(j-i)*nums[j--]);
        }

        return max;
    }
    private static int maxAreaTwo(int[] nums) {
        int max = 0;
        for (int i = 0, j = nums.length-1;i<j;) {
            int minHeight = nums[i]<nums[j]?nums[i++]:nums[j--];
            int aera = (j-i+1)*minHeight;
            max = Math.max(max,aera);
        }

        return max;
    }

    private static int maxAreaOne(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length-1; i++) {
            for (int j = i+1; j < nums.length; j++) {
                int aera = (j-i)*Math.min(nums[i],nums[j]);
                max = Math.max(aera,max);
            }
        }

        return max;
    }


    //给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
    private static void moveZeroes(int[] nums) {
        //1、遍历元素，遇到不为0的，和前一个元素交换位置
        moveZeroesOne(nums);
       //2、定义一个初始指针，遇到元素不是0的情况，赋值指针位置，指针+1，直到为0，遍历指针后面的元素，全部置为0
        moveZeroesTwo(nums);
        //3、索引index
        moveZeroesThree(nums);
    }

    private static void moveZeroesThree(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]==0){
                j++;
            }else if (j!=0){
                nums[i-j] = nums[i];
                nums[i]=0 ;
            }
        }
    }

    private static void moveZeroesTwo(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]!= 0){
                nums[j] = nums[i];
                j++;
            }
        }

        for (int i = j; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    private static void moveZeroesOne(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]!= 0){
                int temp = nums[i];
                nums [i] = nums[j];
                nums[j] = temp;

                j++;
            }
        }
    }
}
