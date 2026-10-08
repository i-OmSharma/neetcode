class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];
        
        // Manual stack using an array
        int[] stack = new int[n];
        int top = -1; // Stack pointer

        for (int i = 0; i < n; i++) {
            // While current temp is greater than the temp at the index on top of stack
            while (top >= 0 && temperatures[i] > temperatures[stack[top]]) {
                int prevIndex = stack[top--]; // Pop
                result[prevIndex] = i - prevIndex;
            }
            stack[++top] = i; // Push
        }

        return result;
    }
}