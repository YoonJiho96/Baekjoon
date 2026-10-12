import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, Integer> genreTotal = new HashMap<>();
        HashMap<String, ArrayList> genrePlay = new HashMap<>();
        
        for(int i=0; i<genres.length; i++) {
            String g = genres[i];
            int p = plays[i];
            
            genreTotal.put(g, genreTotal.getOrDefault(g, 0) + p);
            genrePlay.putIfAbsent(g, new ArrayList<Integer>());
            genrePlay.get(g).add(i);
        }
        
        ArrayList<String> sorted = new ArrayList<>(genreTotal.keySet());
        Collections.sort(sorted, (s1, s2) -> (genreTotal.get(s2) - genreTotal.get(s1)));
        
        ArrayList<Integer> answer = new ArrayList<>();
        for(String s : sorted) {
            ArrayList<Integer> list = genrePlay.get(s);
            Collections.sort(list, (s1, s2) -> {
                if(plays[s1] != plays[s2]) {
                    return plays[s2] - plays[s1];
                }
                return s1 - s2;
            });
            
            for(int i=0; i<Math.min(2, list.size()); i++) {
                answer.add(list.get(i));
            }
        }
        
        int[] temp = new int[answer.size()];
        for(int i=0; i<temp.length; i++) {
            temp[i] = answer.get(i);
        }
        return temp;
    }
}