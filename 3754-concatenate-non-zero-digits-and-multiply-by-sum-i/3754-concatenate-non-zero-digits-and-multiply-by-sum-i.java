class Solution {     
    public long sumAndMultiply(int n) {         
        int num=0;         
        int rem=0;         
        int sum=0;         
        int sum2=0;         
        while(n!=0){             
            rem=n%10;             
            if(rem!=0){                 
                sum*=10;                 
                System.out.println(rem);                 
                sum2+=rem;                 
                sum+=rem;             
            }             
            n=n/10;         
        }         
        while(sum!=0){
            num=(num*10)+(sum%10);
            sum=sum/10;
        }
        return (long) num*sum2;   
    } 
}