class Solution {
    public int maxSubarrayXOR(int[] arr, int k) {
        // code here
        int n = arr.length;
        if (k > n) return -1; // invalid case

        // Compute XOR of first k elements
        int currXor = 0;
        for (int i = 0; i < k; i++) {
            currXor ^= arr[i];
        }

        int maxXor = currXor;

        // Slide the window
        for (int i = k; i < n; i++) {
            // Remove leftmost element and add new element
            currXor ^= arr[i - k]; // remove
            currXor ^= arr[i];     // add

            maxXor = Math.max(maxXor, currXor);
        }

        return maxXor;
    }
}
