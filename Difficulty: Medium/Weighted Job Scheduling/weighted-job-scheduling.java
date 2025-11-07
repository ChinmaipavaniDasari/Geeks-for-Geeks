import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int maxProfit(int[][] jobs) {
        if (jobs == null || jobs.length == 0) return 0;
        int n = jobs.length;

        // Sort jobs by end time
        Arrays.sort(jobs, Comparator.comparingInt(a -> a[1]));

        // Extract end times for binary search
        int[] ends = new int[n];
        for (int i = 0; i < n; i++) ends[i] = jobs[i][1];

        // dp[i] = max profit considering jobs[0..i]
        long[] dp = new long[n];

        // First job
        dp[0] = jobs[0][2];

        for (int i = 1; i < n; i++) {
            long includeProfit = jobs[i][2];
            int prevIndex = findLastNonConflicting(ends, jobs[i][0]); // last j < i with ends[j] <= start[i]
            if (prevIndex != -1) includeProfit += dp[prevIndex];

            dp[i] = Math.max(dp[i - 1], includeProfit);
        }

        return (int) dp[n - 1];
    }

    // Binary search: find the rightmost index j such that ends[j] <= startTime
    private int findLastNonConflicting(int[] ends, int startTime) {
        int lo = 0, hi = ends.length - 1;
        int ans = -1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (ends[mid] <= startTime) {
                ans = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return ans;
    }
}
