package recursion;

/**
 * 70. 爬楼梯
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 */
public class recursionDemo {

    public static void main(String[] args) {
        //因为f(n) = f（n-1）+f（n-2）,循环执行
        climbStairsOne(4);
        //动态规划，创建一个长度为n+1的数组，使用斐波那契思路
        climbStairsTwo(4);
        //递归
        climbStairsThree(4);
        climbStairsFour(4);

    }

    private static int climbStairsFour(int n) {
        return recursionclimbStairsFour(n,1,1);
    }

    private static int recursionclimbStairsFour(int n, int i, int j) {
        if (n<=1){
            return j;
        }
        //n递减，j递加，最后递归到n==1的时候，j就是最大台阶
        return recursionclimbStairsFour(n-1,j,i+j);
    }

    //数值过大的时候，会超时
    public static int climbStairsThree(int n) {
        if (n<=3){
            return n;
        }

        return climbStairsThree(n-1)+climbStairsThree(n-2);
    }




    public static int climbStairsTwo(int n) {
      int [] dp = new int[n+1];
      dp[0] = 1;
      dp[1] = 1;
     // dp[2] = dp[2-1]+dp[2-2];
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i-1]+dp[i-2];
        }

        return dp[n];
    }


    public static int climbStairsOne(int n) {
        int i = 0;
        int j = 0;
        int k = 1;

        for (int l = 0; l < n; l++) {
            i = j;
            j = k;
            k = i+j;
        }

        return k;
    }
}
