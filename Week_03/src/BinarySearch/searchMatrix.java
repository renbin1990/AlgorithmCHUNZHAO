package BinarySearch;

/**
 * 74. 搜索二维矩阵
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 * <p>
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 */
public class searchMatrix {
    //二分法
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) {
            return false;
        }
        //行数
        int row = matrix.length;
        //列数
        int col = matrix[0].length;
        int left = 0;
        //行数乘列数 - 1，右指针
        int right = row * col - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            //将一维坐标变为二维坐标
            int rownum = mid / col;
            int colnum = mid % col;
            if (matrix[rownum][colnum] == target) {
                return true;
            } else if (matrix[rownum][colnum] > target) {
                right = mid - 1;
            } else if (matrix[rownum][colnum] < target) {
                left = mid + 1;
            }
        }
        return false;
    }


    //暴力法 双层循环
    public boolean searchMatrixOne(int[][] matrix, int target) {
        int[] matrixW = matrix[0];
        if (matrix.length == 0 || matrixW.length == 0) {
            return false;
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrixW.length; j++) {
                if (matrix[i][j] == target) {
                    return true;
                } else if (matrix[i][j] > target) {
                    return false;
                }
            }
        }

        return false;
    }
}
