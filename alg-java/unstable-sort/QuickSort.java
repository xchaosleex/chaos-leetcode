import java.util.Arrays;

public class QuickSort {

    public void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            // Find pivot element such that
            // elements smaller than pivot are on the left
            // elements greater than pivot are on the right
            int partition = partition(arr, left, right);
            quickSort(arr, left, partition - 1);
            quickSort(arr, partition + 1, right);
        }
    }

    public int partition(int[] arr, int left, int right) {
        // Choose the rightmost element as pivot
        int pivot = arr[right];
        int i = left - 1;
        for (int j = left; j < right; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, right);
        return i + 1;
    }

    public void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        QuickSort sort = new QuickSort();
        int[] arr = new int[] { 4, 1, 6, 7, 2 };
        sort.quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

}
