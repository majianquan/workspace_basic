package old.common.a_sort.shellSort;

import common.a_sort.SortTestHelper;

public class Main {
    public static void main(String[] args) {
//        test();
        test1();
    }

    private static void test() {
        Integer[] arr = {2,4,1,6,8,5,9,3,7};
        ShellSort.sort(arr);
        SortTestHelper.printArray(arr);
    }

    private static void test1() {
        Integer[] arr = {2,4,1,6,8,5,9,3,7};
        ShellSortTwo.sort(arr);
        SortTestHelper.printArray(arr);
    }
}
