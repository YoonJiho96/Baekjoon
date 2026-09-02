import java.util.*;

class Solution {
    static int[] dy = {-1, 1, 0, 0 };
    static int[] dx = {0, 0, -1, 1};
    
    public int[] solution(String[] park, String[] routes) {
        int[] pos = new int[2];
        char[][] map = new char[park.length][park[0].length()];
        
        for(int i=0; i<park.length; i++) {
            for(int j=0; j<park[i].length(); j++) {
                map[i][j] = park[i].charAt(j);
                if(map[i][j] == 'S') {
                    pos[0] = i;
                    pos[1] = j;
                }
            }
        }
        
        for(String route : routes) {
            String dir = route.split(" ")[0];
            int step = Integer.parseInt(route.split(" ")[1]);            
            
            int d = 0;
            switch(dir){
                case "N" -> d = 0;
                case "S" -> d = 1;
                case "W" -> d = 2;
                case "E" -> d = 3;
            }
            
            int ny = pos[0];
            int nx = pos[1];
            boolean valid = true;
            
            while(step-- > 0) {
                ny += dy[d];
                nx += dx[d];
                
                if(ny < 0 || nx < 0 || ny >= map.length || nx >= map[0].length || map[ny][nx] == 'X'){
                    valid = false;
                    break;
                }
            }
            
            if(valid) {
                pos[0] = ny;
                pos[1] = nx;
            }
        }
        
        return pos;
    }
}