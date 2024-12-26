class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        for(String command: commands) {
            if(compare(pos, op_start) && compare(op_end, pos)) {
                pos = op_end;
            }
            if(command.equals("next")) {
                pos = next(pos);
            } else {
                pos = prev(pos);
            }
            if(compare(pos, op_start) && compare(op_end, pos)) {
                pos = op_end;
            }
            if(compare(pos, video_len)) {
                pos = video_len;
            }
        }
        return pos;
    }
    
    public String prev(String time) {
        String[] hM = time.split(":");
        int h = Integer.parseInt(hM[0]);
        int m = Integer.parseInt(hM[1]);
        
        if(m - 10 < 0) {
            m += 50;
            h -= 1;
        } else {
            m -= 10;
        }
        if(h < 0) {
            m = 0;
            h = 0;
        }
        return String.format("%02d:%02d", h, m);
    }
    
    public String next(String time) {
        String[] hM = time.split(":");
        int h = Integer.parseInt(hM[0]);
        int m = Integer.parseInt(hM[1]);
        
        m += 10;
        if(m >= 60) {
            m -= 60;
            h += 1;
        }
        return String.format("%02d:%02d", h, m);
    }
    
    // start가 더 이후의 값이면 true 반환
    public boolean compare(String start, String end) {
        String[] startHm = start.split(":");
        String[] endHm = end.split(":");
        Integer startH = Integer.parseInt(startHm[0]);
        Integer startM = Integer.parseInt(startHm[1]);
        Integer endH = Integer.parseInt(endHm[0]);
        Integer endM = Integer.parseInt(endHm[1]);
        
        if(startH > endH || (startH == endH && startM >= endM)) {
            return true;
        }
        return false;
    }
}