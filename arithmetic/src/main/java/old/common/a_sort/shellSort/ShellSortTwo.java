package old.common.a_sort.shellSort;

public class ShellSortTwo {
    public static void sort(Comparable[] arr) {
        int length = arr.length;
        for (int grap = length / 2; grap > 0; grap /= 2) {
            for (int i = grap; i < length; i++) {
                int j = i - grap;
                while (j >=0 && arr[j].compareTo(arr[j + grap]) > 0) {
                    swap(arr,j,j+grap);
                    j-=grap;
                }
            }
        }
    }

    private static void swap(Comparable[] arr, int i, int j) {
        Comparable temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
