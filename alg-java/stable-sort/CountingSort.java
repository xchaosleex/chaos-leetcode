import java.util.Arrays;

public class CountingSort {

    public void sort(int[] arr) {
        int len = arr.length;
        // 找到最大数
        int max = arr[0];
        for (int i = 1; i < len; i++) {
            max = arr[i] > max ? arr[i] : max;
        }
        // 构建计数数组
        int[] countArr = new int[max + 1];
        for (int i = 0; i < len; i++) {
            countArr[arr[i]]++;
        }
        for (int i = 1; i <= max; i++) {
            countArr[i] += countArr[i - 1];
        }
        // 写入临时数组
        int[] tempArr = new int[len];
        for (int i = 0; i < len; i++) {
            int value = arr[i];
            int index = countArr[value] - 1;
            tempArr[index] = value;
            countArr[value]--;
        }
        for (int i = 0; i < len; i++)
            arr[i] = tempArr[i];
    }

    public static void main(String[] args) {
        CountingSort sort = new CountingSort();
        int[] arr = new int[] { 4, 1, 6, 7, 2 };
        sort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

}
