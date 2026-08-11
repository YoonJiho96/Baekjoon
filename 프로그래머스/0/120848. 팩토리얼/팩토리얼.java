class Solution {
    public int solution(int n) {
        int fac = 1;
        int i = 1;
        
        while (fac <= n) {
            i++;
            fac *= i;
        }
        
        return i - 1;
    }
}