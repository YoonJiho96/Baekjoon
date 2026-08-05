class Solution {
    public int solution(int[] array) {
        int[] count = new int[1001];
        int MAX = 0;
        for(int n : array) {
            count[n]++;
            MAX = Math.max(count[n], MAX);
        }
        
        int num = 0;
        int answer = 0;
        for(int i = 1; i<=1000; i++) {
            if(count[i] == MAX) {
                num++;
                answer = i;
            }
        }
        
        return num > 1 ? -1:answer;
    }
}