import java.util.*;

class Solution {
    static int maxArea(int mat[][]) {
        int n = mat.length;
        int m = mat[0].length;
        int[] arr = new int[m];
        int res = 0;

        for (int i = 0; i < n; i++) {
            // Update histogram row by row
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 1)
                    arr[j] += 1;
                else
                    arr[j] = 0;
            }
            // Find largest rectangle for this histogram
            res = Math.max(res, largestRectangleArea(arr));
        }
        return res;
    }

    static int largestRectangleArea(int[] hist) {
        int n = hist.length;
        Stack<Integer> s = new Stack<>();
        int ans = 0;

        for (int i = 0; i < n; i++) {
            while (!s.isEmpty() && hist[s.peek()] >= hist[i]) {
                int height = hist[s.pop()];
                int width = (s.isEmpty()) ? i : i - s.peek() - 1;
                ans = Math.max(ans, height * width);
            }
            s.push(i);
        }

        // Remaining bars in stack
        while (!s.isEmpty()) {
            int height = hist[s.pop()];
            int width = (s.isEmpty()) ? n : n - s.peek() - 1;
            ans = Math.max(ans, height * width);
        }

        return ans;
    }
}
