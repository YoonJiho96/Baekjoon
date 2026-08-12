class Solution {
    public int solution(int[][] dots) {
        if(check(dots[0], dots[1], dots[2], dots[3])) return 1;
        else if(check(dots[0], dots[2], dots[1], dots[3])) return 1;
        else if(check(dots[0], dots[3], dots[1], dots[2])) return 1;
        else return 0;
    }
    
    boolean check(int[] dot1, int[] dot2, int[] dot3, int[] dot4) {
        int yDiff1 = dot1[1] - dot2[1];
        int xDiff1 = dot1[0] - dot2[0];

        int yDiff2 = dot3[1] - dot4[1];
        int xDiff2 = dot3[0] - dot4[0];

        return yDiff1 * xDiff2 == yDiff2 * xDiff1;
    }
}