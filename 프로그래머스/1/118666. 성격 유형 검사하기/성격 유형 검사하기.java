class Solution {
    char[][] info = {{'R', 'T'}, {'C', 'F'}, {'J', 'M'}, {'A', 'N'}};
    
    public String solution(String[] survey, int[] choices) {
        int[] alp = new int[26];
        
        for(int i=0; i<survey.length; i++) {
            String s = survey[i];
            int choice = choices[i];
            
            char type1 = s.charAt(0);
            char type2 = s.charAt(1);
            
            if(choice < 4) {
                int score = 4 - choice;
                alp[type1 - 'A'] += score;
            } else if (choice > 4) {
                int score = choice - 4;
                alp[type2 - 'A'] += score;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(char[] i : info) {
            sb.append(alp[i[0] - 'A'] >= alp[i[1] - 'A'] ? i[0]:i[1]);
        }
        return sb.toString();
    }
}