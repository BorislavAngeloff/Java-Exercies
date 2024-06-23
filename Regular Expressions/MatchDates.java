import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//Write a program that matches a date in the format
//"dd{separator}MMM{separator}yyyy". Use named capturing groups
//in your regular expression.

//Example

//Input:
//13/Jul/1928, 10-Nov-1934, , 01/Jan-1951,f 25.Dec.1937 23/09/1973, 1/Feb/2016

//Output:
//Day: 13, Month: Jul, Year: 1928
//Day: 10, Month: Nov, Year: 1934
//Day: 25, Month: Dec, Year: 1937

public class MatchDates {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        String regex = "\\b(?<day>\\d{2})([\\.\\-\\/])(?<month>[A-Z][a-z]{2})\\2(?<year>\\d{4})\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            String wholeMatch = matcher.group(); //"13/Jul/1928"
            String day = matcher.group("day"); //"13"
            String month = matcher.group("month"); //"Jul"
            String year = matcher.group("year"); //"1928"
//            String day = matcher.group(1);
//            String month = matcher.group(3);
//            String year = matcher.group(4);
            System.out.printf("Day: %s, Month: %s, Year: %s\n", day, month, year);
        }
    }
}
