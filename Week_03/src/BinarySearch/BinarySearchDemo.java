package BinarySearch;

import java.util.Arrays;

public class BinarySearchDemo {

    public static void main(String[] args) {

    }

    public int BinarySearch(int [] arr ,int num){
        //排序
        Arrays.sort(arr);
        //获取最大值,左索引和右索引
        int left  = 0, right = arr.length-1,mid;

        while (left<=right){
            mid = (right - left) / 2 + left;
            if (arr[mid] == num){
                return mid;
                //说明这个数在右面
            }else if (arr[mid] < num){
                left = mid+1;
                //说明这个数在左面
            }else {
                right= mid-1;
            }
        }
        return -1;
    }
}
