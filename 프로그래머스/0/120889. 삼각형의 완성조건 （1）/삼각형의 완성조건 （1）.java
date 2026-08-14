class Solution {
    public int solution(int[] sides) {
        int MAX = 0;
        int sum = 0;
        
        for(int n : sides) {
            sum += n;
            MAX = Math.max(MAX, n);
        }
        
        return sum - MAX > MAX ? 1:2;
    }
}