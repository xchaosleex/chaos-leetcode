import java.util.Arrays;

public class MergeSort {

    public void sort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            sort(arr, left, mid);
            sort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    public void merge(int[] arr, int left, int mid, int right) {
        int i = left, j = mid + 1, k = 0;
        int[] tempArr = new int[right - left + 1];
        while (i <= mid && j <= right) {
            if (arr[i] < arr[j]) {
                tempArr[k++] = arr[i++];
            } else {
                tempArr[k++] = arr[j++];
            }
        }
        while (i <= mid) {
            tempArr[k++] = arr[i++];
        }
        while (j <= right) {
            tempArr[k++] = arr[j++];
        }
        for (i = left, k = 0; i <= right; i++, k++) {
            arr[i] = tempArr[k];
        }
    }

    public static void main(String[] args) {
        MergeSort sort = new MergeSort();
        int[] arr = new int[] { 4, 1, 6, 7, 2 };
        sort.sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

}
