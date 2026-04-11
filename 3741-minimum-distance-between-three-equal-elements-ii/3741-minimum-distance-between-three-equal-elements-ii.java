
class Solution {
    public int minimumDistance(int[] nums) {
        // Map to store indices of each number
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        // Collect indices for each number
        for (int i = 0; i < nums.length; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }
        
        int minDistance = Integer.MAX_VALUE;
        
        // Check each list of indices
        for (List<Integer> indices : map.values()) {
            if (indices.size() >= 3) {
                // Only need to check consecutive triples
                for (int i = 0; i + 2 < indices.size(); i++) {
                    int a = indices.get(i);
                    int b = indices.get(i + 1);
                    int c = indices.get(i + 2);
                    
                    // Calculate distance
                    int distance = Math.abs(a - b) + Math.abs(b - c) + Math.abs(c - a);
                    minDistance = Math.min(minDistance, distance);
                }
            }
        }
        
        return minDistance == Integer.MAX_VALUE ? -1 : minDistance;
    }
}
