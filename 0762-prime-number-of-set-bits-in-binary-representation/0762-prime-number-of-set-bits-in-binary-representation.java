    class Solution {
        public int countPrimeSetBits(int left, int right) {
            int res = 0;
            String bin = "";
            int b = 0;
            for(int i=left;i<=right;i++){
                bin = Integer.toBinaryString(i);
                b = bin.replace("0","").length();
                if(b == 2|| b == 3||b == 5 || b == 7 || b == 11 || b == 13 || b==17 || b==19)res++;
            }
            return res;  
        }
    }