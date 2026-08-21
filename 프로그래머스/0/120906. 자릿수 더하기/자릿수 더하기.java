class Solution {
    public int solution(int n) {
        int answer = 0;
        
        for(char c : String.valueOf(n).toCharArray()) {
            answer += (int)(c - '0');
        }
        
        return answer;
    }
}