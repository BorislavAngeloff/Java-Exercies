import java.math.BigInteger;
import java.util.Scanner;

//You are given two lines – the first one can be a really big number (0 to 1050).
//The second one will be a single-digit number (0 to 9).
//You must display the product of these numbers.



public class MultiplyBigNumber {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String firstNumber = scanner.nextLine();
        String secondNumber = scanner.nextLine();

        BigInteger number1 = new BigInteger(firstNumber);
        BigInteger number2 = new BigInteger(secondNumber);

        System.out.println(number1.multiply(number2));

//
//        System.out.println(number1.add(number2));
//
//        System.out.println(number1.subtract(number2));
//
//        System.out.println(number1.divide(number2));
    }
}
