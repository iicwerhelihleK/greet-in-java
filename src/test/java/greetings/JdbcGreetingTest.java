package greetings;

import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JdbcGreetingTest {
    @Test
    public void readUsers() throws SQLException, ClassNotFoundException {
        Jdbc_greeting db = new Jdbc_greeting();

        assertEquals("{MarkHendry=1, BrockLesnar=4, BigShow=5, Odwa=1, GreatKhali=2, Kula=3, Cwerhelihle=2, TheRock=3}", db.greeted());

    }


    @Test
    public void deleteAUser() throws ClassNotFoundException, SQLException {
        Jdbc_greeting db = new Jdbc_greeting();

        db.clearUser("SteveAustin");


        assertEquals("{MarkHendry=1, BrockLesnar=4, BigShow=5, Odwa=1, GreatKhali=2, Kula=3, Cwerhelihle=2, TheRock=3}", db.greeted());
    }


}
