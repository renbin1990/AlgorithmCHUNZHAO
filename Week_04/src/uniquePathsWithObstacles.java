/**
 * 63. 不同路径 II
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 *
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 */
public class uniquePathsWithObstacles {
    public static void main(String[] args) {

    }

    public int uniquePathsWithObstaclesTwo(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int [][] dp = new int[m+1][n+1];
        // 第一行 和 其他行的区别在于没有来自上边的路径 但是 起点到起点 算一条路径 所以这样初始化
        dp[0][1] = 1;
        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                if(obstacleGrid[i-1][j-1] == 1) {
                    // 障碍 不可达 路径数量为0
                    dp[i][j] = 0;
                }
                else {
                    // 左 + 上
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }
        return dp[m][n];
    }



    public int uniquePathsWithObstaclesOne(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int [] dp = new int[n+1];
        dp[1] = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 1; j <= n; j++) {
                if (obstacleGrid[i][j-1] == 1){
                    //障碍物
                    dp[j] = 0;
                }else {
                    dp[j] = dp[j] + dp[j-1];
                }
            }
        }
        return dp[n];
    }
}
