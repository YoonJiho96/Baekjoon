class Solution {
    public int solution(int chicken) {
        int answer = 0;
        int cp = 0;
        while(chicken / 10 > 0) {
            cp = chicken % 10;
            chicken /= 10;
            answer += chicken;
            chicken += cp;
        }
        return answer;
    }
}