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
        int n = intervals.size();
        Collections.sort(intervals, (a,b) -> {
            if(a.start == b.start) return a.end - b.end;
            else return a.start - b.start;
        });
        int max = 0;
        PriorityQueue<Integer> q = new PriorityQueue<>((a,b) -> a-b);
        for(int i=0; i<n; i++){
            //koi meeting nhi h ek room lelo
            if(q.size() == 0){
                q.offer(intervals.get(i).end);
                max = Math.max(max, q.size());
                continue;
            }
            //yeh meeting hua isko khaali karo
            while(q.size()>0 && q.peek() <= intervals.get(i).start){
                q.poll();
            }
            //meeting shuru karo
            q.offer(intervals.get(i).end);
            max = Math.max(max, q.size());
        }
        return max;
    }
}
