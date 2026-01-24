class Solution {
    public int[][] spiralFill(int n, int m, int[] arr) {
        int[][] mat = new int[n][m];

        int top = 0, bottom = n - 1;
        int left = 0, right = m - 1;
        int idx = 0;

        while (top <= bottom && left <= right) {

            for (int j = left; j <= right && idx < arr.length; j++) {
                mat[top][j] = arr[idx++];
            }
            top++;

            for (int i = top; i <= bottom && idx < arr.length; i++) {
                mat[i][right] = arr[idx++];
            }
            right--;

            if (top <= bottom) {
                for (int j = right; j >= left && idx < arr.length; j--) {
                    mat[bottom][j] = arr[idx++];
                }
                bottom--;
            }

            if (left <= right) {
                for (int i = bottom; i >= top && idx < arr.length; i--) {
                    mat[i][left] = arr[idx++];
                }
                left++;
            }
        }

        return mat;
    }
}
