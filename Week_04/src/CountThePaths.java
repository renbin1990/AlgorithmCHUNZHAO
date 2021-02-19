/**
 * 路径计数
 */
public class CountThePaths {

    /**
     * opt[i,j] = opt[i,j+1] + opt[i+1,j]
     * 完整逻辑
     * if a[i,j] = "空地'
     *      opt[i,j] = opt[i,j+1] + opt[i+1,j]
     * eles
     *      opt[i,j] = 0
     */
   public int  countthepaths(Boolean [][] grid,int row,int col){
//
//       if (!grid[row][col]){
//            return 0;
//       }

       return countthepaths(grid,row+1,col)+countthepaths(grid,row,col+1);
   }
}
