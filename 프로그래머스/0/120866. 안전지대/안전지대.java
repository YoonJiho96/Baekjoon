class Solution {
    public int solution(int[][] board) {
        int answer = 0;
        int n = board.length;
        
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++) {
                for(int k=-1; k<=1; k++) {
                    for(int l=-1; l<=1; l++) {
                        if(board[i][j] != 1) continue;
                        int ny = i + k;
                        int nx = j + l;
                        
                        if(ny < 0 || ny >= n || nx < 0 || nx >= n) continue;
                        if(board[ny][nx] == 0) board[ny][nx] = 2;
                    }
                }
            }
        }
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(board[i][j] == 0) answer++;
            }
        }
        
        return answer;
    }
}