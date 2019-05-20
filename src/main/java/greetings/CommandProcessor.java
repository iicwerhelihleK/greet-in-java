package greetings;

import java.sql.SQLException;

public class CommandProcessor {
    private final GreetedHash greeted;

    public  CommandProcessor(GreetedHash greetedHash){
        this.greeted = greetedHash;
//        database here

    }

//
//   method executor that takes in a commandExtractor
    public String executor(CommandExtractor commandExtractor) throws SQLException {
        String command = commandExtractor.getCommand();
        String name = commandExtractor.getName();
        String language = commandExtractor.getLanguage();

        if(command.equals("help")){
            StringBuilder help = new StringBuilder();

            help.append("greet + name will greet a person in default language. \n");
            help.append("greet + name + language will greet a person with specified language. \n");
            help.append("greeted will print out the users that you have greeted. \n");
            help.append("greeted + name will print out the specified person that has been greeted and how many times \n");
            help.append("counter will print all the people you have greeted in a number \n");
            help.append("clear removes all users greeted \n");
            help.append("exit gets you out of the application \n");

            System.out.println(help);

        } else if(command.equals("clear")){
            if(!commandExtractor.getName().isEmpty()) {
                greeted.clearUser(name);

            } else {
                greeted.clearsAll();
            }

        } else if(command.equals("greet")) {
            if(!commandExtractor.getName().isEmpty()) {
                System.out.println(greeted.greetPerson(name, language));
            }
            //check if name and language are provided
//            String language = "English", name = "";
//
//            if(commandsArrays.length == 2) {
//                //no language
//                name = commandsArrays[1];
//
//            } else if(commandsArrays.length == 3) {
//                //language provided
////                language = commandsArrays[2];
////                name = commandsArrays[1];
//            }



//        } else if(commandsArrays[0].equals("greeted")) {
//            if(commandsArrays.length == 2) {
//                String name = commandsArrays[1];
//                System.out.printf("%s has been greeted %d time(s)", name, greeted.greetedUser(name).get(name));
//                System.out.println();
//            } else {
//                System.out.println(greeted.greeted());
//            }
//
//        }
//        else if(commandsArrays[0].equals("counter")){
//            System.out.println(greeted.greetedCount());
//
//        }
//        else {
//
//            System.out.println("Invalid command.");
//
        }
        return "";



    }
}


