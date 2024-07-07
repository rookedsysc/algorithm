import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        return Arrays.stream(files)
            .sorted((s1, s2) -> {
                String[] parsed1 = parseFileName(s1);
                String[] parsed2 = parseFileName(s2);
                int headCompare = parsed1[0].compareToIgnoreCase(parsed2[0]);
                if (headCompare != 0) return headCompare;
                return Integer.compare(Integer.parseInt(parsed1[1]), Integer.parseInt(parsed2[1]));
            })
            .toArray(String[]::new);
    }

    private String[] parseFileName(String file) {
        int firstDigit = -1;
        int length = file.length();
        for (int i = 0; i < length; i++) {
            if (Character.isDigit(file.charAt(i))) {
                firstDigit = i;
                break;
            }
        }

        int lastDigit = firstDigit;
        while (lastDigit < length && Character.isDigit(file.charAt(lastDigit)) && lastDigit - firstDigit < 5) {
            lastDigit++;
        }

        String head = file.substring(0, firstDigit);
        String number = file.substring(firstDigit, lastDigit);
        return new String[]{head, number};
    }
}
