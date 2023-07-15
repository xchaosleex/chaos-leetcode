import java.util.*;

/**
 * 桶排序（Bucket Sort）：Stable Sort
 * 桶排序（BucketSort）是一种排序算法，它将待排序元素分散到不同的桶（容器）中，然后对每个桶中的元素进行排序，
 * 最后将桶中的元素按顺序合并得到有序结果。桶排序的时间复杂度和空间复杂度如下所示：
 * 
 * 1. 时间复杂度：
 * - 假设待排序的 n 个元素均匀分布在 m 个桶中。将 n 个元素分散到 m 个桶中的时间复杂度为
 * O(n)，这是因为每个元素需要通过某种映射函数确定其所属的桶。映射的时间复杂度是线性的，即 O(1)。因此，将 n 个元素分散到 m
 * 个桶中的总时间复杂度为 O(n)。
 * - 对于每个非空的桶，可以使用一种快速排序算法（如插入排序）进行排序。如果每个桶中的平均元素数量为 k，那么对每个非空的桶进行排序的时间复杂度为 O(k
 * log k)。注意，这里假设每个桶中的元素已经近似有序。
 * - 合并每个桶中的元素需要遍历每个桶，并将元素按顺序放回原始数组中。这一步的时间复杂度为 O(n)。
 * - 综上所述，桶排序的时间复杂度可以近似看作 O(n + k log k)，其中 k 表示平均每个桶中的元素数量。
 * 
 * 2. 空间复杂度：
 * - 桶排序的空间复杂度主要取决于桶的数量和每个桶中元素的数量。假设有 m 个桶，每个桶平均包含 k 个元素，则空间复杂度为 O(n +
 * m)。这是因为需要额外的空间来存储桶和合并后的有序结果。
 * - 如果 m 的数量与待排序元素的数量 n 相当，即 m ≈ n，则空间复杂度可以简化为 O(n)。
 * - 注意，桶排序的空间复杂度不包括存储待排序元素的原始数组，因为这是输入数据而不是算法本身的空间需求。
 */
public class BucketSort {
    @SuppressWarnings("unchecked")
    public static void bucketSort(int[] arr, int numBuckets) {
        int n = arr.length;

        // 创建桶并初始化为空列表
        ArrayList<Integer>[] buckets = new ArrayList[numBuckets];
        for (int i = 0; i < numBuckets; i++) {
            buckets[i] = new ArrayList<>();
        }

        // 计算每个元素应该放置在哪个桶中
        int maxValue = findMaxValue(arr);
        for (int i = 0; i < n; i++) {
            int bucketIndex = (arr[i] * numBuckets) / (maxValue + 1);
            buckets[bucketIndex].add(arr[i]);
        }

        // 对每个桶内的元素进行排序
        for (int i = 0; i < numBuckets; i++) {
            Collections.sort(buckets[i]);
        }

        // 将排序后的元素依次放回原始数组
        int index = 0;
        for (int i = 0; i < numBuckets; i++) {
            for (int j = 0; j < buckets[i].size(); j++) {
                arr[index++] = buckets[i].get(j);
            }
        }
    }

    private static int findMaxValue(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = { 64, 34, 25, 12, 22, 11, 90 };
        int numBuckets = 5; // 桶的数量

        System.out.println("原始数组:");
        System.out.println(Arrays.toString(arr));

        bucketSort(arr, numBuckets);

        System.out.println("\n排序后数组:");
        System.out.println(Arrays.toString(arr));
    }
}
