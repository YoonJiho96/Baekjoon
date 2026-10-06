class Solution {
    public int solution(String arr[]) {
        int answer = -1;
        
        int n = (arr.length + 1) / 2;
        int[] numbers = new int[n];
        String[] op = new String[n-1];
        
        for(int i=0; i<arr.length; i++) {
            if(i%2 == 0) {
                numbers[i/2] = Integer.parseInt(arr[i]);
            }else {
                op[i/2] = arr[i];
            }
        }
        
        int[][] minDP = new int[n][n];
        int[][] maxDP = new int[n][n];
        for(int i=0; i<n; i++) {
            minDP[i][i] = numbers[i];
            maxDP[i][i] = numbers[i];
        }
        
        for(int len = 2; len <= n; len++){
            for(int left = 0; left <= n - len; left++){
                int right = left + len - 1;
                
                minDP[left][right] = Integer.MAX_VALUE;
                maxDP[left][right] = Integer.MIN_VALUE;
                
                for(int k=left; k<right; k++) {
                    int min = 0;
                    int max = 0;
                    
                    if(op[k].equals("+")) {
                        min = minDP[left][k] + minDP[k+1][right];
                        max = maxDP[left][k] + maxDP[k+1][right];
                    }else {
                        min = minDP[left][k] - maxDP[k+1][right];
                        max = maxDP[left][k] - minDP[k+1][right];
                    }
                    
                    minDP[left][right] = Math.min(minDP[left][right], min);
                    maxDP[left][right] = Math.max(maxDP[left][right], max);
                }
            }
        }
        
        return maxDP[0][n - 1];
    }
}