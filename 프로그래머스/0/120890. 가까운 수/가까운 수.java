class Solution {
    public int solution(int[] array, int n) {
        int answer = 0;
        int MIN = Integer.MAX_VALUE;
        
        for(int a : array) {
            int gap = Math.abs(a - n);
            
            if(gap < MIN) {
                MIN = gap;
                answer = a;
            } else if(gap == MIN) {
                answer = Math.min(answer, a);
            }
        }
        
        return answer;
    }
}