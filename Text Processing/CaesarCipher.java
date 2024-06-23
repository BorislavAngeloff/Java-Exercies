import java.util.Scanner;

//Write a program that returns an encrypted version of the same text.
//Encrypt the text by shifting each character with three positions forward.
//For example, A would be replaced by D, B would become E, and so on. Print the encrypted text.

//Example

//Input:
//Programming is cool!

//Output:
//Surjudpplqj#lv#frro$

public class CaesarCipher {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        StringBuilder encryptedText = new StringBuilder();

        for (char symbol : text.toCharArray()) {
            // 'A' -> 'D'
            char encryptedSymbol = (char) (symbol + 3);
            encryptedText.append(encryptedSymbol);
        }

        System.out.println(encryptedText);
    }
}
