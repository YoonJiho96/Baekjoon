class Solution {
    public int solution(String[] strArr) {
        int[] size = new int[100001];
        
        for(String str : strArr) {
            size[str.length()]++;
        }
        
        int MAX = Integer.MIN_VALUE;
        for(int i=1; i<=100000; i++) {
            int curSize = size[i];
            if(curSize > MAX) {
                MAX = curSize;
            }
        }
        
        return MAX;
    }
}