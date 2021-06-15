package algorithmTwo;

/**
 * @description: 852. 山脉数组的峰顶索引
 * @Author: yuzhengshu
 * @Date: 2021年6月15日 10:05
 */
public class Solution5 {
    public static int peakIndexInMountainArray(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return i;
            }
        }
        return arr.length - 1;
    }

    public static int peakIndexInMountainArray1(int[] arr) {
        int idxMid = 0, start = 0, end = arr.length - 1;
        while (start != end) {
            idxMid = (start + end) / 2;
            if (arr[idxMid] > arr[idxMid + 1] && arr[idxMid] >= arr[idxMid - 1]) {
                return idxMid;
            }
            if (arr[idxMid - 1] > arr[idxMid]) {
                end = idxMid;
            } else {
                start = idxMid;
            }
        }
        return idxMid;
    }

    public int peakIndexInMountainArray2(int[] arr) {
        int n = arr.length;
        int left = 1, right = n - 2, ans = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] > arr[mid + 1]) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        int[] arr = {40, 48, 61, 75, 100, 99, 98, 39, 30, 10};
        System.out.println(peakIndexInMountainArray(arr));
        System.out.println(peakIndexInMountainArray1(arr));
    }
}
