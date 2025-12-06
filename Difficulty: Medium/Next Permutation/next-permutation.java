class Solution {

    void nextPermutation(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }

        int n = nums.length;
        int index1 = -1;

        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                index1 = i;
                break;
            }
        }

        if (index1 == -1) {
            reverse(nums, 0, n - 1);
            return;
        }

        for (int j = n - 1; j > index1; j--) {   // FIX: j > index1, not >=
            if (nums[j] > nums[index1]) {
                swap(nums, index1, j);
                break;
            }
        }

        reverse(nums, index1 + 1, n - 1);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }
}