package old.common.sort.bubble;


import common.utils.SortTestHelper;

public class Main {
    public static void main(String[] args) {
        Integer[] arr = {10,9,8,7,6,5,4,3,2,1};
        new BubbleSort().sort(arr);
        SortTestHelper.printArray(arr);
    }
}
