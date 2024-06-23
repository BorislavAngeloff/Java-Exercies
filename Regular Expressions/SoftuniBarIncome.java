import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//Let's take a break and visit the game bar at SoftUni.
//It is about time for the people behind the bar to go home,
//and you are the person who has to draw the line and calculate the money
//from the products that were sold throughout the day.
//Until you receive a line with the text "end of shift",
//you will be given lines of input. But before processing that line,
//you have to do some validations first.

//Each valid order should have a customer, product, count, and price:

//Valid customer's name should be surrounded by '%' and must start with
//a capital letter, followed by lower-case letters.

//Valid product contains any word character and must be surrounded by '<' and '>'.
//The valid count is an integer surrounded by '|'.
//The valid price is any real number followed by '$'.

//The parts of a valid order should appear in the order given:
//customer, product, count, and price.

//Between each part there can be other symbols, except ('|', '$', '%' and '. ')

//For each valid line print on the console: "{customerName}: {product} - {totalPrice}"

//When you receive "end of shift", print the total amount of money
//for the day rounded to 2 decimal places in the following format:
//"Total income: {income}".

//Input / Constraints
//Strings must be processed until you receive the text "end of shift".

//Output
//Print all the valid lines in the format "{customerName}: {product} - {totalPrice}".
//· After receiving "end of shift" print the total amount of money for
//the day rounded to 2 decimal places in the following format:
//"Total income: {income}".

//Example

//Input:
//%George%<Croissant>|2|10.3$
//%Peter%<Gum>|1|1.3$
//%Maria%<Cola>|1|2.4$
//end of shift

//Output:
//George: Croissant - 20.60
//Peter: Gum - 1.30
//Maria: Cola - 2.40
//Total income: 24.30


public class SoftuniBarIncome {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String regex = "%(?<customerName>[A-Z][a-z]+)%[^\\|$%\\.]*<(?<product>\\w+)>[^\\|\\$%\\.]*\\|(?<count>[0-9]+)\\|[^\\|\\$%\\.]*?(?<price>[0-9]+\\.?[0-9]*)\\$";
        Pattern pattern = Pattern.compile(regex);

        double totalIncome = 0;

        String input = scanner.nextLine();
        while (!input.equals("end of shift")) {

            //input = "%George%<Croissant>|2|10.3$"
            Matcher matcher = pattern.matcher(input);

            if (matcher.find()) {

                //matcher = "%(?<customerName>George)%<(?<product>Croissant)>|(?<count>2)|(?<price>10.3)$"
                String customerName = matcher.group("customerName"); //"George"
                String product = matcher.group("product"); //"Croissant"
                int count = Integer.parseInt(matcher.group("count")); //"2" -> parse -> 2
                double price = Double.parseDouble(matcher.group("price")); //"10.3" -> parse -> 10.3

                double totalPricePerOrder = count * price;
                totalIncome += totalPricePerOrder;
                System.out.printf("%s: %s - %.2f%n", customerName, product, totalPricePerOrder);
            }
            input = scanner.nextLine();
        }

        System.out.printf("Total income: %.2f", totalIncome);
    }
}
