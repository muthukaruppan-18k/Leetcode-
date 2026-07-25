class Solution {
    private int count = 0;

    public int totalNQueens(int n) {
        count = 0;
        // Bitmasks track occupied columns, main diagonals, and anti-diagonals
        backtrack(0, n, 0, 0, 0);
        return count;
    }

    private void backtrack(int row, int n, int cols, int diag1, int diag2) {
        // Base case: all rows successfully filled
        if (row == n) {
            count++;
            return;
        }

        // Get all available positions in the current row
        // (1 << n) - 1 creates a mask of n ones
        int availablePositions = ((1 << n) - 1) & ~(cols | diag1 | diag2);

        while (availablePositions > 0) {
            // Extract the lowest set bit (position to place queen)
            int position = availablePositions & -availablePositions;
            
            // Clear this bit from available positions
            availablePositions -= position;

            // Recurse to the next row, shifting diagonal masks accordingly
            backtrack(row + 1, n, 
                cols | position, 
                (diag1 | position) << 1, 
                (diag2 | position) >>> 1
            );
        }
    }
}
