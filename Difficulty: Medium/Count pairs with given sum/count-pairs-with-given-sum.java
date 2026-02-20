import java.util.HashMap;

class Solution {
    int countPairs(int arr[], int target) {
        
        HashMap<Integer, Integer> freq = new HashMap<>();
        int count = 0;
        
        for(int i = 0; i < arr.length; i++){
            
            int complement = target - arr[i];
            
            // If complement exists, add its frequency
            if(freq.containsKey(complement)){
                count += freq.get(complement);
            }
            
            // Update frequency of current element
            if(freq.containsKey(arr[i])){
                freq.put(arr[i], freq.get(arr[i]) + 1);
            }
            else{
                freq.put(arr[i], 1);
            }
        }
        
        return count;
    }
}