import java.util.*;

class Solution {
    public long solution(String expression) {
        ArrayDeque<String> q = new ArrayDeque<>();
        String temp = "";
        for(int i =0; i < expression.length() ; i ++) {
            temp += new String(expression.charAt(i)); 
            if(expression.charAt(i).isDigit()) {
                q.addLast(temp);
                temp = "";
            } 
        }
        q.addLast(temp);
        System.out.println(temp.toString());
        long i = 0L;
        return i;
    }
}