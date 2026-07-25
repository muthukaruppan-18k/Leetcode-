import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        backtrack(result, new ArrayList<>(), nums, visited);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> current, int[] nums, boolean[] visited) {
        // Base case: if the current permutation contains all elements, save it
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // Skip the element if it's already included in the current permutation
            if (visited[i]) {
                continue;
            }

            // Choose the element
            visited[i] = true;
            current.add(nums[i]);

            // Recurse to build the next position
            backtrack(result, current, nums, visited);

            // Backtrack: undo choices for the next iteration branches
            current.remove(current.size() - 1);
            visited[i] = false;
        }
    }
}
