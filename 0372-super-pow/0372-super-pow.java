class Solution {
    public int superPow(int a, int[] b) {
        long k=0;
        for(int i=0;i<b.length;i++)
        {
            k=k*10+b[i];
            k=k%1140;
        }
        int ans=1;
        a=a%1337;
        k=k%1140;
        while(k>0)
        {
            if(k%2==1)
                ans=((ans%1337)*(a%1337))%1337;
            a=((a%1337)*(a%1337))%1337;
            k/=2;
        }
        return ans%1337;
    }
}