class Solution {
    class Node{
        int i;
        int j;
        int steps;
        Node(int i, int j, int steps){
            this.i = i;
            this.j = j;
            this.steps = steps;
        }
    }
    public ArrayList<ArrayList<Integer>> nearest(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<Node> q = new LinkedList<>(); 
        boolean[][] isVisited = new boolean[n][m]; 
        ArrayList<ArrayList<Integer>> result = new ArrayList<>(); 
        
        for(int i=0; i<n; i++){
            ArrayList<Integer> temp = new ArrayList<>();
            for(int j=0; j<m; j++){
                temp.add(-1); 
                
                if(grid[i][j]==1){
                    q.add(new Node(i, j, 0)); 
                    isVisited[i][j] = true; 
                }
            }
            result.add(temp); 
        }
        
        int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        
        while(!q.isEmpty()){
            Node curr = q.poll(); 
            int row = curr.i;
            int col = curr.j;
            int steps = curr.steps;
            
            result.get(row).set(col, steps); 
            
            for(int i=0; i<4; i++){
                int nrow = row + dir[i][0];
                int ncol = col + dir[i][1];
                
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && !isVisited[nrow][ncol]){
                    isVisited[nrow][ncol] = true; 
                    q.add(new Node(nrow, ncol, steps+1)); 
                }
            }
        }
        return result; 
    }
}