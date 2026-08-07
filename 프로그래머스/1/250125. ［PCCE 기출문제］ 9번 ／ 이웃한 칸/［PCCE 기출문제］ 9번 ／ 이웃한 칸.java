class Solution {
    
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        int len = board.length;
        
        String cur = board[h][w];
        
        for(int i=0; i<4; i++){
            int ny = h + dy[i];
            int nx = w + dx[i];
            
            if(ny < 0 || ny >= len || nx < 0 || nx >= len) continue;
            if(cur.equals(board[ny][nx])) answer++;
        }
        
        return answer;
    }
}