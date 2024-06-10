import java.util.*;

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        ArrayList<String> ans = new ArrayList<String>();
        for(int i = 0; i < arr1.length; i++) {
            String result = toWall(n, arr1[i], arr2[i]);
            ans.add(result);
        }
        return ans.toArray(new String[0]);
    }
    
    public String toWall(int n, int a, int b) {
        ArrayDeque<Character> stack = new ArrayDeque<>();
        char[] ans = new char[n];
        Arrays.fill(ans, ' ');
        while(a >= 1 || b >= 1) {
            char cur = ' ';
			if(a >= 1) {
                if(a % 2 != 0) {
                    cur = '#';
                }
            	a /= 2;
            }
			if(b >= 1) {
                if(b % 2 != 0) {
                    cur = '#';
                }
            	b /= 2;
            }
            System.out.println(cur);
            stack.addLast(cur);
        }
        for(int i = n - 1; i > -1; i--) {
            if(!stack.isEmpty()) {
                char cur = stack.pollFirst();
                ans[i] = cur;
            } else {
                break;
            }
        }
        return new String(ans);
    }
}