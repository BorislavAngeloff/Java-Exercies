import java.util.Arrays;
import java.util.Scanner;

//You are given an array with integers. Write a program to modify the elements
// after receiving the following commands:
//"swap {index1} {index2}" takes two elements and swap their places.
//"multiply {index1} {index2}" takes the element at the 1st index
// and multiplies it with the element at 2nd index.
// Save the product at the 1st index.
//"decrease" decreases all elements in the array with 1.

//Input
//On the first input line, you will be given the initial array values
// separated by a single space.
//On the next lines, you will receive commands until you receive the command "end".
// The commands are as follows:

//"swap {index1} {index2}"
//"multiply {index1} {index2}"
//"decrease"

//Output
//The output should be printed on the console and consist of elements of the modified
// array – separated by a comma and a single space ", ".

//Constraints
//Elements of the array will be integer numbers in the range [-231...231].
//The count of the array elements will be in the range [2...100].
//Indexes will always be in the range of the array

public class ArrayModifier {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        String command = scanner.nextLine();
        while (!command.equals("end")) {

            if (command.contains("swap")) {
                // swap 1 3
                int firstIndex = Integer.parseInt(command.split(" ")[1]);
                int secondIndex = Integer.parseInt(command.split(" ")[2]);

                int firstIndexNumber = numbers[firstIndex];
                int secondIndexNumber = numbers[secondIndex];

                numbers[firstIndex] = secondIndexNumber;
                numbers[secondIndex] = firstIndexNumber;
            } else if (command.contains("multiply")) {
                // multiply 1 2
                int firstIndex = Integer.parseInt(command.split(" ")[1]);
                int secondIndex = Integer.parseInt(command.split(" ")[2]);

                int firstIndexNumber = numbers[firstIndex];
                int secondIndexNumber = numbers[secondIndex];

                int product = firstIndexNumber * secondIndexNumber;

                numbers[firstIndex] = product;

            } else { //decrese
                for (int position = 0; position <= numbers.length - 1; position++) {
                    numbers[position]--;
                }
            }

            command = scanner.nextLine();
        }

        //1:
//        for (int position = 0; position < numbers.length; position++) {
//
//            if (position == numbers.length - 1) {
//                System.out.print(numbers[position]);
//            } else {
//                System.out.print(numbers[position] + ", ");
//            }
//        }

        //2:
        System.out.println(
                Arrays.toString(numbers)
                        .replace("[", "")
                        .replace("]", "")
        );
    }
}
