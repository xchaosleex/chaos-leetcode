import java.util.*;

class Solution347 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        List<Integer> elements = new ArrayList<>(frequencyMap.keySet());
        elements.sort((a, b) -> frequencyMap.get(b) - frequencyMap.get(a));
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = elements.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        Solution347 s = new Solution347();
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        int[] result = s.topKFrequent(nums, k);
        System.out.println(Arrays.toString(result));
    }
}