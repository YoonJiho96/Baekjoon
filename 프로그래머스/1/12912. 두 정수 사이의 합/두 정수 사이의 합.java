class Solution {
    public long solution(int a, int b) {
        if(a > b) {
            a ^= b;
            b ^= a;
            a ^= b;
        }
        return (long) (a + b) * (b - a + 1) / 2;
    }
}