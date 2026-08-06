class Solution {
    public int solution(int[] mats, String[][] park) {
        int max = 0;
        int r = park.length;
        int c = park[0].length;
        
        int[][] dp = new int[r + 1][c + 1];
        
        for(int i=0; i<r; i++) {
            for(int j=0; j<c; j++) {
                if(park[i][j].equals("-1")) {
                    dp[i+1][j+1] = Math.min(dp[i][j+1], Math.min(dp[i+1][j], dp[i][j])) + 1;
                    max = Math.max(max, dp[i+1][j+1]);
                }
            }
        }
        
        int answer = -1;
        for(int mat : mats) {
            if(mat <= max && mat > answer) {
                answer = mat;
            }
        }
        
        return answer;
    }
}