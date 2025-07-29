class Solution {
    public ArrayList<Integer> asciirange(String s) {
        int n = s.length();
        int[] first = new int[26];
        int[] last = new int[26];
        Arrays.fill(first, -1);
        
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            int idx = c - 'a';
            if (first[idx] == -1) {
                first[idx] = i;
            }
            last[idx] = i;
        }
        
        ArrayList<Integer> result = new ArrayList<>();
        
        for (int i = 0; i < 26; i++) {
            if (first[i] != -1 && last[i] != first[i]) {
                int sum = 0;
                for (int j = first[i] + 1; j < last[i]; j++) {
                    sum += s.charAt(j);
                }
                if (sum > 0) result.add(sum);
            }
        }
        
        return result;
    }
}