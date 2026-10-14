import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        HashSet<Integer> set = new HashSet();
        for(int w : win_nums) {
            if(w != 0) set.add(w);
        }
        
        int count = 0;
        int match = 0;
        for(int l : lottos) {
            if(l == 0) count++;
            else if(set.contains(l)) match++;
        }

        int[] answer = new int[2];
        answer[0] = getRank(count + match);
        answer[1] = getRank(match);
        return answer;
    }
    
    int getRank(int num) {
        return Math.min(7 - num, 6);
    }
}