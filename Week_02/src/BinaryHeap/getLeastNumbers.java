package BinaryHeap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 剑指 Offer 40. 最小的k个数
 * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 */
public class getLeastNumbers {
    public static void main(String[] args) {
        //排序
        getLeastNumbersOne(new int[]{},3);
        //堆
        getLeastNumberstwo(new int[]{},3);
        getLeastNumbersthree(new int[]{},3);
    }

    public static int[] getLeastNumbersthree(int[] arr, int k) {
        int [] res = new int[k];

        if (k == 0) { // 排除 0 的情况
            return res;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });

        for (int i = 0; i < k; ++i) {
            queue.offer(arr[i]);
        }

        for (int i = k; i <arr.length;++i){
            if (queue.peek()>arr[i]){
                queue.poll();
                queue.offer(arr[i]);
            }
        }

        for (int i = 0; i < k; i++) {
            res[i] = queue.poll();
        }

        return res;
    }


    public static int[] getLeastNumberstwo(int[] arr, int k) {
        int [] res = new int[k];
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i:arr){
            queue.add(i);
        }

        for (int i = 0; i < k; i++) {
            res[i] = queue.poll();
        }

        return res;
    }


    public static int[] getLeastNumbersOne(int[] arr, int k) {
        int [] res = new int[k];
        Arrays.sort(arr);

        for (int i = 0; i < k; i++) {
            res[i] = arr[i];
        }

        return res;
    }
}
