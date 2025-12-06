class Solution {
    int maxSubarraySum(int[] arr) {
        // Code here
        int max = Integer.MIN_VALUE;
        int cs = 0;
        int n = arr.length;
        for(int i=0;i<n;i++){
            cs = cs + arr[i];
            max = Math.max(cs,max);
            if(cs<0){
                cs = 0;
            }
        }
        return max;
        
    }
}
