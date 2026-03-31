class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = 
            new PriorityQueue<>(Collections.reverseOrder());

        for (int stone : stones) {
            maxHeap.add(stone);
        }

        while (maxHeap.size() > 1) {
            int s1 = maxHeap.poll(); // largest
            int s2 = maxHeap.poll(); // second largest

            if (s1 != s2) {
                maxHeap.add(s1 - s2);
            }
        }

        return maxHeap.isEmpty() ? 0 : maxHeap.peek();
    }
}