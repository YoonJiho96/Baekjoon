class Solution {
    public int solution(String[] spell, String[] dic) {
        for(String str : dic) {
            int count = 0;
            
            for(String s : spell) {
                if(str.contains(s)) count++;
            }
            
            if(count == spell.length) return 1;
        }
        return 2;
    }
}