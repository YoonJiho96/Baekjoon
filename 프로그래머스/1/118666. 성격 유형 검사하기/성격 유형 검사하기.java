class Solution {
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
        sb.append(alp['R' - 'A'] >= alp['T' - 'A'] ? "R":"T");
        sb.append(alp['C' - 'A'] >= alp['F' - 'A'] ? "C":"F");
        sb.append(alp['J' - 'A'] >= alp['M' - 'A'] ? "J":"M");
        sb.append(alp['A' - 'A'] >= alp['N' - 'A'] ? "A":"N");
        return sb.toString();
    }
}