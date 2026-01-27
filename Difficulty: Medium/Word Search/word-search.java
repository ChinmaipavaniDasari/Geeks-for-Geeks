class Solution {
    int[][] vis;
    int[] dx = {-1,0,1,0};
    int[] dy = {0,1,0,-1}; 
    private boolean check(int x,int y,int w,int n,int m,char[][] mat, String word){
        if(w==word.length())return true;
        vis[x][y]=1;
        for(int d=0;d<4;d++){
            int nx = x+dx[d];
            int ny = y+dy[d];
            if(nx>=0 && ny>=0 && nx<n && ny<m && vis[nx][ny]==0){
                if(mat[nx][ny]==word.charAt(w) && check(nx,ny,w+1,n,m,mat,word))return true;
            }
        }
        vis[x][y]=0;
        return false;
    }
    public boolean isWordExist(char[][] mat, String word) {
        int n = mat.length,m=mat[0].length;
        vis = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==word.charAt(0) && check(i,j,1,n,m,mat,word))return true;
            }
        }
        return false;
    }
}