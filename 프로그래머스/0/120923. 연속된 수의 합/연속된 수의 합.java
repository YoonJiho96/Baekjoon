class Solution {
    public int[] solution(int num, int total) {
        int[] answer = new int[num];
        
        int sum = 0;
        for(int i=0; i<num; i++) {
            sum += i;
        }
        
        int start = (total - sum) / num;
        for(int i=0; i<num; i++) {
            answer[i] = start + i;
        }
        
        return answer;
    }
}