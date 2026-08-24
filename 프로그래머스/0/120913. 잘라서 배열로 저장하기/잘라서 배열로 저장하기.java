class Solution {
    public String[] solution(String my_str, int n) {
        String[] answer = new String[(my_str.length() -1)/n + 1];
        
        int idx = 0;
        
        for(int i=0; i<answer.length; i++) {
            answer[i] = my_str.substring(idx, Math.min(idx + n, my_str.length()));
            idx += n;
        }
        
        return answer;
    }
}