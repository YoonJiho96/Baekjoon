import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        
        Arrays.sort(times);
        
        long left = 1;
        answer = (long) times[times.length - 1] * n;
        
        while(left < answer) {
            long mid = (left + answer) / 2;
            long sum = 0;

            for (int time : times) {
                sum += mid / time;
                if (sum >= n) break; 
            }

            if (sum >= n) {
                answer = mid;
            } 
            else {
                left = mid + 1;
            }
        }
        
        return answer;
    }
}