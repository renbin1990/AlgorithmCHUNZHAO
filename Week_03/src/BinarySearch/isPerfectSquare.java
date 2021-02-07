package BinarySearch;

/**
 * 367. 有效的完全平方数
 * 给定一个正整数 num，编写一个函数，如果 num 是一个完全平方数，则返回 True，否则返回 False。
 * <p>
 * 说明：不要使用任何内置的库函数，如  sqrt。
 */
public class isPerfectSquare {

    public static void main(String[] args) {
        System.out.println(isPerfectSquareOne(16));
    }

    //牛顿迭代法
    public boolean isPerfectSquare(int num) {
        if (num < 2) {
            return true;
        }
        long x = num/2;
        while (x * x >num){
            x =(x + num / x) / 2;
        }
        return (x * x)== num;
    }

    //4=1+3 9=1+3+5 16=1+3+5+7以此类推，模仿它可以使用一个while循环，不断减去一个从1开始不断增大的奇数，若最终减成了0，说明是完全平方数，否则，不是
    public boolean isPerfectSquareTwo(int num) {
        int nums = 1;
        while (num > 0){
            num-=nums;
            nums+=2;
        }
        return  num == 0;
    }

    /**
     * 超时，目前原因未知
     * @param num
     * @return
     */
    public static boolean isPerfectSquareOne(int num) {
        if (num < 2) {
            return true;
        }
        int left = 2;
        int right = num/2;
        boolean res = false;

        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (mid * mid == num) {
                res = true;
            } else if (mid * mid < num) {
                //左边界右移
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return res;
    }

}
