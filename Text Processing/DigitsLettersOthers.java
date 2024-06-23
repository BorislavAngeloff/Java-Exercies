import java.util.Scanner;

//Write a program that receives a single string and on the first line prints all
//the digits, on the second – all the letters, and on the third
//– all the other characters. There will always be at least one digit,
//one letter, and another character.

//Example

//Input:
//Agd#53Dfg^&4F53

//Output:
//53453 AgdDfgF #^&

public class DigitsLettersOthers {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine(); //"Agd#53Dfg^&4F53"


        StringBuilder digits = new StringBuilder();

        StringBuilder letters = new StringBuilder();

        StringBuilder others = new StringBuilder();

        for (char symbol : text.toCharArray()) {
            if (Character.isDigit(symbol)) {

                digits.append(symbol);
            } else if (Character.isLetter(symbol)) {

                letters.append(symbol);
            } else {

                others.append(symbol);
            }
        }

        System.out.println(digits);
        System.out.println(letters.toString());
        System.out.println(others.toString());

    }

}
