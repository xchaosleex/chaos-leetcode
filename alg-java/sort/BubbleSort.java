import java.util.*;

/**
 * 冒泡排序（Bubble Sort）：Stable Sort
 * 冒泡排序是一种简单的排序算法，它通过比较相邻元素并交换它们的位置来排序。冒泡排序的时间复杂度和空间复杂度如下所示：
 * 
 * 1. 时间复杂度：
 * - 最坏情况下，即待排序的数组是逆序的，需要进行 n-1 轮比较和交换操作，其中 n是待排序数组的长度。
 * 每轮比较需要遍历整个未排序部分，因此每轮比较的操作次数为 n-i，其中 i 是当前轮数。
 * 所以总的比较操作次数为 (n-1) + (n-2) + ... + 2 + 1 = n*(n-1)/2。
 * 因此，冒泡排序的最坏情况时间复杂度为O(n^2)。
 * 
 * - 最好情况下，即待排序的数组已经是有序的，仍然需要进行 n-1
 * 轮比较，但不需要进行交换操作，因为每次比较都发现相邻元素的顺序是正确的。因此，冒泡排序的最好情况时间复杂度为 O(n)。
 * 
 * - 平均情况下，冒泡排序的时间复杂度也是 O(n^2)。这是因为无论数组的初始状态如何，平均而言，需要进行 n*(n-1)/4 次比较和交换操作。
 * 
 * 2. 空间复杂度：
 * - 冒泡排序的空间复杂度是 O(1)，即不需要额外的空间来存储数据。
 * 排序过程中只需要几个临时变量来交换元素的位置，因此空间复杂度是常数级别的。
 */
public class BubbleSort {
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        // 进行 n-1 轮冒泡
        for (int i = 0; i < n - 1; i++) {
            // 在每轮冒泡中，对相邻的元素进行比较和交换
            for (int j = 0; j < n - i - 1; j++) {
                // 如果当前元素大于后一个元素，进行交换
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    // 交换数组中两个元素的位置
    private static void swap(int[] arr, int i, int j) {
        // 交换 arr[i] 和 arr[j]
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = { 64, 34, 25, 12, 22, 11, 90 };

        System.out.println("原始数组:");
        System.out.println(Arrays.toString(arr));

        bubbleSort(arr);

        System.out.println("\n排序后数组:");
        System.out.println(Arrays.toString(arr));
    }
}
