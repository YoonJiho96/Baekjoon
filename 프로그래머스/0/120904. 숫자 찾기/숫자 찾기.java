class Solution {
    public int solution(int num, int k) {
        char[] numStr = String.valueOf(num).toCharArray();
        
        for(int i=0; i<numStr.length; i++) {
            if(numStr[i] == (char)('0' + k)) {
                return i + 1;
            }
        }
        
        return -1;
    }
}