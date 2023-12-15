import java.util.*;

public class SelectionSort {

    public void sort(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            int minIndex = i;
            // 找到剩余数组中最小的值索引后交换
            for (int j = i + 1; j < len; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);
        }
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        SelectionSort sort = new SelectionSort();
        int[] arr = new int[] { 4, 1, 6, 7, 2 };
        sort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
