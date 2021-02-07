package GreedyAlgorithm;

import java.util.Arrays;

/**
 * 455. 分发饼干
 * 假设你是一位很棒的家长，想要给你的孩子们一些小饼干。但是，每个孩子最多只能给一块饼干。
 *
 * 对每个孩子 i，都有一个胃口值 g[i]，这是能让孩子们满足胃口的饼干的最小尺寸；并且每块饼干 j，
 * 都有一个尺寸 s[j] 。如果 s[j] >= g[i]，我们可以将这个饼干 j 分配给孩子 i ，这个孩子会得到满足。你的目标是尽可能满足越多数量的孩子，并输出这个最大数值。
 */
public class findContentChildren {

    public static void main(String[] args) {

    }

    /**
     * 排序，每个索引正对的就是刚好满足胃口的
     * @param g
     * @param s
     * @return
     */
    public int findContentChildren(int[] g, int[] s) {
        int res = 0;
        if (s.length==0){
            return res;
        }

        Arrays.sort(g);
        Arrays.sort(s);

        int length_g = g.length;
        int length_s = s.length;

        int i= 0;
        int j =0;

        while (i < length_g && j < length_s){
            if (g[i] <= s[j]){
                //可以满足小朋友
                res++;
                i++;
                j++;
            }else {
                //不满足需求 查看下一块饼干
                j++;
            }
        }

        return res;
    }
}
