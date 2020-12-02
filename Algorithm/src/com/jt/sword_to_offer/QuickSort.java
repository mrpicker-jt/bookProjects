package com.jt.sword_to_offer;

import com.jt.util.PrintUtil;

/**
 * @program: Algorithm
 * @description: 快速排序
 * @author: Mrpicker
 * @create: 2020-12-02 14:39
 **/
public class QuickSort {
    public static void main(String[] args) {
        int[] test = {3, 4, 5, 1, 2, 3, 1, 8, 6, 7, -1, 2};
        PrintUtil.printIntArray(test);
        quickSort(test, test.length, 0, test.length - 1);
        PrintUtil.printIntArray(test);
    }

    public static void quickSort(int data[]) {
        quickSort(data, data.length, 0, data.length - 1);
    }

    private static void quickSort(int data[], int length, int start, int end) {
        if (start == end) {
            return;
        }
        int index = partitionExchange(data, length, start, end);
        if (index > start) {
            quickSort(data, length, start, index - 1);
        }
        if (index < end) {
            quickSort(data, length, index + 1, end);
        }
    }

    private static int partitionExchange(int data[], int length, int start, int end) {
        int index = (int) (Math.random() * (end - start)) + start;
        swap(data, index, end);
        int small = start - 1;
        for (index = start; index < end; index++) {
            if (data[index] < data[end]) {
                ++small;
                if (small != index) {
                    swap(data, index, small);
                }
            }
        }
        ++small;
        swap(data, small, end);
        return small;
    }

    private static void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
