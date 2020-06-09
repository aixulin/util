package algorithm;

import java.util.Arrays;

/**
 * @author xulin
 * @create at 2020/6/9 9:44 上午
 */
public class QuickSort {
    public static Integer[] quickSort(Integer[] arr, int start, int end) {
        int pivot = arr[start];
        int i = start;
        int j = end;
        while (i < j) {
            while ((i < j) && (arr[j] > pivot)) {
                j--;
            }
            while ((i < j) && (arr[i] < pivot)) {
                i++;
            }
            if ((arr[i].equals(arr[j])) && (i < j)) {
                i++;
            } else {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        System.out.println(Arrays.asList(arr));
        if (i - 1 > start) arr = quickSort(arr, start, i - 1);
        if (j + 1 < end) arr = quickSort(arr, j + 1, end);
        return (arr);
    }

    public static void main(String[] args) {
        Integer[] arr = {8, 4, 9, 3, 5, 6, 1};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.asList(arr));
    }
}
