class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);
        int m = piles[piles.length-1];   // get maximum element from piles.
        // answer lies in 1 to max(element from piles).
        // 1 to m -> largest size of pile.
        // check half 1+m/2  1+4 /2  2
        int l= 1, r = m, result= 1;
        
        while(l<=r){
            int mid = (l+r)/2;
            int midHours = getHours(piles, mid);
            // speed low hours will be more, speed high hours will be low.
            if(midHours <= h){
                result = mid;
                r = mid -1;   // increase hours hence reduce speed
            } else {
                l = mid + 1;  // decrease hours hence increase speed.
            }
        }
        return result;  
    }

    public int getHours(int[] piles, int speed){
        int hours=0;
        for(int pile: piles){
            if(pile%speed == 0){
                hours += pile/speed;
                continue;
            } 
            hours += pile/speed + 1;
            
        }
        return hours;
    }
}
