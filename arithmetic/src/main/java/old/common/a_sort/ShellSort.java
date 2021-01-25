package old.common.a_sort;

import java.util.Arrays;

/**
 * 希尔排序
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] arr = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
//        shellSort1(arr);
        shellSort(arr);
    }

    private static void shellSort(int[] arr) {
        for (int gap = arr.length / 2; gap > 0 ; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                int j = i - gap;
                while (j>= 0 && arr[j] > arr[j+gap]) {
                    swap(j,j+gap,arr);
                    j -= gap;
                }

            }
            System.out.println("第一轮排序过后");
            System.out.println(Arrays.toString(arr));
        }
    }

    private static void shellSort1(int[] arr) {
        // 第一轮
        // 将10个数据分成了5组
        for (int i = 5; i < arr.length; i++) {
            // 遍历各组中所有的元素(共5组,每组有2个元素),步长为5
            for (int j = i - 5; j >=0 ; j-=5) {
                if(arr[j] > arr[j+5]) {
                    swap(j,j+5,arr);
                }
            }
        }
        System.out.println("第一轮排序过后");
        System.out.println(Arrays.toString(arr));
        // 第二轮
        for (int i = 2; i < arr.length; i++) {
            for (int j = i - 2; j >=0 ; j-=2) {
                if(arr[j] > arr[j+2]) {
                    swap(j,j+2,arr);
                }
            }
        }
        System.out.println("第二轮排序过后");
        System.out.println(Arrays.toString(arr));
        // 第三轮
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >=0 ; j-=1) {
                if(arr[j] > arr[j+1]) {
                    swap(j,j+1,arr);
                }
            }
        }
        System.out.println("第三轮排序过后");
        System.out.println(Arrays.toString(arr));
    }
    private static void swap(int i, int j, int[] arr) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
