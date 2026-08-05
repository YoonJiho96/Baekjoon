class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        
        int wMax = Math.max(wallet[0], wallet[1]);
        int wMin = Math.min(wallet[0], wallet[1]);
        
        int bMax = Math.max(bill[0], bill[1]);
        int bMin = Math.min(bill[0], bill[1]);
        
        while(bMax > wMax || bMin > wMin) {
            bMax /= 2;
            answer++;
            
            int tempMax = Math.max(bMax, bMin);
            int tempMin = Math.min(bMax, bMin);
            
            bMax = tempMax;
            bMin = tempMin;
        }
        return answer;
    }
}