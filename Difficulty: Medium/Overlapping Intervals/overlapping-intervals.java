class Solution {
    public ArrayList<int[]> mergeOverlap(int[][] arr) {
        // Code here
        ArrayList<int[]>ans=new ArrayList<>();
        
        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));
        
        int st=arr[0][0];
        int end=arr[0][1];
        
        for(int i=1;i<arr.length;i++){
            if(st<=arr[i][0] && end<=arr[i][1] && end>=arr[i][0]){
                st=st;
                end=arr[i][1];
            }
            
            else if(st<=arr[i][0] && end>=arr[i][1] && end>=arr[i][0]){
                st=st;
                end=end;
            }
   
            else{
                int curr[]=new int[2];
                curr[0]=st;
                curr[1]=end;
                ans.add(curr);
                st=arr[i][0];
                end=arr[i][1];
            }
            
        }
        int curr[]=new int[2];
        curr[0]=st;
        curr[1]=end;
        ans.add(curr);
        
        return ans;
    }
}