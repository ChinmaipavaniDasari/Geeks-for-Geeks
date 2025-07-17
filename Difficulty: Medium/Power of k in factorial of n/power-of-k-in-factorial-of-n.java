class Solution {
    public int maxKPower(int n, int k) {
        int ans = Integer.MAX_VALUE;

        for (int i = 2; i * i <= k; i++) {
            if (k % i == 0) {
                int countInK = 0;
                while (k % i == 0) {
                    countInK++;
                    k /= i;
                }

                int countInFact = 0;
                int temp = n;
                while (temp > 0) {
                    temp /= i;
                    countInFact += temp;
                }

                ans = Math.min(ans, countInFact / countInK);
            }
        }
        if (k > 1) {
            int countInFact = 0;
            int temp = n;
            while (temp > 0) {
                temp /= k;
                countInFact += temp;
            }
            ans = Math.min(ans, countInFact);
        }

        return ans; 
    }
}