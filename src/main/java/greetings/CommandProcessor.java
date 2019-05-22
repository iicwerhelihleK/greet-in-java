package greetings;

import java.sql.SQLException;

public class CommandProcessor {
    private final GreetedHash greeted;

    public  CommandProcessor(GreetedHash greetedHash){
        this.greeted = greetedHash;
    }


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

            return  help.toString();

        } else if(command.equals("clear")){
            if(!commandExtractor.getName().isEmpty()) {
                return greeted.clearUser(name);

            } else {
                return greeted.clearsAll();
            }

        } else if(command.equals("greet")) {
            if(!commandExtractor.getName().isEmpty()) {
                return greeted.greetPerson(name, language);
            }


        } else if(command.equals("greeted")) {
            if(!name.equals("")) {
                return greeted.greetedUser(name);

            } else {
                return greeted.greeted();
            }

        }
        else if(command.equals("counter")){
            return greeted.greetedCount();

        }

        return  "Invalid command." ;
    }
}


