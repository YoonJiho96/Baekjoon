class Solution {
    public int solution(int n) {
        int temp = (int) Math.sqrt(n);
        return temp*temp == n ? 1:2;
    }
}