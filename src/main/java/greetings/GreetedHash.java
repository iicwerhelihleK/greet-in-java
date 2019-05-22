package greetings;

import java.sql.SQLException;
import java.util.HashMap;

public interface GreetedHash {
    String greetPerson(String name, String language) throws SQLException;
    String greeted() throws SQLException;
    String greetedCount() throws SQLException;
    String greetedUser(String name) throws SQLException;
    String clearUser(String name) throws SQLException;
    String clearsAll() throws SQLException;
    public String exit();

}



