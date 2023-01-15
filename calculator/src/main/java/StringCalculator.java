import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    /* TASK
        - 전달하는 문자를 구분자로 분리한 후 각 숫자의 합을 구해 반환
        - 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환
        - 앞의 기본 구분자(쉼표, 콜론) 외에 커스텀 구분자를 지정할 수 있음
          - 커스텀 구분자는 문자열 앞부분의 "//"와 "\n" 사이에 위치한 문자를 커스텀 구분자로 사용
        - 문자열 계산기에 음수를 전달하는 경우 RuntimeException으로 예외 처리
    */
    public int add(String text){

        // 빈 문자열 또는 null 값을 입력할 경우 0을 반환
        if (text == null || text.isEmpty()) return 0;

        // "//"와 "\n" 문자 사이에 커스텀 구분자 지정
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        String[] values;

        if (m.find()) {
            String customDelimeter = m.group(1);
            System.out.println(customDelimeter);
            values = m.group(2).split(customDelimeter);
        }else{
            values = text.split(",|:");
        }

        int sum = 0;
        for (String value: values){
            // 음수를 전달하는 경우 RuntimeException 예외 처리
            if (Integer.parseInt(value) < 0) throw new RuntimeException("음수가 입력됐습니다.");
            sum += Integer.parseInt(value);
        }

        return sum;
    }

}
