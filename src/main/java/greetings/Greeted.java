package greetings;
// declare methods for greets

import java.util.HashMap;

public class Greeted {

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

//        if(language.equals("english")) {
//            return "Hello, " + name;
//        }
//        else if(language.equals("afrikaans")){
//            return "Hallo, " + name;
//        } else {
//            return "Molo, " + name;
//        }
    }

    public HashMap<String, Integer> greeted() {
        return world;
    }

    public int greetedCount() {
        return world.size(); //size of hashmap
    }
}
