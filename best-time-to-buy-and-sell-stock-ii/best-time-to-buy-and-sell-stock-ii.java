class Solution {
    public int maxProfit(int[] prices) {    
        int profit=0,stock=prices[0],ans=0;
        int n = prices.length;
        
        for(int i=1;i<n;i++){
            
            if(prices[i]<stock){
                stock = prices[i];
            }
            
           if(prices[i]>prices[i-1]){
               profit=prices[i]-stock;
               stock = prices[i];
               ans+=profit;
           }
        }
        return ans;
    }
}