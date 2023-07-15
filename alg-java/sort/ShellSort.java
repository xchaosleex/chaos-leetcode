public class ShellSort {
    public static void shellSort(int[] arr) {
        int n = arr.length;
        
        // 使用希尔增量序列进行排序
        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                int temp = arr[i];
                int j = i;
                
                // 对间隔为 gap 的元素进行插入排序
                while (j >= gap && arr[j - gap] > temp) {
                    arr[j] = arr[j - gap];
                    j -= gap;
                }
                
                arr[j] = temp;
            }
        }
    }
    
    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        
        System.out.println("原始数组：");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        
        shellSort(arr);
        
        System.out.println("\n排序后数组：");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
