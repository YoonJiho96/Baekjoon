import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        ArrayList<Integer>[] list = new ArrayList[n + 1];
        for(int i=1; i<=n; i++) {
            list[i] = new ArrayList<Integer>();
        }
        
        for(int[] wire : wires) {
            int v1 = wire[0];
            int v2 = wire[1];
            list[v1].add(v2);
            list[v2].add(v1);
        }
        
        int gap = Integer.MAX_VALUE;
        for(int[] wire : wires) {
            int v1 = wire[0];
            int v2 = wire[1];
            
            int num = bfs(v1, v2, list);
            gap = Math.min(gap, Math.abs(n - num * 2));
        }
        
        return gap;
    }
    
    static int bfs(int v1, int v2, ArrayList<Integer>[] list) {
        boolean[] visit = new boolean[list.length];
        
        ArrayDeque<Integer> queue = new ArrayDeque();
        queue.offer(v1);
        visit[v1] = true;
        
        int count = 1;
        while(!queue.isEmpty()) {
            int cur = queue.poll();
            
            for(int c : list[cur]) {
                if(visit[c] || c == v2) continue;
                
                queue.offer(c);
                visit[c] = true;
                count++;
            }
        }
        
        return count;
    }
}