package greetings;
// call methods from greeted


import java.sql.SQLException;
import java.util.Scanner;

public class Greets {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Scanner scanner = new Scanner(System.in);
//        for HashMap
//        GreetedHash greetedHash = new Greeted();

//        for DataBase
        GreetedHash greetedHash = new Jdbc_greeting();


        boolean stop = true;


        while (stop) {
            System.out.println("Please enter command: ");
            String commands = scanner.nextLine(); // greet lihle venda
            CommandExtractor commandExtractor = new CommandExtractor(commands);
            CommandProcessor commandProcessor = new CommandProcessor(greetedHash);

            if(commandProcessor.executor(commandExtractor).equals("Goodbye!")) {
                System.out.println(commandProcessor.executor(commandExtractor));
                System.exit(0);
            }

            System.out.println(commandProcessor.executor(commandExtractor));
        }

    }


}



