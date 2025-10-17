import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        
        if(triangle.length == 1) {
            return triangle[0][0];
        }
        
        int[][] dp = new int[triangle.length][triangle.length];
        dp[0][0] = triangle[0][0];
        
        for(int i=1; i<triangle.length; i++) {
            for(int j=0; j<=i; j++) {
                if(j-1 >= 0) {
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j-1] + triangle[i][j]);
                }
                dp[i][j] = Math.max(dp[i][j], dp[i-1][j] + triangle[i][j]);
            }
        }
        
        for(int n : dp[triangle.length - 1]) {
            answer = Math.max(answer, n);
        }
        return answer;
    }
}