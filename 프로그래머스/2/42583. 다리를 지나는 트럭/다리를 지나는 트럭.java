import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 0;
        
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for(int i = 0; i<bridge_length; i++) {
            queue.offer(0);
        }
        
        int truckIdx = 0;
        int sum = 0;
        
        while(truckIdx < truck_weights.length) {
            time++;
            sum -= queue.poll();
            
            int next = truck_weights[truckIdx];
            if(sum + next <= weight) {
                queue.offer(next);
                sum += next;
                truckIdx++;
            } else {
                queue.offer(0);
            }
        }
        
        return time + bridge_length;
    }
}