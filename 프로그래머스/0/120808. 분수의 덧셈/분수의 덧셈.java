class Solution {
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        int[] answer = new int[2];
        
        int son1 = numer1 * denom2;
        int son2 = numer2 * denom1;
        int mom = denom1 * denom2;

        answer[0] = (son1 + son2);
        answer[1] = mom;
        
        int g = gcd(answer[0], answer[1]);
        answer[0] /= g;
        answer[1] /= g;
        
        return answer;
    }
    
    int gcd(int a, int b) {
        while(b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
}