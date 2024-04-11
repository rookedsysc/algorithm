class Solution {
    public String[] reorderLogFiles(String[] logs) {
      List<String> digitList = new ArrayList<>();
      List<String> letterList = new ArrayList<>();

      for(String log: logs) {
        // 숫자 로그인 경우
        if(Character.isDigit(log.split(" ")[1].charAt(0))) {
          digitList.add(log);
        } else {
          letterList.add(log);
        }
      }

      letterList.sort((s1,s2) -> {
        String[] s1x = s1.split(" ", 2); // 최대 두 부분으로 나눈다
        String[] s2x = s2.split(" ", 2);

        // 문자 로그 사전순 비교 
        int compared = s1x[1].compareTo(s2x[1]);
        // 문자 로그 사전순 비교 
        if (compared == 0) {
          return s1x[0].compareTo(s2x[0]);
        } else {
          // 비교 대상의 순서가 동일한 경우 0, 순서가 앞인 경우 1, 순서가 뒤인 경우 -1이 된다.
          return compared;
        }
      });

      letterList.addAll(digitList);

      // 리스트를 String 배열로 변환해서 리턴한다.
      return letterList.toArray(new String[0]);
    }
}