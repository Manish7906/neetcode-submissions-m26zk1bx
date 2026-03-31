class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        // Step 1: store all numbers
        for (int num : nums) {
            set.add(num);
        }
        
        int longest = 0;
        
        // Step 2: traverse array
        for (int num : nums) {
            
            // Check if it's the start of a sequence
            if (!set.contains(num - 1)) {
                
                int currentNum = num;
                int count = 1;
                
                // Check consecutive numbers
                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    count++;
                }
                
                longest = Math.max(longest, count);
            }
        }
        
        return longest;
    }
}

