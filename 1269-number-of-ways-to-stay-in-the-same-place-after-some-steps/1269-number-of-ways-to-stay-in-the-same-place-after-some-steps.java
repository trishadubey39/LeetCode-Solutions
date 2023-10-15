class Solution {
    public int numWays(int steps, int arrLen) {
        int mod=(int) 1e9 + 7;
        arrLen=Math.min(steps,arrLen);

        int[][] dp=new int[steps+1][arrLen];
        dp[0][0]=1;
        for(int i=1;i<=steps;i++){
            for(int j=arrLen-1;j>=0;j--){
                int right=0,left=0,stay=0;
                if(j<arrLen-1) right=dp[i-1][j+1];
                if(j>0) left=dp[i-1][j-1];
                stay=dp[i-1][j];
                dp[i][j]=((right%mod+left%mod)%mod+stay)%mod;
            }
        }
        return dp[steps][0];
    }
}