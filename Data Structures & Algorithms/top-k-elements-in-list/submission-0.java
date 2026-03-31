class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        // Step 1: Count frequency
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Step 2: Create buckets (index = frequency)
        List<Integer>[] bucket = new ArrayList[nums.length + 1];

        for (int key : map.keySet()) {
            int freq = map.get(key);
            
            if (bucket[freq] == null) {
                bucket[freq] = new ArrayList<>();
            }
            
            bucket[freq].add(key);
        }

        // Step 3: Collect top k frequent elements
        int[] result = new int[k];
        int count = 0;

        for (int i = bucket.length - 1; i >= 0 && count < k; i--) {
            if (bucket[i] != null) {
                for (int num : bucket[i]) {
                    result[count++] = num;
                    if (count == k) break;
                }
            }
        }

        return result;
    }
}
