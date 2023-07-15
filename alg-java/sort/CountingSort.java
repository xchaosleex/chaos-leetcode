import java.util.*;

/**
 * 计数排序（CountingSort）：Stable Sort
 * 计数排序（CountingSort）是一种线性时间复杂度的排序算法，适用于待排序元素的取值范围较小且已知的情况。
 * 计数排序的时间复杂度和空间复杂度如下所示：
 * 
 * 1. 时间复杂度：
 * - 计数排序的时间复杂度为 O(n+k)，其中 n 是待排序元素的数量，k 是待排序元素的取值范围。
 * - 在计数排序的过程中，需要创建一个额外的计数数组，长度为 k+1，用于统计每个元素出现的次数。遍历原始数组并统计每个元素的时间复杂度为
 * O(n)。然后，根据计数数组重构排序后的数组的时间复杂度为 O(k)。
 * - 综上所述，计数排序的时间复杂度为 O(n+k)。
 * 
 * 2. 空间复杂度：
 * - 计数排序的空间复杂度为 O(n+k)，其中 n 是待排序元素的数量，k 是待排序元素的取值范围。
 * - 在计数排序的过程中，需要创建一个额外的计数数组，长度为
 * k+1，用于统计每个元素出现的次数。因此，计数排序的空间复杂度与待排序元素的数量和取值范围有关。
 * - 注意，计数排序的空间复杂度不包括存储待排序元素的原始数组，因为这是输入数据而不是算法本身的空间需求。
 */
public class CountingSort {
    public static void countingSort(int[] arr) {
        int n = arr.length;

        // 找到数组中的最大值，以确定计数数组的大小
        int max = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        // 创建计数数组，并初始化为0
        int[] countArr = new int[max + 1];
        // 计算每个元素的出现次数
        for (int i = 0; i < n; i++) {
            countArr[arr[i]]++;
        }

        // 对计数数组进行累加
        for (int i = 1; i <= max; i++) {
            countArr[i] += countArr[i - 1];
        }

        // 创建临时数组，用于存储排序结果
        int[] tempArr = new int[n];
        for (int i = 0; i < n; i++) {
            int value = arr[i];
            int index = countArr[value] - 1;
            tempArr[index] = value;
            countArr[value]--;
        }

        // 将临时数组的元素复制回原始数组
        for (int i = 0; i < n; i++) {
            arr[i] = tempArr[i];
        }
    }

    public static void main(String[] args) {
        int[] arr = { 64, 34, 25, 12, 22, 11, 90 };

        System.out.println("原始数组：");
        System.out.println(Arrays.toString(arr));

        countingSort(arr);

        System.out.println("\n排序后数组：");
        System.out.println(Arrays.toString(arr));
    }
}
