class Solution {
    public int solution(int[][] signals) {
        int answer = 0;
        int MAX = 1;
        int[] cycles = new int[signals.length];
        
        for(int i=0; i<signals.length; i++) {
            int sum = 0;
            for(int j=0; j<signals[i].length; j++) {
                sum += signals[i][j];
            }
            cycles[i] = sum;
            MAX *= sum;
        }
        
        boolean valid = true;
        for(int i=0; i<MAX; i++) {
            valid = true;
            for(int j=0; j<signals.length; j++) {
                int t = i % cycles[j];
                if(t >= signals[j][0] && t < signals[j][0] + signals[j][1]) {
                       
                } else {
                    valid = false;
                    break;
                }
            }
            
            if(valid) {
                answer = i + 1;
                break;
            }
        }

        if(!valid) {
            answer = -1;
        }
        
        return answer;
    }
}