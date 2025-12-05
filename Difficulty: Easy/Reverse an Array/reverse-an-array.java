class Solution {
    public void reverseArray(int arr[]) {
        // code here
        int n = arr.length;
        int p = arr.length -1;
        for(int i = 0;i<n/2;i++){
            int temp = arr[i];
            arr[i] = arr[p];
            arr[p] = temp;
            p--;
        }
    }
}