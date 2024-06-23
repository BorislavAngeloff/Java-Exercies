import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//Write a regular expression to match a valid phone number from Sofia.
//After you find all valid phones, print them on the console,
//separated by a comma and a space ","

//Example

//Input:
//+359 2 222 2222,359-2-222-2222, +359/2/222/2222, +359-2 222 2222 +359 2-222-2222,
//+359-2-222-222, +359-2-222-22222 +359-2-222-2222

//Output:
//+359 2 222 2222, +359-2-222-2222

public class MatchPhoneNumber {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        String regex = "\\+359([ -])2\\1\\d{3}\\1\\d{4}\\b";

        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(text);

        List<String> validNumbers = new ArrayList<>();
        while (matcher.find()){
            validNumbers.add(matcher.group());
        }

        System.out.println(String.join(", ", validNumbers));
    }
}
