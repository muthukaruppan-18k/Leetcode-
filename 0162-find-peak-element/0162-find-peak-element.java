class Solution {
    public int findPeakElement(int[] nums) {

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {

            int mid = (left + right) / 2;

            // Peak is on the right side
            if (nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            }

            // Peak is on the left side (including mid)
            else {
                right = mid;
            }
        }

        return left;
    }
}