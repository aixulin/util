package algorithm;

import java.util.Arrays;

/**
 * @author xulin
 * @date 2020/4/27 11:32
 * <p>直接插入排序</p>
 */
public class InsertSort {
    /**
     * @author xulin
     * @date 2020/4/27 13:59
     * <p>直接插入排序</p>
     * <p>每次遍历将指定数字插入到已有的有序集合的顺序位置</p>
     */
    private static void insertSort(Integer[] arr) {
        int temp;
        for (int i = 0; i < arr.length; i++) {
            temp = arr[i];
            for (int j = i; j >= 0; j--) {
                // 从最后位置开始追溯  如果小于 则往前推移 如果大于 直接追加到末尾 （跳出循环）
                if (j > 0 && temp < arr[j - 1]) {
                    arr[j] = arr[j - 1];
                } else {
                    arr[j] = temp;
                    break;
                }
            }
            System.out.println("第" + (i + 1) + "排序的结果是" + Arrays.asList(arr));
        }

    }

    public static void main(String[] args) {
        Integer[] arr = {8, 4, 9, 3, 5, 6, 1};
        insertSort(arr);
    }
}
