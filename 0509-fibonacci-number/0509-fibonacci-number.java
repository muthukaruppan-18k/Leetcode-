// Using DP, Iterative with 2 Variables.  [ O(n) Time Complexity ]

class Solution {
    public int fib(int n) {
        if (n <= 1) return n;

        int prev2 = 0; // F(0)
        int prev1 = 1; // F(1)

        for (int i = 2; i <= n; i++) {
            int curr = prev1 + prev2;
            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }
}

// Using Recursion

// class Solution {
//     public int fib(int n) {
//         if(n == 0) return 0;
//         if(n == 1) return 1;
//         else return fib(n-1) + fib(n-2);     [ O(2^n) Time Complexity ]
//     }
// }