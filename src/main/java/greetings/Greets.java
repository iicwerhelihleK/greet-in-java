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
//                stop = false;
//                cheers();
//                return;
                System.out.println(greeted.exit());
            }
            if(commands.equals("help")){
                StringBuilder help = new StringBuilder();

                help.append("greet + name will greet a person in default language. \n");
                help.append("greet + name + language will greet a person with specified language. \n");
                help.append("greeted will print out the users that you have greeted. \n");
                help.append("greetedUser will print out the specified person that has been greeted \n");
                help.append("greetedCount will print all the people you have greeted \n");
                help.append("clear removes all users greeted \n");

                System.out.println(help);

            } else if(commandsArrays[0].equals("clear")){
                if(commandsArrays.length == 2) {
                    String name = commandsArrays[1];
                    greeted.clearUser(name);
                } else {
                    greeted.clearsAll();
                }

            } else if(commandsArrays[0].equals("greet")) {
                //check if name and language are provided
                String language = "English", name = "";

                if(commandsArrays.length == 2) {
                    //no language
                    name = commandsArrays[1];

                } else if(commandsArrays.length == 3) {
                    //language provided
                    language = commandsArrays[2];
                    name = commandsArrays[1];
                }

                System.out.println(greeted.greetPerson(name, language));

            } else if(commandsArrays[0].equals("greeted")) {
                if(commandsArrays.length == 2) {
                    String name = commandsArrays[1];
                    System.out.printf("%s has been greeted %d time(s)", name, greeted.greetedUser(name));
                    System.out.println();
                } else {
                    System.out.println(greeted.greeted());
                }

            }
            else if(commandsArrays[0].equals("counter")){
                System.out.println(greeted.greetedCount());

            }
            else {

                System.out.println("Invalid command.");

            }


        }

    }

    private static void cheers() {
        System.out.println("Cheers Man!");

    }

}



