package algorithm;

import java.util.Arrays;

/**
 * @author xulin
 * @date 2020/4/29 10:08
 * 希尔排序（缩小增量排序）
 */
public class ShellSort {

    public static void shellSort(Integer[] arr) {
        //增量gap，并逐步缩小增量
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            //从第gap个元素，逐个对其所在组进行直接插入排序操作
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                int temp = arr[j];
                if (arr[j] < arr[j - gap]) {
                    while (j - gap >= 0 && temp < arr[j - gap]) {
                        //移动法
                        arr[j] = arr[j - gap];
                        j -= gap;
                    }
                    arr[j] = temp;
                }
            }
            System.out.println("排序的结果是" + Arrays.asList(arr));
        }
    }

    public static void main(String[] args) {
        Integer[] arr = {8, 4, 9, 3, 5, 6, 1};
        shellSort(arr);
    }
}
