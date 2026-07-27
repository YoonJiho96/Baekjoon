import java.util.*;

class Solution {
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    
    public int solution(int[][] maps) {
        int answer = 0;
        
        boolean[][] visit = new boolean[maps.length][maps[0].length];
        
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {0, 0, 1});
        visit[0][0] = true;
                
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int y = cur[0];
            int x = cur[1];
            int count = cur[2];
            
            for(int i=0; i<4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                
                if(ny < 0 || ny >= maps.length || nx < 0 || nx >= maps[0].length) {
                    continue;
                }
                
                if(maps[ny][nx] == 0) {
                    continue;
                }
                
                if(visit[ny][nx]) 
                    continue;
                
                if(ny == (maps.length - 1) && nx == (maps[0].length - 1)) {
                    return count + 1;
                }
                
                visit[ny][nx] = true;
                queue.offer(new int[] {ny, nx, count+1});
            }
        }
        return -1;
    }
}