import java.util.Scanner;

//Explosions are marked with ">". Immediately after the mark, there will be an integer,
//which signifies the strength of the explosion.
//You should remove x characters (where x is the strength of the explosion),
//starting after the punched character (">").
//If you find another explosion mark (">") while you're deleting characters,
//you should add strength to your previous explosion.
//When all characters are processed, print the string without the deleted characters.
//You should not delete the explosion character – ">",
//but you should delete the integers, which represent the strength.

//Input
//You will receive a single line with the string.

//Output
//Print what is left from the string after explosions.

//Constraints
//You will always receive strength for the punches.
//The path will consist only of letters from the Latin alphabet, integers, and the char ">".
//The strength of the punches will be in the interval [0…9

//Example

//Input:
//abv>1>1>2>2asdasd

//Output:
//abv>>>>dasd

public class StringExplosion {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        StringBuilder textBuilder = new StringBuilder(input);

        int totalStrength = 0;

        for (int position = 0; position < textBuilder.length(); position++) {

            char currentSymbol = textBuilder.charAt(position);

            if (currentSymbol == '>') {
                int explosionStrength = Integer.parseInt(textBuilder.charAt(position + 1) + "");
                totalStrength += explosionStrength;
            } else if (totalStrength > 0) {
                textBuilder.deleteCharAt(position);
                totalStrength--;
                position--;
            }
        }

        System.out.println(textBuilder);
    }
}
