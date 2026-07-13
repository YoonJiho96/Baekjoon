import java.util.*;

class Solution {
    int[][] patterns = {
        {1, 2, 3, 4, 5},
        {2, 1, 2, 3, 2, 4, 2, 5},
        {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
    };
    
    public int[] solution(int[] answers) {       
        int[] scores = new int[3];
        for(int i=0; i<answers.length; i++) {
            for(int j=0; j<patterns.length; j++) {
                if(answers[i] == patterns[j][i % patterns[j].length]) {
                    scores[j]++;
                }
            }    
        }
        
        int MAX = Arrays.stream(scores).max().getAsInt();
        
        List<Integer> results = new ArrayList<>();
        for(int i=0; i<scores.length; i++) {
            if(scores[i] == MAX) 
                results.add(i + 1);
        }
        
        int[] answer = new int[results.size()];
        for(int i=0; i<answer.length; i++) {
            answer[i] = results.get(i);
        }
        return answer;
    }
}