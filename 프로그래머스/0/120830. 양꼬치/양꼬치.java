class Solution {
    public int solution(int n, int k) {
        int service = n / 10;
        int drink = k - service;
        return 12000 * n + 2000 * drink;
    }
}