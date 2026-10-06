class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        if (n == 0) return 0;

        // Create an array of indices [0, 1, ..., n-1]
        Integer[] indices = new Integer[n];
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }

        // Sort indices based on position in descending order
        Arrays.sort(indices, (a, b) -> position[b] - position[a]);

        int fleets = 0;
        double maxTime = 0;

        for (int i : indices) {
            // Calculate time to reach target
            double time = (double)(target - position[i]) / speed[i];
            
            // If this car takes longer than the current fleet ahead, it forms a new fleet
            if (time > maxTime) {
                fleets++;
                maxTime = time;
            }
        }

        return fleets;
    }
}