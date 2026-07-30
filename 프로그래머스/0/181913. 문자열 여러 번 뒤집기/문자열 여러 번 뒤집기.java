class Solution {
    public String solution(String my_string, int[][] queries) {
        String answer = "";
        
        char[] str = my_string.toCharArray();
        
        for(int[] query : queries) {
            int left = query[0];
            int right = query[1];
            
            while(left < right) {
                char temp = str[left];
                str[left] = str[right];
                str[right] = temp;
                
                left++;
                right--;
            }
        }
        return String.valueOf(str);
    }
}