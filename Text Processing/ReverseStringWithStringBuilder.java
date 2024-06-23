import java.util.Scanner;

//You will be given a series of strings until you receive an "end" command.
// Write a program that reverses strings and prints each pair on a separate line
// in the format "{word} = {reversed word}".

//Example

//Input:
//helLo
//Softuni
//bottle
//end

//Output:
//helLo = oLleh
//Softuni = inutfoS
//bottle = elttob

public class ReverseStringWithStringBuilder {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        while (!input.equals("end")) {

            StringBuilder sb = new StringBuilder(input);
            sb.reverse();

            System.out.println(input + " = " + sb.toString());

            input = scanner.nextLine();
        }
    }
}
