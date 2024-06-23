import java.util.Scanner;

//Write a program to read an array of strings, reverse it and print its elements.
// The input consists of a sequence of space-separated strings.
// Print the output on a single line (space separated).

//Example

//Input:
//a b c d e

//Output:
//e d c b a

public class ReverseAnArrayofStrings {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String [] texts = scanner.nextLine().split(" ");
        //"a b c d e".split(" ") -> ["a", "b", "c", "d", "e"]

        for (int position = texts.length - 1; position >= 0; position--) {
            System.out.print(texts[position] + " ");
        }

    }
}
