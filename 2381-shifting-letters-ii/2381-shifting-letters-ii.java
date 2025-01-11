class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int[] adds = new int[s.length() + 1]; 

        for (int[] shift : shifts) {
            int start = shift[0];
            int end = shift[1];
            int direction = shift[2];

            if (direction == 1) { 
                adds[start] += 1;
                adds[end + 1] -= 1;
            } else { 
                adds[start] -= 1;
                adds[end + 1] += 1;
            }
        }

        System.out.println((int)'a');
        System.out.println((int)'z');

        for (int i = 1; i < adds.length; i++) {
            adds[i] += adds[i - 1];
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            int shift = adds[i] % 26; 
            // shift가 양수 또는 음수 일 수 있기 때문에 26을 더하고 26%으로 나눈 후 다시 'a'를 더함으로써 자리를 찾음
            // s.charAt(i)가 z고 shift가 -25라면 (s.charAt(i) - 'a' + shift + 26)의 결과는 26이 됨
            // 26인 경우 0이 되야 하므로 %26을 해주는 것임
            char c = (char) ((s.charAt(i) - 'a' + shift + 26) % 26 + 'a'); 
            sb.append(c);
        }

        return sb.toString();
    }
}