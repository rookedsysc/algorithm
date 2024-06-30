import java.util.*;

class Solution {
    public List<String> stringValue = List.of("0", "1","2","3","4","5","6","7","8","9","A","B","C","D","E","F");
    public String solution(int n, int t, int m, int p) {
        int max = t * m; 
        String allStr = totalString(n, max);
        String answer = "";
        
        for(int i = 0; i < max; i++) {
            if(i % m == p - 1) {
                System.out.print(String.valueOf(i % m) + " ");
                answer += allStr.charAt(i);
            }
        }
        
        return answer;
    }
    
    public String totalString(int n, int max) {
        String result = "";
        for(int i = 0; i < max + 1; i++) {
            result += toNWord(n, i);
        }
        return result;
    }
    
    public String toNWord(int n, int param) {
        String str = "";
        while(param / n > 0) {
            String cur = stringValue.get(param % n);
            str = cur + str;
            param /= n;
		}
        String cur = stringValue.get(param);
        str = cur + str;
        return str;
    }
}