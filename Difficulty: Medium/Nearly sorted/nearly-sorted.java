class Solution {
    public void nearlySorted(int[] arr, int k) {
        // code here
        
        int n = arr.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        int index = 0;
        
        for(int i=0;i<n;i++)
        {
            pq.add(arr[i]);
            
            if(pq.size()>k)
            {
                arr[index++] = pq.poll();  //restricting the complexity to O(log k)
            }
            
        }
        
        while(!pq.isEmpty())
        arr[index++]=pq.poll();
        
        //Time complexity : O(n logk)
       // Space complexity : O(k)
    }
}