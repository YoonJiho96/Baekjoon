class Solution {
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};
    
    public int[][] solution(int n) {
        int[][] answer = new int[n][n];
        
        int dir = 0;
        int y = 0;
        int x = 0;
        
        for(int i=1; i<=n*n; i++) {
            answer[y][x] = i;
            
            int ny = y + dy[dir];
            int nx = x + dx[dir];
            
            if(ny < 0 || ny >= n || nx < 0 || nx >= n || answer[ny][nx] != 0) {
                dir = (dir + 1) % 4;
                ny = y + dy[dir];
                nx = x + dx[dir];
            }
            
            y = ny;
            x = nx;
        }
        
        return answer;
    }
}