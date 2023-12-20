class Solution {
    public int buyChoco(int[] prices, int money) {
        Arrays.sort(prices);
        if((prices[0]+prices[1])<=money){
            money-= (prices[0]+prices[1]);
        }
        return money;
        
    }
}