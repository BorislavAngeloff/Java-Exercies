import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//Define a class Student, which holds the following information about students:
//first name, last name, age, and hometown.

//Read the list of students until you receive the "end" command.
//After that, you will receive a city name.
//Print only students which are from the given city, in the following format:
//"{firstName} {lastName} is {age} years old".

//Example

//Input:
//John Smith 15 Sofia
//Peter Ivanov 14 Plovdiv
//Linda Bridge 16 Sofia
//Simon Stone 12 Varna
//end
//Sofia

//Output:
//John Smith is 15 years old
//Linda Bridge is 16 years old

public class Students {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<Student> studentList = new ArrayList<>();

        String input = scanner.nextLine();

        while (!input.equals("end")) {
            //input = "John Smith 15 Sofia"
            String[] data = input.split(" ");
            //input.split(" ") -> ["John", "Smith", "15", "Sofia"]
            String firstName = data[0];
            String lastName = data[1];
            int age = Integer.parseInt(data[2]);
            String hometown = data[3];

            Student student = new Student(firstName, lastName, age, hometown);

            studentList.add(student);

            input = scanner.nextLine();
        }

        String enteredTown = scanner.nextLine();

        for (Student student : studentList) {
            if (student.getHometown().equals(enteredTown)) {
                System.out.printf("%s %s is %d years old%n", student.getFirstName(), student.getLastName(), student.getAge());
            }
        }

    }
}
