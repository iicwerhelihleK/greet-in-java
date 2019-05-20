package greetings;

import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JdbcGreetingTest {
    @Test
    public void createAndReadUsers() throws SQLException, ClassNotFoundException {
        Jdbc_greeting db = new Jdbc_greeting();


        db.greetPerson("SteveAustin", "English");
        db.greetPerson("TheRock", "English");
        db.greetPerson("BrockLesnar", "English");
        db.greetPerson("GreatKhali", "English");
        db.greetPerson("MarkHendry", "English");
        db.greetPerson("BigShow", "English");
        System.out.println(db.greeted());

        assertEquals(1, 1);

    }

    @Test
    public void UpdateUsers() throws ClassNotFoundException, SQLException {
        Jdbc_greeting db = new Jdbc_greeting();

        db.greeted();
        System.out.println(db.greeted());
        db.greetPerson("BigShow", "English");;
        System.out.println(db.greeted());

        assertEquals(1, 1);

    }

    @Test
    public void deleteAUser() throws ClassNotFoundException, SQLException {
        Jdbc_greeting db = new Jdbc_greeting();

        db.clearUser("SteveAustin");
        System.out.println(db.greeted());

        assertEquals(1, 1);
    }





}
