package greetings;
// call methods from greeted


import java.sql.SQLException;
import java.util.Scanner;

public class Greets {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Scanner scanner = new Scanner(System.in);
//        for HashMap
       // Greeted greeted = new Greeted();

//        for DataBase
        Jdbc_greeting greeted = new Jdbc_greeting();


        boolean stop = true;


        while (stop) {
            System.out.println("Please enter command: ");
            String commands = scanner.nextLine(); // greet lihle venda
            String[] commandsArrays = commands.split(" ");

            if(commands.equals("exit")) {
                stop = false;
//                cheers();
                System.out.println(greeted.exit());

                return;
            }

            CommandExtractor commandExtractor = new CommandExtractor(commands);
            CommandProcessor commandProcessor = new CommandProcessor(greeted);
            commandProcessor.executor(commandExtractor);




        }

    }

//    private static void cheers() {
//        System.out.println("Cheers Man!");
//
//    }

}



