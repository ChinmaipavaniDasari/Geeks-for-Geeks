class Solution {
    public int vowelCount(String s) {
         Map<Character, Integer> vowelCount = new HashMap<>();
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');

        for (char c : s.toCharArray()) {
            if (vowels.contains(c)) {
                vowelCount.put(c, vowelCount.getOrDefault(c, 0) + 1);
            }
        }

        int numVowels = vowelCount.size();
        if (numVowels == 0) return 0;
        int totalChoices = 1;
        for (int count : vowelCount.values()) {
            totalChoices *= count;
        }
        return totalChoices * factorial(numVowels);
    }

    private int factorial(int n) {
        int res = 1;
        for (int i = 2; i <= n; i++) {
            res *= i;
        }
        return res;
    }
}