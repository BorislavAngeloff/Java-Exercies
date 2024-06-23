import java.util.*;
import java.util.stream.Collectors;

//Read a list of integers, remove all negative numbers from it and print the
// remaining elements in reversed order.
// In case of no elements left in the list, print "empty".

//Example

//Input:
//10 -5 7 9 -33 50

//Output:
//50 9 7 10

public class ReverseNegativesAndRemove {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());
        //numbers = {10, -5, 7, 9, -33, 50}

        List<Integer> positiveNumbers = new ArrayList<>();

        for (int number : numbers) {
            if (number > 0) {
                positiveNumbers.add(number);
            }
        }
        //positiveNumbers -
        //positiveNumbers = {10, 7, 9, 50}
        //reverse
        Collections.reverse(positiveNumbers);
        //positiveNumbers = {50, 9, 7, 10}


        if (positiveNumbers.isEmpty()) {

            System.out.println("empty");
        } else {
            /*System.out.println(positiveNumbers.toString()           //"[50, 10, 9, 7]"
                                .replace("[", "")   //"50, 10, 9, 7]"
                                .replace("]", "")   //"50, 10, 9, 7"
                                .replaceAll(",", "") //"50 10 9 7"
            );*/

            for (int number : positiveNumbers) {
                System.out.print(number + " ");
            }
        }
    }
}
