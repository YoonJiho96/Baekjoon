class Solution {
    public int solution(String myString, String pat) {
        char[] p = pat.toCharArray();
        for(int i=0; i<p.length; i++) {
            p[i] = p[i] == 'A' ? 'B':'A';
        }
        return myString.contains(new String(p)) ? 1:0;
    }
}