// User function Template for Java

class Solution {
    public int findMin(int[] arr) {
        // complete the function here
        int min = arr[0];
        for(int i= 0;i<arr.length;i++){
            if(arr[i]<min){
                min = arr[i];
            }
        }
        return min;
    }
}
