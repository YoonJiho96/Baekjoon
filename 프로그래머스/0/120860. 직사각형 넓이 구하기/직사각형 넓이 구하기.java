class Solution {
    public int solution(int[][] dots) {
        int answer = 0;
        
        int lx = dots[0][0];
        int ly = dots[0][1];
        int rx = dots[0][0];
        int ry = dots[0][1];
        
        for(int[] dot : dots) {
            ly = Math.min(ly, dot[1]);
            lx = Math.min(lx, dot[0]);
            ry = Math.max(ry, dot[1]);
            rx = Math.max(rx, dot[0]);
        }
        return (ry - ly) * (rx - lx);
    }
}