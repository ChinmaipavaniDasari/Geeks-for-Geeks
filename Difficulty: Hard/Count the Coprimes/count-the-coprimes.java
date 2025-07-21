class Solution {
    static final int MAX = 10001;
    
    public int cntCoprime(int[] arr) {
        int[] freq = new int[MAX];
        for (int num : arr) freq[num]++;
        
        int[] cnt = new int[MAX];  // cnt[i] = count of numbers divisible by i
        for (int i = 1; i < MAX; i++) {
            for (int j = i; j < MAX; j += i) {
                cnt[i] += freq[j];
            }
        }

        int[] mobius = getMobius(MAX);
        long totalPairs = 0;
        for (int i = 1; i < MAX; i++) {
            long c = cnt[i];
            if (c >= 2) {
                long pairs = c * (c - 1) / 2;
                totalPairs += mobius[i] * pairs;
            }
        }

        return (int) totalPairs;
    }
    private int[] getMobius(int n) {
        int[] mobius = new int[n];
        boolean[] isPrime = new boolean[n];
        for (int i = 0; i < n; i++) {
            mobius[i] = 1;
            isPrime[i] = true;
        }

        for (int i = 2; i < n; i++) {
            if (isPrime[i]) {
                for (int j = i; j < n; j += i) {
                    mobius[j] *= -1;
                    isPrime[j] = false;
                }
                for (int j = i * i; j < n; j += i * i) {
                    mobius[j] = 0;
                }
            }
        }
        return mobius;
    }
}
