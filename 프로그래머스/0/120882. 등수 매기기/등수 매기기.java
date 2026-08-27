import java.util.*;

class Solution {
    public int[] solution(int[][] score) {
        
        int len = score.length;
        int[] answer = new int[len];
        Arrays.fill(answer, 1);
        
        for(int i=0; i<len - 1; i++) {
            for(int j=i+1; j<len; j++) {
                int sum1 = score[i][0] + score[i][1];
                int sum2 = score[j][0] + score[j][1];
                
                if(sum1 < sum2) {
                    answer[i]++;
                }else if(sum1 > sum2) {
                    answer[j]++;
                }
            }
        }
        
        return answer;
    }
}