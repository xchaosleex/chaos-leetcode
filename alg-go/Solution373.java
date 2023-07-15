import java.util.*;

class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        // build a sum asc priority queue
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] + a[1] - b[0] - b[1]);
        for (int i = 0; i < nums1.length; i++) {
            pq.offer(new int[]{nums1[i], nums2[0], 0});
        }
        // collect result
        List<List<Integer>> result = new ArrayList();
        while (k-- > 0 && !pq.isEmpty()) {
            int[] curr = pq.poll();
            int i = curr[2];
            result.add(Arrays.asList(curr[0], curr[1]));
            if (i == nums2.length - 1) {
                continue;
            }
            pq.offer(new int[]{curr[0], nums2[i + 1], i + 1});
        }
        return result;
    }
}