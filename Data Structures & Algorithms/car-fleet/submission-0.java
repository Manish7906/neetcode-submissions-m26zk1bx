class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        
        // Pair: position and time to reach target
        double[][] cars = new double[n][2];
        
        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = (double)(target - position[i]) / speed[i];
        }
        
        // Sort by position in descending order
        Arrays.sort(cars, (a, b) -> Double.compare(b[0], a[0]));
        
        Stack<Double> stack = new Stack<>();
        
        for (int i = 0; i < n; i++) {
            double time = cars[i][1];
            
            // If stack empty OR current car cannot catch fleet ahead
            if (stack.isEmpty() || time > stack.peek()) {
                stack.push(time);
            }
            // Else: it merges → do nothing
        }
        
        return stack.size();
    }
}
