class Solution {
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    
    public int[] solution(String[] keyinput, int[] board) {      
        int dir = 0;
        int[] cur = {board[0] / 2, board[1] / 2};
        
        System.out.println(cur[0] + ", " + cur[1]);
        
        for(String k : keyinput) {
            if(k.equals("up")) dir = 1;
            else if(k.equals("down")) dir = 0;
            else if(k.equals("left")) dir = 2;
            else if(k.equals("right")) dir = 3;
            
            int nx = cur[0] + dx[dir];
            int ny = cur[1] + dy[dir];
            
            if(ny < 0 || nx < 0 || ny >= board[1] || nx >= board[0]) continue;
            cur[0] = nx;
            cur[1] = ny;
        }
        cur[0] -= board[0]/2;
        cur[1] -= board[1]/2;
        
        return cur;
    }
}