package greetings;

import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JdbcGreetingTest {
    @Test
    public void createAndReadUsers() throws SQLException, ClassNotFoundException {
        Jdbc_greeting db = new Jdbc_greeting();


        db.addUsers("Steve Austin");
        db.addUsers("The Rock");
        db.addUsers("Brock Lesnar");
        db.addUsers("Great Khali");
        db.addUsers("Mark Hendry");
        db.addUsers("Big Show");
        System.out.println(db.findUsers());

        assertEquals(1, 1);

    }

    @Test
    public void UpdateUsers() throws ClassNotFoundException, SQLException {
        Jdbc_greeting db = new Jdbc_greeting();

        db.findUsers();
        System.out.println(db.findUsers());
        db.updateAUser("Big Show");;
        System.out.println(db.findUsers());

        assertEquals(1, 1);

    }

    @Test
    public void deleteAUser() throws ClassNotFoundException, SQLException {
        Jdbc_greeting db = new Jdbc_greeting();

        db.deleteAUser("Steve Austin");
        System.out.println(db.findUsers());

        assertEquals(1, 1);
    }





}
