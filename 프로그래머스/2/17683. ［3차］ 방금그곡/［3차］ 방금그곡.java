

class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        int len = 0;

        m = replaceNode(m);

        for(String info : musicinfos){
            String[] temp = info.split(",");
            String subject = temp[2];
            String code = replaceNode(temp[3]);
            int time = time(temp[0], temp[1]);
            code = fullNode(code, time);
            if(time >= m.length() && code.contains(m)){
                if(time > len){
                    len = time;
                    answer = subject;
                }
            }
        }

        return answer;
    }

    public static String fullNode(String code, int time){
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < time; i++) {
            sb.append(code.charAt(i % code.length()));
        }
        return sb.toString();
    }

    public static int time(String s, String e){
        int start = Integer.parseInt(s.split(":")[0]) * 60 + Integer.parseInt(s.split(":")[1]);
        int end = Integer.parseInt(e.split(":")[0]) * 60 + Integer.parseInt(e.split(":")[1]);
        return end - start;
    }

    public static String replaceNode(String m){
        return m.replaceAll("C#","c")
                .replaceAll("D#","d")
                .replaceAll("F#","f")
                .replaceAll("G#","g")
            	.replaceAll("B#", "M") // 문제에 없는 B# 코드
                .replaceAll("A#","a");
    }
}