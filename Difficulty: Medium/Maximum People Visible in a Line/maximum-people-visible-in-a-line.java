class Solution {
    public int maxPeople(int[] arr) {
        // code here
        int n = arr.length;
        if (n == 0) return 0;

        // Stores the count of people smaller than arr[i] to the left (including self)
        int[] leftRange = new int[n];
        
        // Stores the count of people smaller than arr[i] to the right (including self)
        int[] rightRange = new int[n];

        // Use ArrayDeque for a faster Stack implementation
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        // 1. Fill Left Range
        for (int i = 0; i < n; i++) {
            // Pop elements that are smaller than current; they are "dominated" by arr[i]
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                stack.pop();
            }
            // If stack is empty, arr[i] is the largest so far (extends to start)
            // Else, it extends only up to the previous greater element
            leftRange[i] = stack.isEmpty() ? i + 1 : i - stack.peek();
            stack.push(i);
        }

        stack.clear(); // Reuse the stack for the right pass

        // 2. Fill Right Range
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                stack.pop();
            }
            rightRange[i] = stack.isEmpty() ? n - i : stack.peek() - i;
            stack.push(i);
        }

        // 3. Calculate Maximum
        int maxPeople = 0;
        for (int i = 0; i < n; i++) {
            // left + right - 1 (because current element is counted in both)
            maxPeople = Math.max(maxPeople, leftRange[i] + rightRange[i] - 1);
        }

        return maxPeople;
    }
}
