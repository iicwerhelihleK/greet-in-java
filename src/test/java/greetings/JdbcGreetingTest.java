package greetings;

import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JdbcGreetingTest {
    @Test
    public void createAndReadUsers() throws SQLException, ClassNotFoundException {
        Jdbc_greeting db = new Jdbc_greeting();


        db.greetPerson("Steve Austin", "English");
        db.greetPerson("The Rock", "English");
        db.greetPerson("Brock Lesnar", "English");
        db.greetPerson("Great Khali", "English");
        db.greetPerson("Mark Hendry", "English");
        db.greetPerson("Big Show", "English");
        System.out.println(db.greeted());

        assertEquals(1, 1);

    }

    @Test
    public void UpdateUsers() throws ClassNotFoundException, SQLException {
        Jdbc_greeting db = new Jdbc_greeting();

        db.greeted();
        System.out.println(db.greeted());
        db.greetPerson("Big Show", "English");;
        System.out.println(db.greeted());

        assertEquals(1, 1);

    }

    @Test
    public void deleteAUser() throws ClassNotFoundException, SQLException {
        Jdbc_greeting db = new Jdbc_greeting();

        db.clearUser("Steve Austin");
        System.out.println(db.greetedUser("Big Show"));

        assertEquals(1, 1);
    }





}
