class Solution {
    public ArrayList<Integer> minMaxCandy(int[] prices, int k) {
        int n = prices.length;
        ArrayList<Integer> ans = new ArrayList<>();
        Arrays.sort(prices);
            
        int totalReq = (n+k)/(k+1);
        int min =0, max=0;
        for(int i=0; i<totalReq; i++) {
            min+=prices[i];
            max+=prices[n-1-i];
        }
        ans.add(min);
        ans.add(max);
        return ans;
    }
}
