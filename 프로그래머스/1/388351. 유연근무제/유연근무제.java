import java.util.*;

class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        
        int[] timelimit = new int[schedules.length];
        
        for(int i=0; i<schedules.length; i++) {
            timelimit[i] = schedules[i] + 10;
            
            int min = timelimit[i] % 100;
            int hour = timelimit[i] / 100 + (min / 60);
            min = min % 60;
            
            timelimit[i] = hour * 100 + min;
        }
        
        for(int i=0; i<schedules.length; i++) {
            boolean valid = true;
            
            for(int j=0; j<7; j++) {
                int today = (startday - 1 + j) % 7;
                
                if(today == 5 || today == 6) continue;
                if(timelimit[i] < timelogs[i][j]) {
                    valid = false;
                    break;
                }
            }
            if(valid) {
                answer++;
            }
        }
        return answer;
    }
}