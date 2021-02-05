package DivideConquer;

/**
 * 50. Pow(x, n)
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn）。
 */
public class myPow {
    public static void main(String[] args) {
        //暴力法，直接循环求解
        //    System.out.println(myPowOne(2,-2));

        //分治，x^n次方 可以是 x^（n/2）*x^（n/2）
        //偶数  x^n = x^(n/2) * x^(n/2)
        //奇数  x^n = x^(n/2) * x^(n/2)*x

        System.out.println(myPowTwo(2, 5));
    }

    private static double myPowTwo(double x, int n) {
        //如果小于0，就是把x变成小数，n变成正数，求x的n次方
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }

        return power(x, n);
    }

    private static double power(double x, int n) {
        if (n == 0) {
            return 1;
        }
        double power = power(x, n / 2);
        //如果是偶数，就两个相乘，如果是奇数，在乘以本质元素
        return n % 2 == 0 ? (power * power) : (power * power * x);
    }

    public static double myPowOne(double x, int n) {
        if (n == 0) {
            return 1;
        }

        //如果小于0，就是把x变成小数，n变成正数，求x的n次方
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }

        double result = x;
        //因为result是x ,所以循环少乘一次
        for (int i = 0; i < n - 1; i++) {
            result = result * x;
        }

        return result;
    }

}
