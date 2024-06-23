import java.util.Scanner;

//Write a program that calculates the volume of n beer kegs. You will receive in total 3 * n lines. Every three lines will hold information for a single keg. First up is the model of the keg, after that is the radius of the keg, and lastly is the height of the keg.
//
//Calculate the volume using the following formula: π * r^2 * h.
//
//In the end, print the model of the biggest keg.
//
//Input
//
//You will receive 3 * n lines. Each group of lines will be on a new line:
//
//· First – model – string
//
//· Second –radius – floating-point number
//
//· Third – height – integer number
//
//Output
//
//Print the model of the biggest keg.
//
//Constraints
//
//· n will be in the interval [1…10].
//
//· The radius will be a floating-point number in the interval [1…3.402823E+38].
//
//· The height will be an integer in the interval [1…2147483647].

//Example

//Input:
//3
//Keg 1
//10
//10
//Keg 2
//20
//20
//Keg 3
//10
//30

//Output:
//Keg 2
public class BeerKegs {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int kegsCount = Integer.parseInt(scanner.nextLine());

        String maxModel = "";
        double maxVolume = 0;

        for (int keg = 1; keg <= kegsCount; keg++) {


            String model = scanner.nextLine();
            double radius = Double.parseDouble(scanner.nextLine());
            int height = Integer.parseInt(scanner.nextLine());

            //Formula: π * r^2 * h
            double volume = Math.PI * radius * radius * height;
            //double volume2 = Math.PI * Math.pow(radius, 2) * height;

            if (volume > maxVolume) {
                maxModel = model;
                maxVolume = volume;
            }
        }

        System.out.println(maxModel);
    }

}
