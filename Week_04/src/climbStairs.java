/**
 * 70. 爬楼梯
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * 注意：给定 n 是一个正整数。
 */
public class climbStairs {

    public int climbStairsTwo(int n) {
       int [] dp = new int[n+1];
       dp[0] = 1;
       dp[1] = 1;

        for (int i = 2; i <=n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }

    public int climbStairs(int n) {
        return n<=2? n : climbStairs(n-1)+climbStairs(n-2);
    }

    public int climbStairsOne(int n) {
        return recursionclimbStairsFour(n,1,1);
    }

    private static int recursionclimbStairsFour(int n, int i, int j) {
        if (n<=1){
            return j;
        }
        return recursionclimbStairsFour(n-1,j,i+j);
    }
}
