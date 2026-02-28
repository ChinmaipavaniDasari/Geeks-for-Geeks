class Solution {
    public static int findEquilibrium(int arr[]) {
        // code here
          int totalSum = 0;
        for (int num : arr){
            totalSum += num;
        }
        int currSum = 0;
        for (int i = 0; i<arr.length; i++){
            if(totalSum - arr[i] == 2 * currSum){
                return i;
            }
            currSum += arr[i];
        }
        return -1;
    }
}
