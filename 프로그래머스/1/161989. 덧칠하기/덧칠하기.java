class Solution {
    public int solution(int n, int m, int[] section) {
        int[] wall = new int[n + 1];
        for(int s : section) {
            wall[s] = 1;
        }

        int answer = 0;
        for(int i=1; i<=n; i++) {
            if(wall[i] == 1) {
                for(int j=i; j<Math.min(n, i+m); j++) {
                    wall[j] = 1;
                }
                i = i + m - 1;
                answer++;
            }
        }
        
        return answer;
    }
}