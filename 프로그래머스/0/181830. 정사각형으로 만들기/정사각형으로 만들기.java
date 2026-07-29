class Solution {
    public int[][] solution(int[][] arr) {
        int height = arr.length;
        int width = arr[0].length;
        
        if(height > width) {
            // 열 늘리기
            width = height;
        } else if(height < width) {
            // 행 늘리기
            height = width;
        } else {
            return arr;
        }
        int[][] answer = new int[height][height];
        for(int i=0; i<height; i++) {
            for(int j=0; j<height; j++) {
                if(i >= arr.length || j >= arr[0].length) {
                    answer[i][j] = 0;
                } else {
                    answer[i][j] = arr[i][j];
                }
            }
        }
        
        return answer;
    }
}