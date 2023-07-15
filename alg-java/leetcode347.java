import java.util.*;

public class leetcode347 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        List<Integer> elements = new ArrayList<>(frequencyMap.keySet());
        elements.sort((a, b) -> frequencyMap.get(b) - frequencyMap.get(a));
        System.out.println(elements);
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = elements.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        leetcode347 solution = new leetcode347();
        int[] nums = { 1, 1, 1, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4, 4 };
        int k = 2;
        int[] result = solution.topKFrequent(nums, k);
        System.out.println(Arrays.toString(result));
    }
}
