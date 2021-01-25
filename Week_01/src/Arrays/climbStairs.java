package Arrays;

/**
 * 70. 爬楼梯
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * 注意：给定 n 是一个正整数。
 */
public class climbStairs {
    public static void main(String[] args) {
        /**
         * f1 = 1
         * f2 = 2
         * f3 = f1+ff2;
         * ...
         * fn = f(n-1)+f(n-2)
         */
        climbStairsOne(5);
        //斐波那契数列解法
        climbStairsTwo(5);
    }

    private static int climbStairsTwo(int n) {
        double sqrt_5 = Math.sqrt(5);
        double fib_n = Math.pow((1 + sqrt_5) / 2, n + 1) - Math.pow((1 - sqrt_5) / 2,n + 1);
        return (int)(fib_n / sqrt_5);
    }

    private static int climbStairsOne(int n) {
        int j  =0,k = 0 ,last = 1;
        for (int i = 0; i < n; i++) {
            j = k;
            k = last;
            last = j+k;
        }

        return last;
    }
}
