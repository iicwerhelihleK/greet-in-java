package greetings;

import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JdbcGreetingTest {
    @Test
    public void readUsers() throws SQLException, ClassNotFoundException {
        Jdbc_greeting db = new Jdbc_greeting();
         db.clearsAll();
         db.greetPerson("Lunga", "Xhosa");
        assertEquals("Lunga", "Lunga", db.greetedUser("Lunga"));

    }


    @Test
    public void deleteAUser() throws ClassNotFoundException, SQLException {
        Jdbc_greeting db = new Jdbc_greeting();
        db.clearsAll();
        db.clearUser("SteveAustin");
        assertEquals("{}", db.greeted());
    }


}
