import java.util.Arrays;

public class InsertSort {

    public int[] sort(int[] arr) {
        int len = arr.length;
        for (int i = 1; i < len; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
        return arr;
    }

    public static void main(String[] args) {
        InsertSort sort = new InsertSort();
        System.out.println(Arrays.toString(sort.sort(new int[] { 4, 1, 6, 7, 2 })));
    }

}
