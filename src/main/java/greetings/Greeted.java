package greetings;
// declare methods for greets

import java.util.HashMap;

public class Greeted implements GreetedHash {

//    add HashMap list here: <str, int> ==> {siya: 2}

    HashMap<String, Integer> world = new HashMap<String, Integer>();




    public String greetPerson(String name, String language) {
        //add to HashMap, increment user count

        if(world.containsKey(name)) {
            world.put(name, world.get(name) + 1);
        } else {
            world.put(name, 1);
        }

        try {
            return (Languages.valueOf(language).getLanguage() + name);
        } catch (IllegalArgumentException e) {
            return (Languages.valueOf("English").getLanguage() + name);
        }

    }


    public HashMap<String, Integer> greeted() {
        return world;
    }

    public int greetedCount() {
        return world.size(); //size of hashmap
    }

    public HashMap<String, Integer> greetedUser(String name) {
        HashMap<String, Integer> user = new HashMap<>();
        if(world.containsKey(name)){
            user.put(name, world.get(name));
        }

        return user;
    }



    public String clearsAll(){
//      removes all the users
        world.clear();
        return ("All users has been removed");
    }


    public String clearUser(String name){
//      removes the user specified
        world.remove(name);
        return (name + "has been removed");
    }

    public StringBuilder helpInfo(){
        StringBuilder help = new StringBuilder();

        help.append("greet + name will greet a person in default language. \n");
        help.append("greet + name + language will greet a person with specified language. \n");
        help.append("greeted will print out the users that you have greeted. \n");
        help.append("greetedUser will print out the specified person that has been greeted \n");
        help.append("greetedCount will print all the people you have greeted \n");
        help.append("clear removes all users greeted \n");

        return help;
    }

    public String exit(){
        System.exit(1);

        return ("Goodbye!");

    }



}