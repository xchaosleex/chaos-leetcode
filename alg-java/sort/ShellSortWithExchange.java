public class ShellSortWithExchange {
    public static void shellSortWithExchange(int[] arr) {
        int n = arr.length;
        int gap = n / 2;

        while (gap > 0) {
            for (int i = gap; i < n; i++) {
                int j = i;
                while (j >= gap && arr[j - gap] > arr[j]) {
                    swap(arr, j, j - gap);
                    j -= gap;
                }
            }
            gap /= 2;
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
        for (int num : arr) {
            System.out.print(num + " ");
        }

        shellSortWithExchange(arr);

        System.out.println("\n排序后数组：");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
