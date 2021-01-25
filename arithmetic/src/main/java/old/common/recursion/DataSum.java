package old.common.recursion;

// 使用递归的方式进行数组求和
public class DataSum {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int result = sum(arr);
        System.out.println(result);
    }

    private static int sum(int[] arr) {
        return sum(arr,0);
    }
    // 计算arr[l...n]这个区间内所有数字的和
    private static int sum(int[] arr,int i) {
        if(i == arr.length) {
            return 0;
        }
        return arr[i] + sum(arr,i+1);
    }
}
