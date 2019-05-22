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
            String[] commandsArrays = commands.split(" ");

            if(commands.equals("exit")) {
                stop = false;
//                cheers();
                System.out.println(greetedHash.exit());

                return;
            }

            CommandExtractor commandExtractor = new CommandExtractor(commands);
            CommandProcessor commandProcessor = new CommandProcessor(greetedHash);
            System.out.println(commandProcessor.executor(commandExtractor));




        }

    }

//    private static void cheers() {
//        System.out.println("Cheers Man!");
//
//    }

}



