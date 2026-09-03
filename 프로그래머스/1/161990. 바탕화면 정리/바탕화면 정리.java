class Solution {
    public int[] solution(String[] wallpaper) {
        
        int y1 = Integer.MAX_VALUE;
        int x1 = Integer.MAX_VALUE;
        int y2 = Integer.MIN_VALUE;
        int x2 = Integer.MIN_VALUE;
        
        for(int i=0; i<wallpaper.length; i++) {
            char[] line = wallpaper[i].toCharArray();
            
            for(int j=0; j<line.length; j++) {
                if(line[j] == '#') {
                    
                    y1 = Math.min(y1, i);
                    x1 = Math.min(x1, j);
                    
                    y2 = Math.max(y2, i);
                    x2 = Math.max(x2, j);
                }
            }
        }
        
        return new int[]{y1, x1, y2 + 1, x2 + 1};
    }
}