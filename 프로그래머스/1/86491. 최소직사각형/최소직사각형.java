class Solution {
    public int solution(int[][] sizes) {
        int width = Integer.MIN_VALUE;
        int height = Integer.MIN_VALUE;
        
        for(int i=0; i<sizes.length; i++) {
            // 모두 width 가 더 길게 변환
            int w = sizes[i][0];
            int h = sizes[i][1];
            
            if(w < h) {
                w = w ^ h;
                h = w ^ h;
                w = w ^ h;
            }
            
            width = Math.max(width, w);
            height = Math.max(height, h);
        }
                
        return width * height;
    }
}