import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        // Start from the lowest lexicographical order
        Arrays.sort(nums);
        
        do {
            // Convert current array state to a list and save
            List<Integer> current = new ArrayList<>(nums.length);
            for (int num : nums) {
                current.add(num);
            }
            result.add(current);
        } while (nextPermutation(nums)); // Modify array in-place to the next unique layout
        
        return result;
    }

    private boolean nextPermutation(int[] nums) {
        int n = nums.length;
        int i = n - 2;
        
        // 1. Find the first decreasing element from the right
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        
        // If no such element is found, we have reached the last permutation
        if (i < 0) {
            return false;
        }
        
        // 2. Find the next larger element than nums[i] from the right
        int j = n - 1;
        while (nums[j] <= nums[i]) {
            j--;
        }
        
        // 3. Swap them
        swap(nums, i, j);
        
        // 4. Reverse everything to the right of index i to get the next smallest sequence
        reverse(nums, i + 1, n - 1);
        return true;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start++, end--);
        }
    }
}
