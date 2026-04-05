class Solution {
    public int maxProfit(int[] prices) {
        int l=0;
        int maxProfit=0;
        for(int r=0; r < prices.length; r++){
            int profit = prices[r]- prices[l];
            while(profit < 0 && l<r){
                l++;
                continue;
            }
            maxProfit = Math.max(profit, maxProfit);
        }
        return maxProfit;
    }
}
