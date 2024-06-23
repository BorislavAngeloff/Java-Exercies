import java.util.Arrays;
import java.util.Scanner;

//Read an array of strings, and take only words whose length is even.
//Print each word on a new line.

//Example

//Input:
//kiwi orange banana apple

//Output:
//kiwi
//orange
//banana

public class WordFilter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] words = Arrays.stream(scanner.nextLine().split(" ")) //["kiwi", "orange", "banana", "apple"]
                .filter(word -> word.length() % 2 == 0) //["kiwi", "orange", "banana"]
                .toArray(String[] :: new);

        //StreamAPI
        //words = ["kiwi", "orange", "banana"]
        //Arrays.stream(words).forEach(word -> System.out.println(word));

        //foreach
        for (String word : words) {
            System.out.println(word);
        }

    }
}
