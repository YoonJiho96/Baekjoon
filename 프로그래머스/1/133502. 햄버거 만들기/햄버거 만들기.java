class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        
        int len = ingredient.length;
        
        int[] check = new int[len];
        int idx = 0;
        
        for(int i : ingredient) {
            check[idx++] = i;
            
            if(idx >= 4) {
                if(check[idx - 4] == 1 &&
                  check[idx - 3] == 2 &&
                  check[idx - 2] == 3 &&
                  check[idx - 1] == 1) {
                    answer++;
                    idx -= 4;
                }
            }
        }
        
        return answer;
    }
}