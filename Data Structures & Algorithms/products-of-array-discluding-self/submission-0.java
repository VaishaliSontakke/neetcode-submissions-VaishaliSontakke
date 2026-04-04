class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] products = new int[nums.length];
        int currProd = 1;
        for(int i=0; i< nums.length; i++){
            products[i] = currProd;
            currProd = currProd*nums[i];
        }
        currProd = 1;
        for(int i=nums.length-1; i >= 0; i--){
            products[i] = products[i] * currProd;
            currProd = currProd * nums[i]; 
        }
        return products;
        
    }
}  
