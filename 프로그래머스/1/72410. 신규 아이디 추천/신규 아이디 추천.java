class Solution {
    public String solution(String new_id) {
        String answer = new_id.toLowerCase();

        answer = answer.replaceAll("[^a-z0-9._-]", "");
        answer = answer.replaceAll("\\.+", ".");
        answer = answer.replaceAll("^\\.|\\.$", "");
        answer = answer.isEmpty() ? "a" : answer;
        answer = answer.substring(0, Math.min(15, answer.length()));

        answer = answer.charAt(answer.length() - 1) == '.'
                ? answer.substring(0, answer.length() - 1)
                : answer;

        while (answer.length() < 3) {
            answer += answer.charAt(answer.length() - 1);
        }

        return answer;
    }
}