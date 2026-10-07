class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        for(int i=1; i<=yellow; i++) {
            if(yellow % i == 0) {
                int w = yellow / i;
                int h = i;
                
                int b = (w + 2) * 2 + h * 2;
                
                if(b == brown) {
                    answer[0] = w + 2;
                    answer[1] = h + 2;
                    break;
                }
            }
        }
        
        return answer;
    }
}