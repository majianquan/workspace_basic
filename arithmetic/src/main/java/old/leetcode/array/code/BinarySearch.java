package old.leetcode.array.code;


public class BinarySearch<T extends Comparable<T>> {
    public static void main(String[] args) {
        Integer[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(new BinarySearch<Integer>().binarySearch(arr, arr.length, 5));
    }

    private int binarySearch(T[] arr, int n, T target) {
        int l = 0, r = n - 1;
        while (l <= r) {
            int middle = (r - l ) / 2 + l;
            if(arr[middle].compareTo(target) > 0) {
                r = middle - 1;
            } else if(arr[middle].compareTo(target) < 0) {
                l = middle + 1;
            } else {
                return middle;
            }
        }
        return -1;
    }
}
