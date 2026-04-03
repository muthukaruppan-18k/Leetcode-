class Solution {
    private boolean isAlphaNum(char ch){
        if(ch>='a'&&ch<='z')return true;
        if(ch>='0'&&ch<='9')return true;
        return false;
    }
    public boolean isPalindrome(String s) {
        s=s.toLowerCase();
        int i=0,j=s.length()-1;
        while(i<j){
            while(i<j&&!isAlphaNum(s.charAt(i)))i++;
            while(j>i&&!isAlphaNum(s.charAt(j)))j--;
            if(s.charAt(i)==s.charAt(j)){
                i++;
                j--;
            }else{
                return false;
            }
        }   
        return true;
    }
}