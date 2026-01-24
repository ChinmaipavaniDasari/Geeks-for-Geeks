class Solution {
    public void setMatrixZeroes(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        boolean row[] = new boolean[n];
        boolean col[] = new boolean[m];

        // Step 1: Mark rows and columns which have zero
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {   // FIXED: j < m
                if (mat[i][j] == 0) {
                    row[i] = true;
                    col[j] = true;
                }
            }
        }

        // Step 2: Set matrix cells to zero
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {   // FIXED: j < m
                if (row[i] || col[j]) {
                    mat[i][j] = 0;
                }
            }
        }
    }
}
