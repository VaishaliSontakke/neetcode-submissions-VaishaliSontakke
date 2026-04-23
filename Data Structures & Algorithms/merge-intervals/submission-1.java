class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        ArrayList<int[]> mergedInt = new ArrayList<>();
        if(intervals.length < 1){
            return intervals;
        }
        mergedInt.add(intervals[0]);
        for(int i=1; i< intervals.length; i++){
            // currentstart <= earlier end then merge end to max of both ends
            if(intervals[i][0] <= mergedInt.get(mergedInt.size()-1)[1]){
                mergedInt.get(mergedInt.size()-1)[1] = Math.max ( intervals[i][1],
                mergedInt.get(mergedInt.size()-1)[1] );
                continue; 
            }
            mergedInt.add(intervals[i]);
        }

        int[][] result = mergedInt.toArray(new int[mergedInt.size()][]);
        return result;
    }
}
