class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[src] = 0;

        for (int i = 0; i <= k; i++) {
            
            int[] temp = Arrays.copyOf(dp, n);
        
            for (int[] flight : flights) {
                
                if (dp[flight[0]] != Integer.MAX_VALUE) {
                    temp[flight[1]] = Math.min(temp[flight[1]], dp[flight[0]] + flight[2]);
                }
            }
            
            dp = temp;
        }
        
        return dp[dst] == Integer.MAX_VALUE ? -1 : dp[dst];
    }
}