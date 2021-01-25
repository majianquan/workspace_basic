package old.common.a_sort;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {-9, 78, 0, 23, -567, 70, -1, 900, 4561};
        quickSort(arr,0,arr.length);
    }

    private static void quickSort(int[] arr,int left,int right) {
        int l = left;
        int r = right;
        int temp = 0; // 交换临时变量
        // 中间的值
        int pivot = arr[(left + right) / 2];
        //让比pivot值小放到左边
        // 比pivot值大的放到右边
        while (l < r) {
            //  从pivot的左边一直找,找到大于等于pivot值
            while (arr[l] < pivot) {
                l++;
            }
            //  从pivot的右边一直找,找到小于等于pivot值
            while (arr[r] > pivot) {
                r--;
            }
            // 如果 l> r说明pivot的左右两边的值,已经符合左小右大的规则
            if (l >= r) {
                break;
            }
            // 交互
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
        }

    }
}
