class Solution {
    public int findMinDiff(ArrayList<Integer> arr, int m) {
        // your code here
        Collections.sort(arr);
        int size=arr.size();
        
        if(size<m)
        return -1;
        
     int s=0;
     int e=m-1;
     int diff=Integer.MAX_VALUE;
     while(e<size)
     {
         diff=Math.min(diff,arr.get(e++)-arr.get(s++));
     }
        
        return diff;
        
    }
   
}