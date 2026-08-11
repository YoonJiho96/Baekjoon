class Solution {
    public int solution(int[] numbers, int k) {
        int idx = ((k - 1) * 2) % numbers.length;
        return numbers[idx];
    }
}