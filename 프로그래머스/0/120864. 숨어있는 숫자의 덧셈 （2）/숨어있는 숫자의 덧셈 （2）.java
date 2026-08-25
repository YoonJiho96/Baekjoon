class Solution {
    public int solution(String my_string) {
        int answer = 0;
        String[] nums = my_string.split("[a-zA-Z]+");
        for(String num : nums) {
            if(!num.isEmpty()) answer += Integer.parseInt(num);
        }
        return answer;
    }
}