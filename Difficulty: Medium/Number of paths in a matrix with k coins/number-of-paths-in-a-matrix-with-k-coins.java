class Solution {
    public int numberOfPath(int[][] mat, int k) {
        int n = mat.length;
        int m = mat[0].length;
        int[][][] dp = new int[n][m][k+1];
        
        
        // base initialization
        for(int sum = 0; sum <= k; sum++){
            // is sum == mat[n-1][m-1] and we are at dest => 1, otherwise 0
            dp[n-1][m-1][sum] = (sum == mat[n-1][m-1]) ? 1 : 0;
        }

                
        
        // bottom up
        for(int i=n-1; i>=0; i--){
            for(int j=m-1; j>=0; j--){
                for(int sum=0; sum<=k; sum++){
                    
                    if(sum - mat[i][j] < 0) continue; // if sum becomes becomes negative after this cell => do nothing, skip
                    
                    // move down
                    if(i+1 < n){
                        dp[i][j][sum] += dp[i+1][j][sum - mat[i][j]];
                    }

                    // move right
                    if(j+1 < m){
                        dp[i][j][sum] += dp[i][j+1][sum - mat[i][j]];
                    }
                }
            }
        }
        
        return dp[0][0][k]; // ways from (0, 0) for sum = k 
    }
}