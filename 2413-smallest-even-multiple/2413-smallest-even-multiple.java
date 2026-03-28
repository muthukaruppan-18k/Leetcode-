class Solution {
    public int smallestEvenMultiple(int n) {
        int m;
        if(n%2==0) return n;
        else m=n+n;
        return m;
    }
}