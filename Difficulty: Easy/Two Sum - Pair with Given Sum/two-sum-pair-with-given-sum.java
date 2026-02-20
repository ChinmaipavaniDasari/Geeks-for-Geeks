class Solution {
    boolean twoSum(int arr[], int target) {
        // code here
        Arrays.sort(arr);
        for(int i =0;i<arr.length;i++){
            int low = i+1;
            int high = arr.length - 1;
            int complement = target - arr[i];
            while(low <= high){
                int mid = (low + high)/2;
                if(arr[mid] == complement){
                    return true;
                }
                else if(arr[mid] < complement){
                    low  = mid+1;
                }
                else{
                    high = mid - 1;
                }
            }
        }
        return false;
    }
}