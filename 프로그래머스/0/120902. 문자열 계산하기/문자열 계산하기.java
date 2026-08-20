class Solution {
    public int solution(String my_string) {
        int answer = 0;
        int op = 1;
        
        String[] str = my_string.split(" ");
        for(int i=0; i<str.length; i++) {
            if(str[i].equals("-")) {
                op = -1;
            }else if(str[i].equals("+")) {
                op = 1;
            }else {
                answer += Integer.parseInt(str[i]) * op;
            }
        }
        return answer;
    }
}