package greetings;

import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JdbcGreetingTest {
    @Test
    public void saySomething() throws SQLException, ClassNotFoundException {
        Jdbc_greeting db = new Jdbc_greeting();

//        db.addUsers("Lihle");
//        db.addUsers("Thabang");
//        System.out.println(db.findUsers());
//        db.deleteAUser("Thabang");
        System.out.println(db.findUsers());
        db.updateUser("Lihle");
        System.out.println(db.findUsers());



        assertEquals(1, 1);

    }

}
