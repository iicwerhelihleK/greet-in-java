package greetings;

import java.sql.SQLException;
import java.util.HashMap;

public interface GreetedHash {
    String greetPerson(String name, String language) throws SQLException;
    HashMap<String, Integer> greeted() throws SQLException;
    int greetedCount() throws SQLException;
    HashMap<String, Integer> greetedUser(String name) throws SQLException;
    String clearUser(String name) throws SQLException;
    String clearsAll() throws SQLException;
    public String exit();

}



