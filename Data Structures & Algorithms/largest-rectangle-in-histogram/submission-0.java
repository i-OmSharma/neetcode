

class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        // Stack stores indices of bars in increasing order of height
        Deque<Integer> stack = new ArrayDeque<>();
        int maxArea = 0;

        // Loop from 0 to n (inclusive) to handle remaining elements in stack
        for (int i = 0; i <= n; i++) {
            // If i == n, current height is 0 to force pop all remaining bars
            int currentHeight = (i == n) ? 0 : heights[i];

            // While stack is not empty and current bar is shorter than stack top
            while (!stack.isEmpty() && currentHeight < heights[stack.peek()]) {
                int height = heights[stack.pop()];
                
                // Calculate width:
                // If stack is empty, the bar extends from index 0 to i-1 (width = i)
                // Otherwise, it extends from (stack.peek() + 1) to (i - 1)
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                
                maxArea = Math.max(maxArea, height * width);
            }
            
            stack.push(i);
        }

        return maxArea;
    }
}