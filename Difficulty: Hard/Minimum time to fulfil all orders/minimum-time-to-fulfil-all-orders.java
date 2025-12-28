class Solution {
    
    public int minTime(int[] ranks, int n) {
        int low = 0;
        int high = getMaxTime(ranks, n);
        int ans = high;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canMake(ranks, n, mid)) {
                ans = mid;      // possible answer
                high = mid - 1; // try smaller time
            } else {
                low = mid + 1;  // need more time
            }
        }
        return ans;
    }

    // Check if we can make at least n donuts in given time
    private boolean canMake(int[] ranks, int n, int time) {
        int totalDonuts = 0;

        for (int r : ranks) {
            int k = 1;
            int currTime = 0;

            while (true) {
                currTime += r * k;
                if (currTime > time) break;
                totalDonuts++;
                k++;
            }

            if (totalDonuts >= n) return true;
        }
        return false;
    }

    // Maximum possible time (upper bound)
    private int getMaxTime(int[] ranks, int n) {
        int minRank = Integer.MAX_VALUE;
        for (int r : ranks) {
            minRank = Math.min(minRank, r);
        }
        return minRank * n * (n + 1) / 2;
    }
}
