import java.util.Arrays;

public class BubbleSort {

    // 从数组最大长度递减，重复遍历剩余数组，找到剩余数组中的最大或者最小值，放在数组最后。
    public int[] sort(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len - 1; i++) {
            for (int j = 0; j < len - 1 - i; j++) {
                cas(arr, j, j + 1);
            }
        }
        return arr;
    }

    // 比较并交换 compare and swap
    public void cas(int[] arr, int i, int j) {
        if (arr[i] < arr[j]) {
            int temp = arr[j];
            arr[j] = arr[i];
            arr[i] = temp;
        }
    }

    public static void main(String[] args) {
        BubbleSort sort = new BubbleSort();
        System.out.println(Arrays.toString(sort.sort(new int[] { 4, 1, 6, 7, 2 })));
    }

}
