class Solution {
    public int solution(int[][] sizes) {
        int wMax = Integer.MIN_VALUE;
        int hMax = Integer.MIN_VALUE;
        
        for(int i=0; i<sizes.length; i++) {
            int w = sizes[i][0];
            int h = sizes[i][1];
            
            if(w < h) {
                w = w ^ h;
                h = w ^ h;
                w = w ^ h;
            }
            
            wMax = Math.max(wMax, w);
            hMax = Math.max(hMax, h);
        }
        return wMax * hMax;
    }
}