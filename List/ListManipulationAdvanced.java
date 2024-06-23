import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

//Now we will implement more complicated list commands.
// Again, read a list, and until you receive "end" read commands:

//Contains {number} – check if the list contains the number.
//If yes, print "Yes", otherwise, print "No such number"

//Print even – print all the numbers that are even separated by a space

//Print odd – print all the numbers that are oddly separated by a space

//Get sum – print the sum of all the numbers
//
//· Filter {condition} {number} – print all the numbers that fulfill that condition.
// The condition will be either '<', '>', ">=", "<="

//Example

//Input:
//2 13 43 876 342 23 543
//Contains 100
//Contains 543
//Print even
//Print odd
//Get sum
//Filter >= 43
//Filter < 100
//end

//Output:
//No such number
//Yes
//2
//876
//342
//13
//43
//23
//543
//1842
//43
//876
//342
//543
//2
//13
//43
//23

public class ListManipulationAdvanced {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String number = scanner.nextLine();
        List<Integer> newNumbers = Arrays.stream(number.split(" ")).map(Integer::parseInt)
                .collect(Collectors.toList());

        String command = scanner.nextLine();

        while (!command.equals("end")) {

            if (command.startsWith("Contains")) {

                int numbToCheck = Integer.parseInt(command.split(" ")[1]);
                printIsContain(newNumbers, numbToCheck);

            } else if (command.startsWith("Print even")) {

                printEven(newNumbers);


            } else if (command.startsWith("Print odd")) {

                printOdd(newNumbers);



            } else if (command.startsWith("Get sum")) {

                printSum(newNumbers);

            } else if (command.startsWith("Filter")) {

                int numberforChecking = Integer.parseInt(command.split(" ")[2]);
                String sign = command.split(" ")[1];
                printFilter(newNumbers, sign, numberforChecking);

            }

            command = scanner.nextLine();

        }

    }

    public static void printFilter(List<Integer> newNumbers, String sign, int numberforChecking) {
        //'<', '>', ">=", "<="

        if (sign.equals(">")) {
            for (int number : newNumbers) {
                if (number > numberforChecking) {
                    System.out.print(number + " ");

                }

            }
            System.out.println();

        } else if (sign.equals(">=")) {
            for (int number : newNumbers) {
                if (number >= numberforChecking) {

                    System.out.print(number + " ");

                }

            }
            System.out.println();

        } else if (sign.equals("<")) {
            for (int number : newNumbers) {
                if (number < numberforChecking) {
                    System.out.print(number + " ");

                }

            }
            System.out.println();

        } else if (sign.equals("<=")) {
            for (int number : newNumbers) {
                if (number <= numberforChecking) {

                    System.out.print(number + " ");

                }

            }
            System.out.println();




        }

    }

    public static void printEven(List<Integer> newNumbers) {
        for (int number:newNumbers){
            if (number % 2 == 0) {
                System.out.print(number + " ");

            }

        }
        System.out.println();

    }

    public static void printOdd(List<Integer> newNumbers) {
        for (int number:newNumbers){
            if (number % 2 != 0) {
                System.out.print(number + " ");


            }
        }
        System.out.println();

    }

    public static void printIsContain(List<Integer> newNumbers, int numbToCheck) {
        if (newNumbers.contains(numbToCheck)) {

            System.out.println("Yes");
        } else {
            System.out.println("No such number");
        }
    }
    public static void printSum(List<Integer>newNumbers){
        int sum = 0;
        for (int i = 0; i <= newNumbers.size() - 1; i++) {
            int numbPart = newNumbers.get(i);
            sum += numbPart;
        }
        System.out.println(sum);

    }
}
