class Solution {
    public String solution(String my_string, String overwrite_string, int s) {
        String answer = "";
        
        char[] my = my_string.toCharArray();
        char[] over = overwrite_string.toCharArray();
        
        for(int i=0; i<over.length; i++) {
            my[i + s] = over[i];
        }
        
        return String.valueOf(my);
    }
}