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

        assertEquals("{MarkHendry=3, SteveAustin=3, BrockLesnar=3, BigShow=3, GreatKhali=3, TheRock=3}", db.greeted());

    }

    @Test
    public void UpdateUsers() throws ClassNotFoundException, SQLException {
        Jdbc_greeting db = new Jdbc_greeting();

        db.greetPerson("BigShow", "English");;

        assertEquals("{MarkHendry=3, SteveAustin=3, BrockLesnar=3, BigShow=5, GreatKhali=3, TheRock=3}", db.greeted());

    }

    @Test
    public void deleteAUser() throws ClassNotFoundException, SQLException {
        Jdbc_greeting db = new Jdbc_greeting();

        db.clearUser("SteveAustin");


        assertEquals("{MarkHendry=3, BrockLesnar=3, BigShow=5, GreatKhali=3, TheRock=3}", db.greeted());
    }





}
