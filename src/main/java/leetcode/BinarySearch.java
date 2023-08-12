package leetcode;

/**
 * @author: Alan
 * @since: 2023/3/30 20:25
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = new int[]{7};
        System.out.println(upper(arr, 3));
        System.out.println(lower(arr, 3));
    }

    private static int upper(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] <= target) {
                left = mid + 1;
            } else if (arr[mid] > target) {
                right = mid;
            }
        }
        if (left > 1 && arr[left - 1] == target) {
            return left - 1;
        }
        return -1;
    }

    // 找出第一个等于的值
    private static int lower(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] < target) {
                left = mid + 1;
            } else if (arr[mid] >= target) {
                right = mid;
            }
        }
        if (arr[left] == target) {
            return left;
        }
        return -1;
    }
}
