package algorithm;

/**
 * @author xulin
 * @date 2020/4/27 10:51
 * <p>冒泡排序</p>
 */
public class BubblingSort {
    /**
     * @author xulin
     * @date 2020/4/27 11:05
     * <p>外循环遍历数组中的每一个元素</p>
     * <p>内循环遍历</p>
     * <p>每次冒泡 得到一个最大值放在最后面</p>
     */
    private static void sort(Integer[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j + 1] < arr[j]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        Integer[] arr = {5, 4, 7, 2, 9, 8};
        sort(arr);
        for (Integer i : arr) {
            System.out.println(i);
        }
    }
}
