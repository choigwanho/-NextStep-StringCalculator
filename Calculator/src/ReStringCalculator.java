import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReStringCalculator {
//    int add (String text) {
//        // 문자열이 비어있거나 null값을 가질 때
//        if (text.isEmpty() || text == null) return 0;

    //        // 입력 받았을 때 문자열 길이가 1일떄
//        if(text.length() == 1) {
//            // pasrseInt는 문자열이 정수가 아닐 경우 NumberFormatException이 발생한다.
//            int number = Integer.parseInt(text);
//            return number;
//        }
//
    int sum = 0;

    int add(String text) {

        if (isBlank(text)) {
            return 0;
        }
        return sum(tolnts(split(text)));
    }

    private int[] tolnts(String[] value) {
        int[] numbers = new int[value.length];
        for (int i = 0; i < value.length; i++) {
            numbers[i] = toPositive(value[i]);
        }
        return numbers;
    }

    private boolean isBlank(String text) {
        return text == null || text.isEmpty();
    }

    private String[] split(String text) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if(m.find()){
            String customDelimeter = m.group(1);
            return m.group(2).split(customDelimeter);
        }
        return text.split(",|:");

    }

    private int sum(int number[]) {
        for (int n : number) {
            sum += n;
        }
        return sum;
    }

    private int toPositive(String value) {
        int num = Integer.parseInt(value);

        if (num < 0) {
            throw new RuntimeException();
        }

        return num;
    }


    public static void main(String[] args) {
        StringCalculator scal = new StringCalculator();
        System.out.println(scal.add("-1,2,3"));
    }
}
