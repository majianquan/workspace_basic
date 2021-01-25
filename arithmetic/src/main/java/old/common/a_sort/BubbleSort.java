package old.common.a_sort;

import java.util.Arrays;

/**
 * 冒泡排序
 */
public class BubbleSort {
    public static void main(String[] args) {
        int arr[] = {3,9,-1,10,20};
        bubbleSort(arr);
    }

    private static void bubbleSort(int[] arr) {
        boolean flag = false;
        for (int i = 0; i < arr.length; i++) {
            // 优化1: 前面已经排序过的最大值是不用再次循环排序的,所以arr.length -i - 1;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if(arr[j] > arr[j + 1]) {
                    flag = true;
                    swap(j,j+1,arr);
                }
            }
            System.out.println("第" + (i+ 1) + "趟之后的数组");
            System.out.println(Arrays.toString(arr));
            // 优化2: 如果一趟都没有交换过,说明已经排序成功,后面的已经不用排序了
            if(!flag) {
                break;
            } else {
                flag = false;
            }
        }
    }


    private static void swap(int i, int j, int[] arr) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
