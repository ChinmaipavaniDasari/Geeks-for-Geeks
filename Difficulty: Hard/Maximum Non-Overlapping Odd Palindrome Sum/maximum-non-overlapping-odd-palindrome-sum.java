class Solution {
    public int maxSum(String s) {
        // code here
        int n = s.length();
        if (n < 2) return 0;

        int[] d1 = new int[n];
        int l = 0, r = -1;
        for (int i = 0; i < n; ++i) {
            int k = (i > r) ? 1 : Math.min(d1[l + r - i], r - i + 1);
            while (i - k >= 0 && i + k < n && s.charAt(i - k) == s.charAt(i + k)) k++;
            d1[i] = k;
            if (i + k - 1 > r) {
                l = i - k + 1;
                r = i + k - 1;
            }
        }

        int[] endBest = new int[n];
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        for (int e = 0; e < n; ++e) {
            int c = e;
            int end = c + d1[c] - 1;
            minHeap.offer(new int[] { c, end });
            while (!minHeap.isEmpty() && minHeap.peek()[1] < e) minHeap.poll();
            if (!minHeap.isEmpty()) {
                int cmin = minHeap.peek()[0];
                endBest[e] = 2 * (e - cmin) + 1;
            } else endBest[e] = 0;
        }

        int[] startBest = new int[n];
        int[][] centers = new int[n][2]; // [start, center]
        for (int c = 0; c < n; ++c) {
            centers[c][0] = c - (d1[c] - 1);
            centers[c][1] = c;
        }
        Arrays.sort(centers, Comparator.comparingInt(a -> a[0]));
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        int idx = 0;
        for (int st = 0; st < n; ++st) {
            while (idx < n && centers[idx][0] <= st) {
                maxHeap.offer(centers[idx][1]);
                idx++;
            }
            while (!maxHeap.isEmpty() && maxHeap.peek() < st) maxHeap.poll();
            if (!maxHeap.isEmpty()) {
                int cmax = maxHeap.peek();
                startBest[st] = 2 * (cmax - st) + 1;
            } else startBest[st] = 0;
        }

        int[] leftBest = new int[n], rightBest = new int[n];
        int cur = 0;
        for (int i = 0; i < n; ++i) {
            cur = Math.max(cur, endBest[i]);
            leftBest[i] = (i == 0) ? cur : Math.max(leftBest[i - 1], cur);
        }
        cur = 0;
        for (int i = n - 1; i >= 0; --i) {
            cur = Math.max(cur, startBest[i]);
            rightBest[i] = (i == n - 1) ? cur : Math.max(rightBest[i + 1], cur);
        }

        int ans = 0;
        for (int i = 0; i + 1 < n; ++i) {
            ans = Math.max(ans, leftBest[i] + rightBest[i + 1]);
        }
        return ans;
    }
}
