import java.util.*;

/**
 * 快速排序（Quick Sort）：Unstable Sort
 * 
 * 快速排序（QuickSort）是一种基于比较的排序算法，它使用分治法来进行排序。
 * 快速排序的时间复杂度和空间复杂度如下所示：
 * 
 * 1. 时间复杂度：
 * - 快速排序的时间复杂度为 O(nlogn)。
 * 
 * 2. 空间复杂度：
 * - 快速排序的空间复杂度为 O(logn)。
 */
public class QuickSort {
    public static void quickSort(int[] arr) {
        int n = arr.length;
        quickSortHelper(arr, 0, n - 1);
    }

    private static void quickSortHelper(int[] arr, int low, int high) {
        if (low < high) {
            // 将数组分区，并获取分区点的索引
            int partitionIndex = partition(arr, low, high);
            // 对分区点左边的子数组进行递归快速排序
            quickSortHelper(arr, low, partitionIndex - 1);
            // 对分区点右边的子数组进行递归快速排序
            quickSortHelper(arr, partitionIndex + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        // 选择最后一个元素作为分区点
        int pivot = arr[high];
        // 将小于分区点的元素移到左边，大于分区点的元素移到右边
        int i = low - 1;
        for (int j = low; j < high; j++) {
            // 如果当前元素小于分区点
            if (arr[j] < pivot) {
                // 将当前元素与小于分区点的元素的下一个元素交换
                i++;
                swap(arr, i, j);
            }
        }
        // 将分区点放置在正确的位置
        swap(arr, i + 1, high);
        // 返回分区点的索引
        return i + 1;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = { 64, 34, 25, 12, 22, 11, 90 };

        System.out.println("原始数组:");
        System.out.println(Arrays.toString(arr));

        quickSort(arr);

        System.out.println("\n排序后数组:");
        System.out.println(Arrays.toString(arr));
    }

}
