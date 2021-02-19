package algorithm.base;

import java.util.ArrayList;

/**
 * @description: 快速排序
 * @Author: yuzhengshu
 * @Date: 2020/12/15 16:47
 */
public class QuickSort {
    public ArrayList<Integer> sort(ArrayList<Integer> inputList) {
        if (inputList.size() <= 1) {
            return inputList;
        }
        int x = inputList.get(0);
        int i = 1;
        int j = inputList.size() - 1;
        ArrayList<Integer> result = null;
        return result;
    }
}

