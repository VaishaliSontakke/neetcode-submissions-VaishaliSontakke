class Solution {
    public int maxProfit(int[] prices) {
        int l = 0;
        int profit = 0;
        for(int r = 0; r < prices.length; r++){
            // bought at lesser price sold at heigher.
            int currProfit = prices[r] - prices[l];
            while(currProfit < 0 && (l<r)){
                l++;
                currProfit = prices[r] - prices[l];
            }
            profit = Math.max(profit, currProfit);
        }
        return profit;
        
    }
}
