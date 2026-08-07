import java.util.*;

class Solution {
    
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("code", 0);
        map.put("date", 1);
        map.put("maximum", 2);
        map.put("remain", 3);
        
        int e = map.get(ext);
        
        ArrayList<int[]> list = new ArrayList<>();
        for(int[] d : data) {
            if(d[e] < val_ext) {
                System.out.println(Arrays.toString(d));
                list.add(d);
            }
        }

        int[][] answer = list.toArray(new int[0][]);
        
        int sort = map.get(sort_by);
        Arrays.sort(answer, (a, b) -> Integer.compare(a[sort], b[sort]));
        return answer;
    }
}