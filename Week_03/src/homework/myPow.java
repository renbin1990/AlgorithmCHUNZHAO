package homework;

/**
 * 50. Pow(x, n)
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn）。
 */
public class myPow {

    public double myPow(double x, int n) {
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }

        return _power(x, n);
    }

    private double _power(double x, int n) {
        if (n == 0) {
            return 1;
        }
        double power = _power(x, n / 2);
        //如果是偶数，就两个相乘，如果是奇数，在乘以本质元素
        return n % 2 == 0 ? power * power : power * power * x;
    }
}
