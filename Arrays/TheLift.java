import java.util.Arrays;
import java.util.Scanner;

//Write a program that finds a place for the tourist on a lift.
//Every wagon should have a maximum of 4 people on it.
// If a wagon is full, you should direct the people to the next one with space
// available.

//Input
//On the first line, you will receive how many people are waiting to get on the lift.
//On the second line, you will receive the current state of the lift separated by a single space: " ".

//Output
//When there is no more available space left on the lift,
//or there are no more people in the queue, you should print on the console
// the final state of the lift's wagons separated by a single space " "
// and one of the following messages:

//If there are no more people and the lift has empty spots, you should print:
//"The lift has empty spots!
//{wagons separated by ' '}"
//If there are still people in the queue and no more available space, you should print:
//"There isn't enough space! {people} people in a queue!
//{wagons separated by ' '}"
//If the lift is full and there are no more people in the queue,
// you should print only the wagons separated by a single space " ".

//Example

//Input:
//15
//0 0 0 0

//Ouput:
//The lift has empty spots!
//4 4 4 3

public class TheLift {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int waitingPeople = Integer.parseInt(scanner.nextLine());
        int[] wagons = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        boolean isLiftFull = true;

        for (int position = 0; position < wagons.length; position++) {

            int availableSpace = 4 - wagons[position];

            if (availableSpace > 0) {
                if (availableSpace > waitingPeople) {
                    wagons[position] += waitingPeople;
                    waitingPeople = 0;
                    isLiftFull = false;

                } else {
                    wagons[position] = 4;
                    waitingPeople -= availableSpace;
                }
            }
        }

        if (!isLiftFull) {
            System.out.println("The lift has empty spots!");
        } else if (waitingPeople > 0) {
            System.out.printf("There isn't enough space! %d people in a queue!\n", waitingPeople);
        }

        for (int wagon : wagons) {
            System.out.print(wagon + " ");
        }
    }
}
