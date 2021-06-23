package algorithm.base;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description: 归并排序
 * @Author: yuzhengshu
 * @Date: 2021年6月15日 17:40
 */
public class MergeSort {
    public List<Integer> mergeSort(List<Integer> list) {
        if (list.size() == 1) {
            return list;
        }
        int left = 0, right = list.size();
        int mid = (left + right) / 2;
        List<Integer> list1 = list.subList(0, mid);
        List<Integer> list2 = list.subList(mid, right);
        return merge(mergeSort(list1), mergeSort(list2));
    }

    public List<Integer> merge(List<Integer> list1, List<Integer> list2) {
        int point1 = 0;
        int point2 = 0;
        List<Integer> res = new ArrayList<>(list1.size() + list2.size());
        while (point1 < list1.size() && point2 < list2.size()) {
            Integer item1 = list1.get(point1);
            Integer item2 = list2.get(point2);
            if (item1 < item2) {
                res.add(item1);
                point1++;
            } else {
                res.add(item2);
                point2++;
            }
        }
        if (point1 == list1.size()) {
            for (int i = point2; i < list2.size(); i++) {
                res.add(list2.get(i));
            }
        } else {
            for (int i = point1; i < list1.size(); i++) {
                res.add(list1.get(i));
            }
        }
        return res;
    }

    int[] tmp;

    public int[] sortArray(int[] nums) {
        tmp = new int[nums.length];
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }

    public void mergeSort(int[] nums, int l, int r) {
        if (l >= r) {
            return;
        }
        int mid = (l + r) >> 1;
        mergeSort(nums, l, mid);
        mergeSort(nums, mid + 1, r);
        int i = l, j = mid + 1;
        int cnt = 0;
        while (i <= mid && j <= r) {
            if (nums[i] <= nums[j]) {
                tmp[cnt++] = nums[i++];
            } else {
                tmp[cnt++] = nums[j++];
            }
        }
        while (i <= mid) {
            tmp[cnt++] = nums[i++];
        }
        while (j <= r) {
            tmp[cnt++] = nums[j++];
        }
        for (int k = 0; k < r - l + 1; ++k) {
            nums[k + l] = tmp[k];
        }
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 4, 5, 6, 3);
        System.out.println(new MergeSort().mergeSort(list));
    }
}
