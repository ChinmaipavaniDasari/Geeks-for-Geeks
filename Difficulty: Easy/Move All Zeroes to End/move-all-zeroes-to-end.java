class Solution {
    void pushZerosToEnd(int[] arr) {
        // code here
        int count = 0;
        int  n = arr.length;
        for(int i = 0;i<n;i++){
            if(arr[i] != 0){
                arr[count] = arr[i];
                count = count + 1;
            }
        }
        while(count<n){
            arr[count] = 0;
            count = count + 1;
        }
    }
}