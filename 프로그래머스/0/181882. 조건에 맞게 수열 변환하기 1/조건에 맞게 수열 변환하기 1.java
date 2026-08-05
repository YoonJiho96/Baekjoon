class Solution {
    public int[] solution(int[] arr) {
        int[] answer = new int[arr.length];
        
        for(int i=0; i<answer.length; i++) {
            int cur = arr[i];
            answer[i] = cur;
            if(cur >= 50 && (cur % 2 == 0)) {
                answer[i] = cur/2;
            }else if(cur < 50 && (cur % 2 != 0)) {
                answer[i] = cur * 2;
            }
        }
        
        return answer;
    }
}