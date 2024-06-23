import java.util.Scanner;

//A palindrome is a number that reads the same backward as forward,
// such as 323 or 1001. Write a program that reads a positive integer number
// until you receive "END". For each numbered print, whether the number is palindrome
// or not

//Example

//Input:
//123 323 421 121 END

//Output:
//false true false true

public class PalindromeIntegers {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        while (!input.equals("END")) {

            System.out.println(isInputPalindrome(input));
            input = scanner.nextLine();
        }
    }

    public static boolean isInputPalindrome(String input) {

        //1:
        String reversedString = "";
        for (int index = input.length() - 1; index >= 0; index--) {
            reversedString += input.charAt(index);
        }

        //2:
//        StringBuilder builder = new StringBuilder(input);
//        String reversedString = builder.reverse().toString();

        return input.equals(reversedString);
    }
}

