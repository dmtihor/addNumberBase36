import java.util.Map;
import java.util.HashMap;

public class AddNumberBase36 {

    public String add(String a, String b) {

        int aLength = a.length();
        int bLength = b.length();
        int temp = 0;
        StringBuilder res = new StringBuilder();

        Map<Character, Integer> alpha = new HashMap<>();

        for (int i = 0; i < 10; i++) {
            alpha.put((char) ('0' + i), i);
        }
        for (int i = 0; i < 26; i++) {
            alpha.put((char) ('a' + i), i + 10);
            alpha.put((char) ('A' + i), i + 10);
        }

        for (int i = 0; i < aLength || i < bLength; i++) {
            char aTemp = (i < aLength) ? a.charAt(aLength - 1 - i) : '0';
            char bTemp = (i < bLength) ? b.charAt(bLength - 1 - i) : '0';
            int sum = temp + alpha.get(aTemp) + alpha.get(bTemp);
            if (sum < 36) {
                res.append(fromInt(sum));
                temp = 0;
            } else {
                res.append(fromInt(sum % 36));
                temp = 1;
            }
        }

        if (temp == 1) {
            res.append('1');
        }
        return res.reverse().toString();
    }

    private char fromInt(int num) {
        if (num < 10) {
            return (char) ('0' + num);
        } else {
            return (char) ('a' + num - 10);
        }
    }
}