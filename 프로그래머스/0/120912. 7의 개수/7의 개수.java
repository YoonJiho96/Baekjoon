class Solution {
    public int solution(int[] array) {
        int answer = 0;
        for(int n : array) {
            char[] str = String.valueOf(n).toCharArray();
            for(char c : str) {
                if(c == '7') answer++;
            }
        }
        return answer;
    }
}