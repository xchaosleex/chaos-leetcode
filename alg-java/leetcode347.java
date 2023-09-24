import java.util.*;

/**
 * 347. Top K Frequent Elements
 * Source: https://leetcode.com/problems/top-k-frequent-elements/
 * Given an integer array nums and an integer k, return the k most frequent
 * elements. You may return the answer in any order.
 */
public class leetcode347 {
    public int[] topKFrequent(int[] nums, int k) {
        // count the frequency of each element
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        // sort the elements by frequency
        List<Integer> elements = new ArrayList<>(frequencyMap.keySet());
        elements.sort((a, b) -> frequencyMap.get(b) - frequencyMap.get(a));
        // get the top k elements
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
