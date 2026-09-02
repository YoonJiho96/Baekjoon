class Solution {
    public int solution(int i, int j, int k) {
        int answer = 0;
        
        for(int s=i; s<=j; s++) {
            for(char c : String.valueOf(s).toCharArray()) {
                if(c - '0' == k) {
                    answer++;
                }
            }
        }
        
        return answer;
    }
}