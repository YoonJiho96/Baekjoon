class Solution {
    public int solution(int M, int N) {
        int answer = 0;
        
        if(M > N) {
            int temp = M;
            M = N;
            N = temp;
        }

        answer = M * (N - 1) + (M - 1);
        return answer;
    }
}