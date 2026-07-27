import java.util.*;

class Solution {
    public int solution(String message, int[][] spoiler_ranges) {
        int answer = 0;
        
        ArrayList<Word> list = new ArrayList<>();

        String[] words = message.split(" ");
        int currentIdx = 0;

        for (String s : words) {
            if (s.isEmpty()) continue; 
            
            int startIdx = message.indexOf(s, currentIdx);
            int endIdx = startIdx + s.length() - 1;

            list.add(new Word(s, startIdx, endIdx, false));

            currentIdx = endIdx + 1; 
        }
        
        for (Word w : list) {
            for (int[] range : spoiler_ranges) {
                if (w.end >= range[0] && w.start <= range[1]) {
                    w.isSpoiler = true;
                    break;
                }
            }
        }

        HashSet<String> nonSpoilerSet = new HashSet<>();
        for (Word w : list) {
            if (!w.isSpoiler) {
                nonSpoilerSet.add(w.str);
            }
        }

        HashSet<String> revealed = new HashSet<>();
        for (Word w : list) {
            if (w.isSpoiler && !nonSpoilerSet.contains(w.str) && !revealed.contains(w.str)) {
                answer++;
                revealed.add(w.str);
            }
        }
        
        return answer;
    }
    
    class Word {
        String str;
        int start;
        int end;
        boolean isSpoiler;
        
        Word(String str, int start, int end, boolean isSpoiler) {
            this.str = str;
            this.start = start;
            this.end = end;
            this.isSpoiler = isSpoiler;
        }
    }
}