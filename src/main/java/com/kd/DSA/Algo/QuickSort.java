package com.kd.DSA.Algo;

import java.util.Random;

public class QuickSort {

    public static void main(String[] arg) {
        int[] array = {1, 5, 7, 8, 2, 4, 0, 9, 18, 15, 14};
        sort(array);
        for (int i : array) {
            System.out.println(i);
        }
        double result = MedianQuickSelect.findMedian(array);
        System.out.println(result);
    }

    public static void sort(int[] array) {
        sort(array, 0, array.length - 1);
    }

    public static void sort(int[] array, int low, int hi) {
        if (hi >= low) {
            int index = findIndex(array, low, hi);
            sort(array, low, index - 1);
            sort(array, index + 1, hi);
        }
    }

    private static int findIndex(int[] array, int low, int hi) {
        int i = low - 1;
        int pivot = array[hi];
        for (int j = low; j < hi; j++) {
            if (array[j] < pivot) {
                i++;
                swap(array, i, j);
            }
        }
        i++;
        swap(array, i, hi);
        return i;
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}

class MedianQuickSelect {

    public static double findMedian(int[] arr) {
        int n = arr.length;
        if (n % 2 == 1) {
            return quickSelect(arr, 0, n - 1, n / 2);
        } else {
            int left = quickSelect(arr.clone(), 0, n - 1, n / 2 - 1);
            int right = quickSelect(arr.clone(), 0, n - 1, n / 2);
            return (left + right) / 2.0;
        }
    }

    private static int quickSelect(int[] arr, int left, int right, int k) {
        if (left == right) return arr[left];

        int pivotIndex = partition(arr, left, right);
        if (k == pivotIndex) return arr[k];
        else if (k < pivotIndex) return quickSelect(arr, left, pivotIndex - 1, k);
        else return quickSelect(arr, pivotIndex + 1, right, k);
    }

    private static int partition(int[] arr, int left, int right) {
        int pivotIndex = new Random().nextInt(right - left + 1) + left;
        int pivot = arr[pivotIndex];
        swap(arr, pivotIndex, right);
        int i = left;

        for (int j = left; j < right; j++) {
            if (arr[j] < pivot) {
                swap(arr, i, j);
                i++;
            }
        }

        swap(arr, i, right);
        return i;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr1 = {7, 1, 3, 5, 2};
        int[] arr2 = {4, 8, 2, 9, 1, 5};
        System.out.println("Median of arr1: " + findMedian(arr1)); // 3
        System.out.println("Median of arr2: " + findMedian(arr2)); // 4.5
    }
}