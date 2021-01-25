package old.common.sort.bubble.demo;


import java.util.Arrays;

public class Demo1 {
    public static void main(String[] args) {
        Integer[] arr = {2, 5, 1, 3, 4};
        Demo1.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void sort(Integer[] arr) {
        // 第一趟排序
        if(arr[0] > arr[1]) {
            swap(arr, 0, 1);
        }
        if(arr[1] > arr[2]) {
            swap(arr, 1, 2);
        }
        if(arr[2] > arr[3]) {
            swap(arr, 2, 3);
        }
        if(arr[3] > arr[4]) {
            swap(arr, 3, 4);
        }
        // 第二趟排序
        if(arr[0] > arr[1]) {
            swap(arr, 0, 1);
        }
        if(arr[1] > arr[2]) {
            swap(arr, 1, 2);
        }
        if(arr[2] > arr[3]) {
            swap(arr, 2, 3);
        }
        if(arr[3] > arr[4]) {
            swap(arr, 3, 4);
        }
    }
    private static void swap(Integer[] arr, int src, int des) {
        Integer temp = arr[src];
        arr[src] = arr[des];
        arr[des] = temp;
    }
}
