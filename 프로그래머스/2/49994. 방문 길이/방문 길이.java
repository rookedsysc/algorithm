import java.util.*;

class Solution {
    int[][] map = new int[21][21];
    int[] curp = {10,10};
    int cnt = 0;
    
    private boolean canMove(int[] np) {
        if((-1 < np[0] && np[0] < 21) && (-1 < np[1] && np[1] < 21)) {
            return true;
        }
        return false;
    }
    
    private void move(String command) {
        if (command.equals("U")) {
            int[] np = {curp[0] + 2, curp[1]};
            int ly = curp[0] + 1;
            int lx = curp[1];
            
            // 움직일 수 있는경우 
            if(canMove(np)) {
                // 이미 지나간 길인지 확인
                if(map[ly][lx] == 0) {
                    cnt ++;
                    map[ly][lx] = 1;
                }
                curp = np;
            } 
        } else if (command.equals("L")) {
            int[] np = {curp[0], curp[1] - 2};
            int ly = curp[0];
            int lx = curp[1] - 1;
            
            // 움직일 수 있는경우 
            if(canMove(np)) {
                // 이미 지나간 길인지 확인
                if(map[ly][lx] == 0) {
                    cnt ++;
                    map[ly][lx] = 1;
                }
                curp = np;
            } 
        } else if (command.equals("D")) {
            int[] np = {curp[0] - 2, curp[1]};
            int ly = curp[0] - 1;
            int lx = curp[1];
            
            // 움직일 수 있는경우 
            if(canMove(np)) {
                // 이미 지나간 길인지 확인
                if(map[ly][lx] == 0) {
                    cnt ++;
                    map[ly][lx] = 1;
                }
                curp = np;
            } 
        } else {
            int[] np = {curp[0], curp[1] + 2};
            int ly = curp[0];
            int lx = curp[1] + 1;
            
            // 움직일 수 있는경우 
            if(canMove(np)) {
                // 이미 지나간 길인지 확인
                if(map[ly][lx] == 0) {
                    cnt ++;
                    map[ly][lx] = 1;
                }
                curp = np;
            } 
        }
    }
    
    public int solution(String dirs) {
        int answer = 0;
        // map의 크기를 두 배로 늘려서 각 지점 +2로 진행하는 거 말고는 다 길로 침
        // 길을 하나씩만 카운트
        String[] dirList = dirs.split("");
        for(String dir: dirList) {
            move(dir);
        }
        
        return cnt;
    }
}