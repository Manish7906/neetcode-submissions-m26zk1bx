class Solution {
    public int leastInterval(char[] tasks, int n) {
        
        int[] freq = new int[26];
        
        // Step 1: Count frequency
        for (char t : tasks) {
            freq[t - 'A']++;
        }
        
        // Step 2: Sort frequencies
        Arrays.sort(freq);
        
        int maxFreq = freq[25]; // highest frequency
        
        int countMax = 0;
        
        // Count how many tasks have max frequency
        for (int i = 25; i >= 0; i--) {
            if (freq[i] == maxFreq) countMax++;
        }
        
        // Step 3: Apply formula
        int partCount = maxFreq - 1;
        int partLength = n + 1;
        
        int result = partCount * partLength + countMax;
        
        // Step 4: return max of total tasks or calculated value
        return Math.max(tasks.length, result);
    }
}