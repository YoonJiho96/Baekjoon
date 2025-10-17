import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int[] answer = {};
        
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        
        for(int n : arr) {
            if(queue.isEmpty()) {
                queue.offer(n);
            }else {
                int prev = queue.peekLast();
                if(prev == n) {
                    continue;
                } else {
                    queue.offer(n);
                }
            }
        }
        
        answer = new int[queue.size()];
        for (int i=0; i<answer.length; i++) {
            answer[i] = queue.pop();
        }
        
        return answer;
    }
}