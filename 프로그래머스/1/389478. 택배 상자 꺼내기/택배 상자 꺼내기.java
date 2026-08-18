class Solution {
    public int solution(int n, int w, int num) {
        int answer = 0;
        
        num--;
        n--;
        
        int row = num / w;
        int col = (row % 2 == 0) ? (num % w) : (w - 1 - (num % w));
        
        int lastRow = n / w;
        int lastCol = (lastRow % 2 == 0) ? (n % w) : (w - 1 - (n % w));
        if(lastRow % 2 == 0) {
            if(col <= lastCol) {
                answer = lastRow;
            }else{
                answer = lastRow - 1;
            }
        }else {
            if(col >= lastCol) {
                answer = lastRow;
            }else {
                answer = lastRow - 1;
            }
        }
        return answer - row + 1;
    }
}