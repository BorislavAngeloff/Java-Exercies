import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//The war is at its peak, but you, young Padawan,
//can turn the tides with your programming skills.
//You are tasked to create a program to decrypt the messages of The Order
//and prevent the death of hundreds of lives.

//You will receive several messages, which are encrypted using the legendary
//star enigma. You should decrypt the messages following these rules:

//To properly decrypt a message, you should count all the letters
//[s, t, a, r] – case insensitive and remove the count from the current ASCII
//value of each symbol of the encrypted message.

//After decryption:
//Each message should have a planet name, population,
//attack type ('A', as an attack or 'D', as destruction), and soldier count.
//The planet's name starts after '@' and contains only letters from the Latin alphabet.
//The planet population starts after ':' and is an Integer;
//The attack type may be "A"(attack) or "D"(destruction) and
//must be surrounded by "!" (Exclamation mark).
//The soldier count starts after "->" and should be an Integer.
//The order in the message should be: planet name ->
//planet population -> attack type -> soldier count.
//Each part can be separated from the others by any character except: '@', '-', '!', ':' and '>'.

//Input / Constraints
//The first line holds n – the number of messages – integer in the range [1…100].
//On the next n lines, you will be receiving encrypted messages.

//Output
//After decrypting all messages, you should print the decrypted information
//in the following format:

//First print the attacked planets, then the destroyed planets.
//"Attacked planets: {attackedPlanetsCount}" "-> {planetName}"
//"Destroyed planets: {destroyedPlanetsCount}" "-> {planetName}"
//The planets should be ordered by name alphabetically.

//Example

//Input:
//2
//STCDoghudd4=63333$D$0A53333
//EHfsytsnhf?8555&I&2C9555SR

//Output:
//Attacked planets: 1 -> Alderaa
//Destroyed planets: 1 -> Cantonica

public class StarEnigma {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int countMessages = Integer.parseInt(scanner.nextLine());
        String regex = "@(?<planetName>[A-Za-z]+)[^@!:>-]*:(?<population>[0-9]+)[^@!:>-]*!(?<attackType>[AD])![^@!:>-]*->(?<soldiersCount>[0-9]+)";
        Pattern pattern = Pattern.compile(regex);

        List<String> attackersPlanets = new ArrayList<>(); // (attackType е "А")
        List<String> destroyedPlanets = new ArrayList<>(); //(attackType е "D")

        for (int messageCount = 1; messageCount <= countMessages; messageCount++) {
            String encryptedMessage = scanner.nextLine();
            String decryptedMessage = getDecryptedMessage(encryptedMessage);
            //decripted: "PQ@Alderaa1:30000!A!->20000"
            Matcher matcher = pattern.matcher(decryptedMessage);
            //matcher: "@(?<planetName>Alderaa)[^@!:>-]*:(?<population>30000)[^@!:>-]*!(?<attackType>A)![^@!:>-]*->(?<soldiersCount>20000)";
            if (matcher.find()) {
                String planetName = matcher.group("planetName");
                //int population = Integer.parseInt(matcher.group("population"));
                String attackType = matcher.group("attackType");
                //int soldiersCount = Integer.parseInt(matcher.group("soldiersCount"));

                if (attackType.equals("A")) {

                    attackersPlanets.add(planetName);
                } else if (attackType.equals("D")) {

                    destroyedPlanets.add(planetName);
                }
            }
        }

        System.out.println("Attacked planets: " + attackersPlanets.size());
        Collections.sort(attackersPlanets); //sort planets by name
        attackersPlanets.forEach(planet -> System.out.println("-> " + planet));

        System.out.println("Destroyed planets: " + destroyedPlanets.size());
        Collections.sort(destroyedPlanets); //sort planets by name
        destroyedPlanets.forEach(planet -> System.out.println("-> " + planet));
    }


    private static String getDecryptedMessage(String encryptedMessage) {
        //1.  [s, t, a, r, S, T, A, R]
        //encrypted message: STCDoghudd4=63333$D$0A53333 -> 3 special letters
        int countLetters = getSpecialLettersCount(encryptedMessage);

        StringBuilder decryptedMessage = new StringBuilder();
        //2. new symbol-> ascii new symbol= ascii current symbol - countLetters
        for (char symbol  : encryptedMessage.toCharArray()) {
            char newSymbol = (char)(symbol - countLetters);
            decryptedMessage.append(newSymbol);
        }

        return decryptedMessage.toString();
    }

    // [s, t, a, r, S, T, A, R]
    private static int getSpecialLettersCount(String encryptedMessage) {
        //encrypted message: STCDoghudd4=63333$D$0A53333 -> 3 special letters
        int count = 0;
        for (char symbol : encryptedMessage.toCharArray()) {
            switch (symbol) {
                case 's':
                case 't':
                case 'a':
                case 'r':
                case 'S':
                case 'T':
                case 'A':
                case 'R':
                    count++;
                    break;
            }
        }

        return count;
    }
}
