package DFSorBFS;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 200. 岛屿数量
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 *
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 *
 * 此外，你可以假设该网格的四条边均被水包围。
 */
public class numIslands {


    //广度优先BFS方法
    public int numIslands(char[][] grid) {
        int count = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == '1'){
                    bfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private void bfs(char[][] grid, int i, int j) {
        Queue<int []> queue = new LinkedList<>();
        queue.add(new int[]{i,j});
        while (!queue.isEmpty()){
            int[] remove = queue.remove();
            i = remove[0];
            j = remove[1];

            if (0 <= i && i < grid.length && 0 <= j && j < grid[0].length && grid[i][j] == '1'){
                grid[i][j] = '0';
                queue.add(new int[] { i + 1, j });
                queue.add(new int[] { i - 1, j });
                queue.add(new int[] { i, j + 1 });
                queue.add(new int[] { i, j - 1 });
            }
        }
    }


    private int n;
    private int m;

    //DFS一排一排的遍历，遇到1的元素，计数加1，把这个元素变为0 ，并且把这个元素相邻的元素都变成0
    public int numIslandsOne(char[][] grid) {
        //检查数组，获取数组宽的长度和高的长度
        int count = 0;
        n = grid.length;
        if (n ==0){
            return 0;
        }
        m = grid[0].length;
        //循环遍历数组所有元素
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                //发现陆地，count数+1，递归消除所有和陆地相连的1，都变成0
                if (grid[i][j]=='1'){
                    _DFSOneToZero(grid,i,j);
                    count++;
                }
            }
        }
        return count;
    }

    private void _DFSOneToZero(char[][] grid, int i, int j) {
        if (i<0 || j < 0 || i>=n || j>= m || grid[i][j]!= '1'){
            return;
        }

        //把陆地变成海洋
        grid[i][j] = '0';
        _DFSOneToZero(grid,i+1,j);
        _DFSOneToZero(grid,i-1,j);
        _DFSOneToZero(grid,i,j+1);
        _DFSOneToZero(grid,i,j-1);
    }
}
