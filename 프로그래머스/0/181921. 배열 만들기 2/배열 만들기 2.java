import java.util.*;

class Solution {
    public int[] solution(int l, int r) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.offer(5);
        
        ArrayDeque<Integer> answer = new ArrayDeque<>();
        while(!queue.isEmpty()) {
            int num = queue.poll();
            
            if(num >= l) answer.offer(num);
            
            int next1 = num*10;
            int next2 = num*10 + 5;
            if(next1 <= r) queue.offer(next1);
            if(next2 <= r) queue.offer(next2);
        }
        
        if(answer.isEmpty()) answer.offer(-1);
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}