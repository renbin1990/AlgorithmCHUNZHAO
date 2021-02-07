package BinarySearch;

/**
 * 69. x 的平方根
 * 实现 int sqrt(int x) 函数。
 *
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 *
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 */
public class mySqrt {

    public static void main(String[] args) {
        System.out.println(mySqrtOne(8));
    }

    //牛顿迭代法
    public int mySqrt(int a) {
        long x = a;
        while (x * x > a) {
            x = (x + a / x) / 2;
        }
        return (int) x;
    }

    /**
     * 使用二分查找，暂时不考虑整数部分，直接带小数部分进行二分查找。注意一点，
     * 最后判断其整数部分，可以二分到left和right的整数部分一致，
     * 这时x的平方根肯定在这两个数之间，这是返回left或者right的整数部分即可。
     * @param x
     * @return
     */
    public static int mySqrtOne(int x) {
        long left = 0 ;
        long right = x;
        long res = -1;
        while (left <= right){
            long mid = (right-left)/2+left;
            if ((mid * mid) <= x){
                res = mid;
                left = mid+1;
            }else if ((mid * mid) > x){
                right = mid-1;
            }
        }
        return (int) res;
    }
}
