package greetings;

import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CommandProcessorTest {
    Jdbc_greeting greeted = new Jdbc_greeting();

    @Test
    void shouldGreetPerson() throws SQLException {
        GreetedHash greetedHash = new Jdbc_greeting();
        CommandProcessor commandProcessor = new CommandProcessor(greetedHash);
        CommandExtractor commandExtractor = new CommandExtractor("greet Lihle Venda");
        assertEquals("Ndaa, Lihle", commandProcessor.executor(commandExtractor));
    }

    @Test
    void shouldShowReturnHowManyTimesGreeted() throws SQLException {
        GreetedHash greetedHash = new Jdbc_greeting();
        Jdbc_greeting greeted = new Jdbc_greeting();
        CommandProcessor commandProcessor = new CommandProcessor(greetedHash);
        CommandExtractor commandExtractor = new CommandExtractor("greeted Lihle");
        assertEquals(greeted.greetedUser("Lihle"), commandProcessor.executor(commandExtractor));

    }

    @Test
    void shouldShowReturnCounter() throws SQLException {
        GreetedHash greetedHash = new Jdbc_greeting();
        CommandProcessor commandProcessor = new CommandProcessor(greetedHash);
        CommandExtractor commandExtractor = new CommandExtractor("counter");
        assertEquals(greeted.greetedCount(), commandProcessor.executor(commandExtractor));

    }


    @Test
    void shouldExitApp() throws SQLException {
        GreetedHash greetedHash = new Jdbc_greeting();
        CommandProcessor commandProcessor = new CommandProcessor(greetedHash);
        CommandExtractor commandExtractor = new CommandExtractor("exit");
        assertEquals("Goodbye!", commandProcessor.executor(commandExtractor));

    }





}
