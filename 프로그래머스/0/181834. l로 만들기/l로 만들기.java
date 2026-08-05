class Solution {
    public String solution(String myString) {
        char[] str = myString.toCharArray();
        for(int i=0; i<str.length; i++) {
            if(str[i] < 'l') str[i] = 'l';
        }
        
        return new String(str);
    }
}