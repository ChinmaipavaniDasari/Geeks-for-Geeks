class Solution {
    public void sort012(int[] arr) {
        int n = arr.length;
        int c0 = 0, c1 = 0, c2 = 0;

        // Count 0s, 1s, and 2s
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                c0++;
            } else if (arr[i] == 1) {
                c1++;
            } else {
                c2++;
            }
        }

        int idx = 0;

        // Put 0s
        for (int i = 0; i < c0; i++) {
            arr[idx++] = 0;
        }

        // Put 1s
        for (int i = 0; i < c1; i++) {
            arr[idx++] = 1;
        }

        // Put 2s
        for (int i = 0; i < c2; i++) {
            arr[idx++] = 2;
        }
    }
}
