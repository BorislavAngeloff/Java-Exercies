import java.util.Arrays;
import java.util.Scanner;


//Read two arrays and print on the console whether they are identical or not.
// Arrays are identical if their elements are equal.
// If the arrays are identical, find the sum of the first one
// and print on the console the following message: "Arrays are identical.
// Sum: {sum}", otherwise find the first index where the arrays differ
// and print on the console following message: "Arrays are not identical.
// Found difference at {index} index."

//Example

//Input:
//10 20 30
//10 20 30

//Output:
//Arrays are identical. Sum: 60

public class EqualArrays {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] firstArr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] secondArr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        boolean identical = true;
        int sum = 0;
        int foundPosition = 0;

        for (int position = 0; position <= firstArr.length - 1; position++) {
            int firstNum = firstArr[position];
            int secondNum = secondArr[position];

            if (firstNum == secondNum) {
                sum += firstNum;
            } else {
                foundPosition = position;
                identical = false;
                break;
            }

        }
        if (identical) {
            System.out.printf("Arrays are identical. Sum: %d", sum);
        } else {
            System.out.printf("Arrays are not identical. Found difference at %d foundPosition.", foundPosition);
        }

    }
}
