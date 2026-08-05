import java.util.*;

class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        int len = toNum(video_len);
        int curPos = toNum(pos);
        int opStart = toNum(op_start);
        int opEnd = toNum(op_end);

        if(curPos >= opStart && curPos <= opEnd) {
            curPos = opEnd;
        }
        
        for(String cmd : commands) {
            switch(cmd) {
                case "next":
                    curPos = Math.min(len, curPos + 10);
                    break;
                case "prev":
                    curPos = Math.max(0, curPos - 10);
                    break;
            }
            
            if(curPos >= opStart && curPos <= opEnd) {
                curPos = opEnd;
            }
        }
        
        return toTimeStr(curPos);
    }
    
    int toNum(String time) {
        int min = Integer.parseInt(time.substring(0, 2));
        int sec = Integer.parseInt(time.substring(3, 5));
        return min * 60 + sec;
    }
    
    String toTimeStr(int time) {
        int min = time / 60;
        int sec = time % 60;
        return String.format("%02d", min) + ":" + String.format("%02d", sec);
    }
}