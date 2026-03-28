class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        int i=0,j=0;
        int count = 0;
        while(i<jewels.length()){
            
            if(jewels.charAt(i) == stones.charAt(j)) 
            {
                count++;
            }
            j++;
            if(j > stones.length()-1){
                j=0;
                i++;

            }
        }
        return count;
    }
}