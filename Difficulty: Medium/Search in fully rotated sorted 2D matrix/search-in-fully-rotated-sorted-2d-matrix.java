class Solution {
    public boolean searchMatrix(int[][] mat, int x) {
        // code here
        int r=mat.length;
        int c=mat[0].length;
        ArrayList<Integer> ob =new ArrayList<Integer>();
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(mat[i][j]==x)
                return true;
            }
        }
        return false;
    }
}