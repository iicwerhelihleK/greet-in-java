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
            if(commands.equals("exit")) {
                stop = false;
//                Cheers();
                return;
            }

            String[] commandArray = commands.split(" ");

            if(commandArray[0].equals("greet")) {
                //check if name and language are provided
                String language = "English", name = "";

                if(commandArray.length == 2) {
                    //no language
                    name = commandArray[1];

                } else if(commandArray.length == 3) {
                    //language provided
                    language = commandArray[2];
                    name = commandArray[1];
                }

                System.out.println(greeted.greetPerson(name, language));

            } else if(commandArray[0].equals("greeted")) {
                System.out.println(greeted.greeted());

            } else {
                System.out.println("Invalid command.");
            }


        }


//
//        System.out.print("Please enter your name: ");
//        String name = greet.nextLine();
//        System.out.print("Please enter language: ");
//        String language = greet.nextLine();




    }


}
