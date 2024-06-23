import java.util.Scanner;

//Write a method that receives two numbers and an operator, calculates the result
// and returns it. You will be given three lines of input.
// The first will be the first number, the second one will be the operator
// and the last one will be the second number. The possible operators are: / * + -
//Print the result rounded up to the second decimal point.

//Example

//Input:
//5
//*
//5

//Output:
//25.00

public class MathOperations {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int a = Integer.parseInt(scanner.nextLine());
        String operation = scanner.nextLine();
        int b = Integer.parseInt(scanner.nextLine());

        switch (operation) {
            case "/":
                divide(a, b);
                break;
            case "*":
                multiply(a, b);
                break;
            case "+":
                add(a, b);
                break;
            case "-":
                subtract(a, b);
                break;
        }
    }

    public static void divide(int a, int b) {
        System.out.println(a / b);
    }

    public static void multiply(int a, int b) {
        System.out.println(a * b);
    }

    public static void add(int a, int b) {
        System.out.println(a + b);
    }

    public static void subtract(int a, int b) {
        System.out.println(a - b);
    }
}
