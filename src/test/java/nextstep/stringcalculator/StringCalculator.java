package nextstep.stringcalculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class StringCalculator {

    public int calculate(String input) {

        Pattern pattern = Pattern.compile("(//)(\\S)(\\\\n\\S)(.*)");
        Matcher matcher = pattern.matcher(input);
        String regex;
        if(matcher.find()) {
            regex = matcher.group(2).trim();
            input = matcher.group(4).trim();
        } else if (input.contains(";")) {
            regex = ":";
        } else {
            regex = ",";
        }

        System.out.println(regex);

        Stream<String> stream = getSplit(input, regex);

        System.out.println(input);

        int total = stream.mapToInt(Integer::parseInt).reduce((t, i) -> {
            if (i < 0) throw new RuntimeException();
            else return t + i;
        }).getAsInt();
        return total;
    }

    private Stream<String> getSplit(String input, String regex) {
        return Stream.of(input.split(regex));
    }
}