import java.util.*;

/**
 * 堆排序（Heap Sort）：Unstable Sort
 * 堆排序（HeapSort）是一种基于比较的排序算法，它使用二叉堆这种数据结构来进行排序。
 * 堆排序的时间复杂度和空间复杂度如下所示：
 * 
 * 1. 时间复杂度：
 * - 堆排序的时间复杂度为 O(nlogn)。
 * 
 * 2. 空间复杂度：
 * - 堆排序的空间复杂度为 O(1)。
 */
public class HeapSort {
    public static void heapSort(int[] arr) {
        int n = arr.length;

        // 构建最大堆
        buildMaxHeap(arr);

        // 逐步取出堆顶元素并调整堆
        for (int i = n - 1; i > 0; i--) {
            // 将堆顶元素与最后一个元素交换
            swap(arr, 0, i);

            // 调整堆，使其满足最大堆性质
            heapify(arr, i, 0);
        }
    }

    private static void buildMaxHeap(int[] arr) {
        int n = arr.length;

        // 从最后一个非叶子节点开始向上调整堆
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }
    }

    /**
     * 调整堆，使其满足最大堆性质
     * 
     * @param arr         待调整的堆
     * @param heapSize    堆的大小
     * @param parentIndex 要下沉的父节点
     */
    private static void heapify(int[] arr, int heapSize, int parentIndex) {
        int largest = parentIndex;
        int leftChild = 2 * parentIndex + 1;
        int rightChild = 2 * parentIndex + 2;

        // 找到左子节点和右子节点中的最大值
        if (leftChild < heapSize && arr[leftChild] > arr[largest]) {
            largest = leftChild;
        }
        if (rightChild < heapSize && arr[rightChild] > arr[largest]) {
            largest = rightChild;
        }

        // 如果最大值不是父节点，则进行交换并继续调整子树
        if (largest != parentIndex) {
            swap(arr, parentIndex, largest);
            heapify(arr, heapSize, largest);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = { 64, 34, 25, 12, 22, 11, 90 };

        System.out.println("原始数组：");
        System.out.println(Arrays.toString(arr));

        heapSort(arr);

        System.out.println("\n排序后数组:");
        System.out.println(Arrays.toString(arr));
    }
}
