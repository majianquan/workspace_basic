package old.common.a_sort.bubbleSort;


import common.a_sort.SortTestHelper;

public class Main {
    public static void main(String[] args) {
        Integer[] arr = {10,9,8,7,6,5,4,3,2,1};
        BubbleSort.sort(arr);
        SortTestHelper.printArray(arr);
    }
}
