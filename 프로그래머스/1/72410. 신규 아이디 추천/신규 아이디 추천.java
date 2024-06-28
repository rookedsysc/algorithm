class Solution {
    public String solution(String new_id) {
        // 1단계 
        String answer = new_id.toLowerCase();
        
        // 2단계 
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < answer.length(); i++) {
            Character c = answer.charAt(i);
            Boolean a = Character.isLetterOrDigit(c);
            Boolean b = c.equals('-') || c.equals('_') || c.equals('.');
            if(a || b) {
                sb.append(c);
            }
        }
        answer = sb.toString();
        
        // 3단계
        while(answer.contains("..")) {
            answer = answer.replace("..", ".");
        }
        
        // 4단계
        if(answer.length() > 0) {
            if(answer.charAt(0) == '.') {
                answer = answer.substring(1, answer.length());
            } 
        }
        if(answer.length() > 0) {
            if(answer.charAt(answer.length() - 1) == '.') {
                answer = answer.substring(0, answer.length() - 1);
            }
        }
        
        // 5단계 
        if(answer.length() == 0 || answer == null) {
            answer = "aaa";
        }
        
        // 6단계
        if(answer.length() >= 16) {
            answer = answer.substring(0, 15);
            if(answer.charAt(answer.length() - 1) == '.') {
            	answer = answer.substring(0, 14);
            }
        }
        
        // 7단계 
        sb = new StringBuilder(answer);
        char last = answer.charAt(answer.length() - 1);
        while(sb.length() <= 2) {
            sb.append(last);
        }
        answer = sb.toString();
        
        return answer;
    }
}