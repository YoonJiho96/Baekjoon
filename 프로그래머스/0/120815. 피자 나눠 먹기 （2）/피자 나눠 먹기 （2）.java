class Solution {
    public int solution(int n) {
        int i = 1;        
        while((i * 6) % n != 0) {
            i++;
        }
        
        return i;
    }
}