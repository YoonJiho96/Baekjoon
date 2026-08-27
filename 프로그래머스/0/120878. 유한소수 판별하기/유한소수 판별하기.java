class Solution {
    public int solution(int a, int b) {
        int answer = 0;
        
        int gcd = GCD(a, b);
        int B = b / gcd;
        
        while(B % 2 == 0) {
            B /= 2;
        }
        
        while(B % 5 == 0) {
            B /= 5;
        }
        
        return B == 1 ? 1:2;
    }
    
    int GCD(int a, int b) {
        while(b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}