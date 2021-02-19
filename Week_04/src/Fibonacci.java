

public class Fibonacci {


    /**
     * 递归是指数级的 时间复杂度 O(2^n)
     * @param n
     * @return
     */
    public static int fib(int n){
//        if (n <= 0){
//            return 0;
//        }else if (n==1){
//            return 1;
//        }else {
//            return fib(n-1)+fib(n-2);
//        }
//
        return n<=1? n : fib(n-1)+fib(n-2);
    }

    /**
     * 优化递归 时间复杂度 O(n)
     * @param n
     * @return
     */
    public static int fibOne(int n ,int [] res){
        if (n <= 1){
            return n;
        }


        if (res[n] == 0){
            res[n] = fibOne(n-1,new int[n])+fibOne(n-2,new int[n]);
        }

        return res[n];
    }

    public static void main(String[] args) {
        System.out.println(fib(6));
        System.out.println(fibOne(6,new int[10]));
    }
}
