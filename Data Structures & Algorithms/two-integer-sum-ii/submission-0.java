class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length - 1;

        while (i < j) {
            int sum = numbers[i] + numbers[j];

            if (sum > target) {
                j--;
            } 
            else if (sum < target) {
                i++;
            } 
            else {
                // LeetCode Two Sum II requires 1-based indexing
                return new int[]{i + 1, j + 1};
            }
        }

        return new int[]{}; // problem guarantees one solution
    }
}
