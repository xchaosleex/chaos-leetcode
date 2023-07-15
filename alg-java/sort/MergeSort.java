public class MergeSort {
    
    public static void mergeSort(int[] arr) {
        int n = arr.length;

        // 递归结束条件：数组只有一个元素时，无需排序
        if (n < 2) {
            return;
        }

        int mid = n / 2;
        int[] leftArr = new int[mid];
        int[] rightArr = new int[n - mid];

        // 将原始数组拆分成左右两个子数组
        for (int i = 0; i < mid; i++) {
            leftArr[i] = arr[i];
        }
        for (int i = mid; i < n; i++) {
            rightArr[i - mid] = arr[i];
        }

        // 递归对左右子数组进行归并排序
        mergeSort(leftArr);
        mergeSort(rightArr);

        // 合并左右子数组
        merge(arr, leftArr, rightArr);
    }

    public static void merge(int[] arr, int[] leftArr, int[] rightArr) {
        int leftSize = leftArr.length;
        int rightSize = rightArr.length;
        int i = 0, j = 0, k = 0;

        // 依次比较左右子数组的元素，将较小的元素放入原始数组中
        while (i < leftSize && j < rightSize) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k++] = leftArr[i++];
            } else {
                arr[k++] = rightArr[j++];
            }
        }

        // 将左子数组中剩余的元素放入原始数组
        while (i < leftSize) {
            arr[k++] = leftArr[i++];
        }

        // 将右子数组中剩余的元素放入原始数组
        while (j < rightSize) {
            arr[k++] = rightArr[j++];
        }
    }

    public static void main(String[] args) {
        int[] arr = { 64, 34, 25, 12, 22, 11, 90 };

        System.out.println("原始数组：");
        for (int num : arr) {
            System.out.print(num + " ");
        }

        mergeSort(arr);

        System.out.println("\n排序后数组：");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
