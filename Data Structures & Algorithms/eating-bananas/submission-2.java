class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);
        int m = piles[piles.length-1];
        // 1 to m -> largest size of pile.
        // check half 1+m/2  1+4 /2  2
        int l= 1, r = m, result= 1;
        
        while(l<=r){
            int mid = (l+r)/2;
            int midHours = getHours(piles, mid);
            if(midHours <= h){
                result = mid;
                r = mid -1;
            } else {
                l = mid + 1;
            }
        }
        return result;  
    }

    public int getHours(int[] piles, int mid){
        int hours=0;
        for(int i=0; i < piles.length; i++){
            int j = piles[i];
            if(j%mid == 0){
                hours = hours + j/mid;
                continue;
            } 
            hours = hours + j/mid + 1;
            
        }
        return hours;
    }
}
