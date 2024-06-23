import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//Write a Java Program to match full names from a list of names and print them
//on the console.

//A valid full name has the following characteristics:
//It consists of two words.
//Each word starts with a capital letter.
//After the first letter, it only contains lowercase letters afterward.
//Each of the two words should be at least two letters long.
//The two words are separated by a single space.

//Example

//Input:
//Ivan Ivanov, Ivan ivanov, ivan Ivanov, IVan Ivanov, Georgi Georgiev, Ivan Ivanov

//Output:
//Ivan Ivanov Georgi Georgiev

public class MatchFullName {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        String regex = "\\b([A-Z][a-z]+) ([A-Z][a-z]+)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        //matcher.find() -> true/false Ако намери следващо съвпадение
        while (matcher.find()){
            System.out.print(matcher.group() + " ");
        }
    }
}
