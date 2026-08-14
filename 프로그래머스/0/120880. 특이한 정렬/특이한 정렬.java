import java.util.*;

class Solution {
    public int[] solution(int[] numlist, int n) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> 
                                                        (Math.abs(a-n) == Math.abs(b-n)?
                                                         (b-a):(Math.abs(a-n) - Math.abs(b-n))));
        for(int num : numlist){
            pq.offer(num);
        }
        
        int[] answer = new int[numlist.length];
        for(int i=0; i<answer.length; i++) {
            answer[i] = pq.poll();
        }
        
        return answer;
    }
}