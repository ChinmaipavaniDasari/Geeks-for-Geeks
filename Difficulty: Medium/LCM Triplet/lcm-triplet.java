class Solution {
    long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    long lcm(long a, long b) {
        return (a * b) / gcd(a, b);
    }

    long lcmOfThree(long a, long b, long c) {
        return lcm(a, lcm(b, c));
    }

    int lcmTriplets(int n) {
        long maxLCM = 0;

        for (int i = n; i >= Math.max(1, n - 4); i--) {
            for (int j = i; j >= Math.max(1, n - 4); j--) {
                for (int k = j; k >= Math.max(1, n - 4); k--) {
                    long currentLCM = lcmOfThree(i, j, k);
                    maxLCM = Math.max(maxLCM, currentLCM);
                }
            }
        }

        return (int) maxLCM;
    }
}
