import java.util.*;


public class InsertionSort {
    public static void insertionSort(int[] arr) {
        int n = arr.length;

        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;

            // 将比 key 大的元素向右移动
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }

            // 将 key 插入到正确的位置
            arr[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        int[] arr = { 64, 34, 25, 12, 22, 11, 90 };

        System.out.println("原始数组:");
        System.out.println(Arrays.toString(arr));

        insertionSort(arr);

        System.out.println("\n排序后数组:");
        System.out.println(Arrays.toString(arr));
    }
}
