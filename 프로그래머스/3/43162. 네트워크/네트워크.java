import java.util.*;

class Solution {
    
   
    public int solution(int n, int[][] computers) {
        int answer= 0;
        
        boolean[] check = new boolean[n];
        for(int i=0; i<n; i++) {
            if(check[i]) continue;
            answer++;
            
            ArrayDeque<Integer> queue = new ArrayDeque<>();
            queue.offer(i);
            check[i] = true;
            while(!queue.isEmpty()) {
                int cur = queue.poll();
                for(int j=0; j<n; j++) {
                    if(computers[cur][j] == 1 && !check[j]) {
                        queue.offer(j);
                        check[j] = true;
                    }
                }
            }
        }
        
        return answer;
    }
}