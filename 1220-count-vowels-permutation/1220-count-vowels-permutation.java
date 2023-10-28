class Solution {
    int mod = 1000000007;
    public int countVowelPermutation(int n) {
        
        int[][] dp = new int[n][5];
        dp[0][0] = 1;
        dp[0][1] = 1;
        dp[0][2] = 1;
        dp[0][3] = 1;
        dp[0][4] = 1;
        
        for(int i = 1; i < n; i++) {
            dp[i][1] += dp[i-1][0]; // a -> ae
            
            dp[i][0] += dp[i-1][1]; // e -> ea
            dp[i][2] += dp[i-1][1]; // e -> ei
            
            dp[i][0] += dp[i-1][2]; // i -> ia
            dp[i][1] += dp[i-1][2]; // i -> ie
            dp[i][3] += dp[i-1][2]; // i -> io
            dp[i][4] += dp[i-1][2]; // i -> iu
            
            dp[i][2] += dp[i-1][3]; // o -> oi
            dp[i][4] += dp[i-1][3]; // o -> ou
            
            dp[i][0] %= mod; // As a general rule, max int is bigger than twice (10⁹ + 7), but smaller than three times that number. We are safe adding two values, but risk overflow with a third.
            dp[i][0] += dp[i-1][4]; // u -> ua
            
            for(int j = 0; j < 5; j++) {
                dp[i][j] %= mod;
            }
        }
        
        int ans = 0;
        for(int i = 0; i < 5; i++) {
            ans = (ans + dp[n-1][i])%mod;
        }
        return ans;
    }
}