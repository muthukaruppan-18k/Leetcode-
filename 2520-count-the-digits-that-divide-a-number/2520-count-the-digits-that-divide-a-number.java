class Solution {
    public int countDigits(int num) {
        int temp = num;
        int rem = 0;
        int count= 0;
        while(num!=0){
            rem = num%10;
            if(temp%rem==0) count++;
            num=num/10;
        }
        return count;
    }
}