package old.common.binarySearchNoRec;

/**
 * 二分查找算法,非递归实现
 */
public class BinarySearchNoRec {
	public static void main(String[] args) {
		// 数组 {1,3, 8, 10, 11, 67, 100}, 编程实现二分查找， 要求使用非递归的方式完成.
		int[] arr = {1, 3, 8, 10, 11, 67, 100};
		System.out.println(binarySearch(arr,1));
	}
	public static int binarySearch(int[] arr, int target) {
		int left = 0;
		int right = arr.length - 1;
		while (left <= right) { // 说明可以继续查找
			int mid = (left + right) / 2;
			if(arr[mid] == target) {
				return mid;
			} else if(arr[mid] > target) {
				right = mid - 1; // 向左查找
			} else {
				left = mid + 1; // 向右查找
			}
		}
		return -1;
	}
}
