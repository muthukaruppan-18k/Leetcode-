import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> current, int[] candidates, int remain, int start) {
        // Base case: if remainder is less than 0, this branch is invalid
        if (remain < 0) {
            return;
        }
        // Base case: if remainder hits exactly 0, a valid combination is found
        if (remain == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        // Explore further options starting from the current index to prevent duplicates
        for (int i = start; i < candidates.length; i++) {
            current.add(candidates[i]); // Choose the element
            
            // Recurse with updated remainder; pass 'i' as start to allow element reuse
            backtrack(result, current, candidates, remain - candidates[i], i);
            
            current.remove(current.size() - 1); // Backtrack and remove the element
        }
    }
}
