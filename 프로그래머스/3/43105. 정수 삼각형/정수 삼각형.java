import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int len = triangle.length;
        
        int[][] dp = new int[len+1][len+1];
        dp[1][1] = triangle[0][0];
        
        for(int i=2; i<=len; i++) {
            for(int j=1; j<=i; j++) {
                int left = dp[i-1][j-1];
                int right = dp[i-1][j];
                
                dp[i][j] = Math.max(left, right) + triangle[i-1][j-1];
            }
        }
        
        int answer = 0;
        for(int i=0; i<=len; i++) {
            answer = Math.max(dp[len][i], answer);
        }
        
        return answer;
    }
}