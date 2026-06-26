class Solution {
    public int minSubArrayLen(int target, int[] nums) {

        int left = 0;
        int sum = 0;
        int minLength = Integer.MAX_VALUE;

        for (int right = 0; right < nums.length; right++) {

            // Add current element
            sum += nums[right];

            // Shrink the window while sum >= target
            while (sum >= target) {

                minLength = Math.min(minLength, right - left + 1);

                sum -= nums[left];
                left++;
            }
        }

        // If no valid subarray found
        if (minLength == Integer.MAX_VALUE) {
            return 0;
        }

        return minLength;
    }
}