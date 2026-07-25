import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        // 1. Sort the array to group duplicate values together
        Arrays.sort(candidates);
        backtrack(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> current, int[] candidates, int remain, int start) {
        // Base case: if remainder hits exactly 0, a valid combination is found
        if (remain == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            // Pruning: if the current element is larger than the remainder, stop exploring this branch
            if (candidates[i] > remain) {
                break;
            }

            // Skip duplicate elements at the same recursion depth to avoid duplicate combinations
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }

            current.add(candidates[i]); // Choose the element
            
            // Recurse with i + 1 because each element can only be used once
            backtrack(result, current, candidates, remain - candidates[i], i + 1);
            
            current.remove(current.size() - 1); // Backtrack
        }
    }
}
