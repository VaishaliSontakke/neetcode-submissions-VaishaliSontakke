/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        // keep ends of meeting in minheap. if 
        if(intervals.size() == 0){
            return 0;
        }
        
        if(intervals.size() == 1){
            return 1;
        }

        intervals.sort( (a,b) -> (a.start - b.start));
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // add end to priorityQueue
        pq.add(intervals.get(0).end);
        // 40 // 10 40
        for(int i=1; i< intervals.size(); i++){
            //Start of this meeting is higher than or equal to lowest end in heap
            if(intervals.get(i).start >= pq.peek()){
                pq.poll();
            }
            pq.add(intervals.get(i).end);
        }
        return pq.size();
    }
}
