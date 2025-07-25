class Solution {
    public int maxCircularSum(int arr[]) {
        int totalSum = 0;
        int maxSum = Integer.MIN_VALUE;
        int currMax = 0;
        int minSum = Integer.MAX_VALUE;
        int currMin = 0;

        for (int num : arr) {
            currMax = Math.max(num, currMax + num);
            maxSum = Math.max(maxSum, currMax);

            currMin = Math.min(num, currMin + num);
            minSum = Math.min(minSum, currMin);

            totalSum += num;
        }

        if (totalSum == minSum) {
            return maxSum;
        }

        return Math.max(maxSum, totalSum - minSum);
    }
}
