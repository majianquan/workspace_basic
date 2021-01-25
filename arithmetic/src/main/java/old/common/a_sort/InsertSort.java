package old.common.a_sort;

import java.util.Arrays;

public class InsertSort {
    public static void main(String[] args) {
        int arr[] = {3,9,-1,20,10};
        insertSort(arr);
    }

    private static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int tempIndex = i;
            int tempValue = arr[i];
            int insertIndex = tempIndex -1;
            while (insertIndex >=0 && tempValue < arr[insertIndex]) {
                // 前一个值赋给后一个值
                arr[insertIndex+1] = arr[insertIndex];
                // 然后要插入的值的位置往前移动
                insertIndex--;
            }
            // 如果上述都不符合了,说明不用往前比较了,只能插入当前的位置
            arr[insertIndex+1] = tempValue;
            System.out.println("第" + i + "次排序");
            System.out.println(Arrays.toString(arr));
        }
    }

    /**
     * 插入推导排序思想
     * @param arr
     */
    private static void insertSort1(int[] arr) {
        // 第一次排序
        int tempIndex = 1;
        int insertValue = arr[tempIndex];
        int insertIndex = tempIndex - 1;
        while (insertIndex >= 0 && arr[tempIndex] < arr[insertIndex]) {
            arr[insertIndex + 1] = arr[insertIndex];
            insertIndex--;
        }
        arr[insertIndex + 1] = insertValue;
        System.out.println("第" + tempIndex + "次排序");
        System.out.println(Arrays.toString(arr));

        // 第2次排序 [3, 9, -1, 20, 10]
        tempIndex = 2;
        insertValue = arr[tempIndex];
        insertIndex = tempIndex - 1;
        while (insertIndex >= 0 && insertValue < arr[insertIndex]) {
            arr[insertIndex + 1] = arr[insertIndex];
            insertIndex--;
        }
        arr[insertIndex + 1] = insertValue;
        System.out.println("第" + tempIndex + "次排序");
        System.out.println(Arrays.toString(arr));
        // 第3次排序 [3, 9, -1, 20, 10]
        tempIndex = 3;
        insertValue = arr[tempIndex];
        insertIndex = tempIndex - 1;
        while (insertIndex >= 0 && insertValue < arr[insertIndex]) {
            arr[insertIndex + 1] = arr[insertIndex];
            insertIndex--;
        }
        arr[insertIndex + 1] = insertValue;
        System.out.println("第" + tempIndex + "次排序");
        System.out.println(Arrays.toString(arr));
        // 第4次排序 [3, 9, -1, 10, 20]
        tempIndex = 4;
        insertValue = arr[tempIndex];
        insertIndex = tempIndex - 1;
        while (insertIndex >= 0 && insertValue < arr[insertIndex]) {
            arr[insertIndex + 1] = arr[insertIndex];
            insertIndex--;
        }
        arr[insertIndex + 1] = insertValue;
        System.out.println("第" + tempIndex + "次排序");
        System.out.println(Arrays.toString(arr));
    }
}
