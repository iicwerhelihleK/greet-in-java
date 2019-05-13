package greetings;
// call methods from greeted


import java.util.Scanner;

public class Greets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Greeted greeted = new Greeted();

        boolean stop = true;


        while (stop) {
            System.out.println("Please enter command: ");
            String commands = scanner.nextLine(); // greet lihle venda
            String[] commandsArrays = commands.split(" ");

            if(commands.equals("exit")) {
                stop = false;
                cheers();
                return;
            }
            if(commands.equals("help")){
                String help = "greet\n" + "greeted\n" + "counter\n" + "clear\n" + "are all valid commands";
                System.out.println(help);

            } else if(commandsArrays[0].equals("clear")){
                if(commandsArrays.length == 2) {
                    String name = commandsArrays[1];
                    greeted.clearUser(name);
                } else {
                    greeted.clearance();
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
                    System.out.printf("%s hasgree been greeted %d time(s)", name, greeted.greetedUser(name));
                    System.out.println();
                } else {
                    System.out.println(greeted.greeted());
                }

            } else {

                System.out.println("Invalid command.");

            }


        }



    }

    private static void cheers() {
        System.out.println("Cheers Man!");

    }

}



