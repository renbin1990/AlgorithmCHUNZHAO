import java.util.List;

/**
 * 120. 三角形最小路径和
 * 给定一个三角形 triangle ，找出自顶向下的最小路径和。
 *
 * 每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。
 */
public class minimumTotal {

    public int minimumTotal(List<List<Integer>> triangle) {
        //1递归 n层 left or right   O(2^n)
        //2DP
        // a重复性     problem(i,j) = min(sub(i+1,j) ,sub(i,j+1))+a[i,j]
        // b 定义状态方程 f(i,j)
        // c DF方程   f[i,j] = min(f[i+1,j] ,f(i+1,j+1))+a[i,j]

        int [] dp = new int[triangle.size()+1];
        for (int i = triangle.size()-1; i >= 0 ; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                dp[j] = Math.min(dp[j],dp[j+1])+triangle.get(i).get(j);
            }
        }
        return dp[0];
    }
}
