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

    }


    public HashMap<String, Integer> greeted() {
        return world;
    }

    public int greetedCount() {
        return world.size(); //size of hashmap
    }

    public int greetedUser(String name) {
        if(world.containsKey(name)) {
            return world.get(name); //{jan=2}
        } else {
            return 0;
        }
    }

    public void clearance(){
//      removes all the users
        world.clear();
    }

    public void clearUser(String name){
//      removes the user specified
        world.remove(name);
    }



}
