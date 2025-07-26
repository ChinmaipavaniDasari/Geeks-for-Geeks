class Solution {
    public ArrayList<Integer> findMajority(int[] arr) {
        int n = arr.length;

        Integer cand1 = null, cand2 = null;
        int count1 = 0, count2 = 0;

        for (int num : arr) {
            if (cand1 != null && num == cand1) {
                count1++;
            } else if (cand2 != null && num == cand2) {
                count2++;
            } else if (count1 == 0) {
                cand1 = num;
                count1 = 1;
            } else if (count2 == 0) {
                cand2 = num;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }

        count1 = 0;
        count2 = 0;
        for (int num : arr) {
            if (cand1 != null && num == cand1) count1++;
            else if (cand2 != null && num == cand2) count2++;
        }

        ArrayList<Integer> res = new ArrayList<>();
        int threshold = n / 3;
        if (count1 > threshold) res.add(cand1);
        if (count2 > threshold) res.add(cand2);

        Collections.sort(res); 
        return res;
    }
}