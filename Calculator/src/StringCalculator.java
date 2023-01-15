import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    int add(String text) {
        // 문자열이 비어있거나 null값을 가질 때
        if (text.isEmpty() || text == null) return 0;

        // 문자열 길이가 1일 때
        if (text.length() == 1) {
            // parseInt는 정수가 아니면 Number 예외처리 에러를 발생 시킨다.
            return Integer.parseInt(text);
        }
        String[] tokens;
        // 정규식을 찾는다.
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (m.find()) {
            String customDelimeter = m.group(1);
            tokens = m.group(2).split(customDelimeter);
        } else {
            tokens = text.split(",|:");
        }
        int sum = 0;
        for (int i = 0; i < tokens.length; i++) {
            if (Integer.parseInt(tokens[i]) < 0) {
                throw new RuntimeException();
            }
            sum += Integer.parseInt(tokens[i]);
        }
        return sum;
    }

    public static void main(String[] args) {
        StringCalculator scal = new StringCalculator();
        System.out.println(scal.add("-1,2,3"));
    }
}

