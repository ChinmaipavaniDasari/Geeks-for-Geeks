class Solution {
    public int countValid(int n, int[] arr) {
        Set<Integer> allowedDigits = new HashSet<>();
        for (int d = 0; d <= 9; d++) {
            allowedDigits.add(d);
        }
        for (int d : arr) {
            allowedDigits.remove(d);  // Remove digits we must include
        }
        int total = 9 * (int)Math.pow(10, n - 1);

        int invalid = countUsingOnlyDigits(n, allowedDigits);

        return total - invalid;
    }
    private int countUsingOnlyDigits(int n, Set<Integer> digits) {
        if (digits.isEmpty()) return 0;

        int count = 0;
        List<Integer> digitList = new ArrayList<>(digits);

        for (int d : digitList) {
            if (d == 0) continue; 
            count += countRecursive(n - 1, digitList); 
        }

        return count;
    }

    private int countRecursive(int places, List<Integer> digits) {
        if (places == 0) return 1;
        return digits.size() * countRecursive(places - 1, digits);
    }
}

