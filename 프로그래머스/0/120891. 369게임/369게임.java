class Solution {
    public int solution(int order) {
        int answer = 0;
        
        char[] str = String.valueOf(order).toCharArray();
        for(char c : str) {
            int n = c - '0';
            if(n!=0 && n%3 ==0) {
                answer++;
            }
        }
        
        return answer;
    }
}