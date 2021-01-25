package old.common.a_sort;

import java.util.Arrays;

/**
 * 选择排序
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] arr = {3,9,-1,20,10};
        selectSort(arr);
    }

    private static void selectSort(int[] arr) {
        for (int j = 0; j < arr.length -1; j++) {
            // 第一轮排序
            int minIndex = j;
            for (int i = minIndex + 1; i < arr.length; i++) {
                if(arr[minIndex] > arr[i]) {
                    minIndex = i;
                }
            }
            if(minIndex != j) {
                swap(minIndex, j, arr);
            }
            System.out.println("第"+(j+1)+"轮交换结果");
            System.out.println(Arrays.toString(arr));
        }
    }

    /**
     * 选择排序推导过程
     * @param arr
     */
    private static void selectSort1(int[] arr) {
        // 第一轮排序
        int minIndex = 0;
        for (int i = minIndex + 1; i < arr.length; i++) {
            if(arr[minIndex] > arr[i]) {
                minIndex = i;
            }
        }
        if(minIndex != 0) {
            swap(minIndex, 0, arr);
        }
        System.out.println("第1轮交换结果");
        System.out.println(Arrays.toString(arr));
        // 第2轮排序
        minIndex = 1;
        for (int i = minIndex + 1; i < arr.length; i++) {
            if(arr[minIndex] > arr[i]) {
                minIndex = i;
            }
        }
        swap(minIndex, 1, arr);
        System.out.println("第2轮交换结果");
        System.out.println(Arrays.toString(arr));
        // 第3轮排序
        minIndex = 2;
        for (int i = minIndex + 1; i < arr.length; i++) {
            if(arr[minIndex] > arr[i]) {
                minIndex = i;
            }
        }
        swap(minIndex, 2, arr);
        System.out.println("第3轮交换结果");
        System.out.println(Arrays.toString(arr));
        // 第4轮排序
        minIndex = 3;
        for (int i = minIndex + 1; i < arr.length; i++) {
            if(arr[minIndex] > arr[i]) {
                minIndex = i;
            }
        }
        swap(minIndex, 3, arr);
        System.out.println("第4轮交换结果");
        System.out.println(Arrays.toString(arr));
    }
    private static void swap(int i,int j,int[] arr) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
