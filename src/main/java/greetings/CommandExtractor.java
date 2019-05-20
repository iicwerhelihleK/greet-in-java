package greetings;

import java.util.ArrayList;

public class CommandExtractor {
    private final String command;
    private final String name;
    private final String language;

    public CommandExtractor(String CommandInput) {
        String[] commandsArrays = CommandInput.split(" ");

        this.command = commandsArrays[0];

        if(commandsArrays.length >= 2){
            this.name = commandsArrays[1];
        }else{
            this.name = "";
        }
        if (commandsArrays.length == 3){
            this.language = commandsArrays[2];
        } else {
            this.language = "English";
        }


    }

    public String getCommand() {
        return command;
    }

    public String getName() {
        return name;
    }

    public String getLanguage() {
        return language;
    }


}

