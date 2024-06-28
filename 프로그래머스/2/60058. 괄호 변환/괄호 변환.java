import java.util.*;

class Solution {
    public String solution(String p) {
        return recursion(p);
    }
    
    public String recursion(String p) {
        if(isCorrect(p)) {
            return p;
        }
        int a = 0;
        int b = 0;
        int lastIdx = 0;
        for(int i = 0; i < p.length(); i++) {
            if(p.charAt(i) == '(') {
                a ++;
            } else {
                b ++;
            }
            if(a == b) {
                lastIdx = i + 1;
                break;
            }
        }
        
        String u = p.substring(0, lastIdx);
        String v = p.substring(lastIdx, p.length());
        String result;
        if(!isCorrect(u)) {
            if(u.length() >= 2) {
            	u = u.substring(1, u.length() - 1); 
            }
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < u.length(); i++) {
                if(u.charAt(i) == '(') {
                    sb.append(')');
                } else {
                    sb.append('(');
                }
            }
            u = sb.toString();
            result = "(" + recursion(v) + ")" + u;
        } else {
            result = u + recursion(v);
        }
        return result; 
    }
    
    public Boolean isCorrect(String str) {
        ArrayDeque<Character> stack = new ArrayDeque();
        
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == '(') {
                stack.addLast(str.charAt(i));
            }
            else if(str.charAt(i) == ')' && stack.size() < 1) {
                return false;
            } else {
                stack.pollLast();
            }
        }
        return true;
    }
    
    
}