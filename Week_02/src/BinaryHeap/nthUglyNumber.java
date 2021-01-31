package BinaryHeap;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 剑指 Offer 49. 丑数
 * 我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。
 */
public class nthUglyNumber {
    public static void main(String[] args) {
        //动态规划
        nthUglyNumberOne(10);
        //堆
        nthUglyNumberTwo(10);
    }

    //任何丑数乘以2、3、5，其结果也是丑数（证明略），我们可以利用小根堆，然后1作为第一个丑数，每次从小根堆弹出最小的丑数，
    // 然后记录已弹出丑数的个数，如果count>=n,返回当前弹出的元素，否则继续乘以2、3、5，（注意：放入堆里的元素需要排除重复值）。
    private static int nthUglyNumberTwo(int n) {
        int[] temp = {2, 3, 5};
        //创建小根堆，每次出堆的都是最小值
        Queue<Long> queue = new PriorityQueue<>();
        queue.add(1L);

        //记录出堆的个数，出堆元素按照从小到大排序
        int count = 0;
        while (!queue.isEmpty()) {
            long cut = queue.poll();

            //如果出堆的个数》=n.当前cut就是第n个丑数
            if (++count >= n) {
                return (int) cut;
            }

            for (int num : temp) {
                //排除重复元素
                if (!queue.contains(num * cut)) {
                    queue.add(num * cut);
                }
            }
        }
        return -1;
    }

    // 1.我们将前面求得的丑数记录下来，后面的丑数就是前面的丑数*2，*3，*5
    // 2.但是问题来了，我怎么确定已知前面k-1个丑数，我怎么确定第k个丑数呢
    // 3.采取用三个指针的方法，p2,p3,p5
    // 4.index2指向的数字下一次永远*2，p3指向的数字下一次永远*3，p5指向的数字永远*5
    // 5.我们从2*p2 3*p3 5*p5选取最小的一个数字，作为第k个丑数
    // 6.如果第K个丑数==2*p2，也就是说前面0-p2个丑数*2不可能产生比第K个丑数更大的丑数了，所以p2++
    // 7.p3,p5同理
    // 8.返回第n个丑数
    public static int nthUglyNumberOne(int n) {
        //初始化三个指针
        int a = 0, b = 0, c = 0;
        int[] dp = new int[n];
        dp[0] = 1;

        for (int i = 1; i < n; i++) {
            int n2 = dp[a] * 2, n3 = dp[b] * 3, n5 = dp[c] * 5;
            dp[i] = Math.min(Math.min(n2, n3), n5);
            if (dp[i] == n2) a++;
            if (dp[i] == n3) b++;
            if (dp[i] == n5) c++;
        }

        return dp[n - 1];
    }
}
