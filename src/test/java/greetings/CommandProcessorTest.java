package greetings;

import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CommandProcessorTest {

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
        CommandProcessor commandProcessor = new CommandProcessor(greetedHash);
        CommandExtractor commandExtractor = new CommandExtractor("greeted Lihle");
        assertEquals("Lihle has been greeted 1 time(s) ", commandProcessor.executor(commandExtractor));

    }

    @Test
    void shouldShowReturnCounter() throws SQLException {
        GreetedHash greetedHash = new Jdbc_greeting();
        CommandProcessor commandProcessor = new CommandProcessor(greetedHash);
        CommandExtractor commandExtractor = new CommandExtractor("counter");
        assertEquals("names greeted: 9", commandProcessor.executor(commandExtractor));

    }


    @Test
    void shouldExitApp() throws SQLException {
        GreetedHash greetedHash = new Jdbc_greeting();
        CommandProcessor commandProcessor = new CommandProcessor(greetedHash);
        CommandExtractor commandExtractor = new CommandExtractor("exit");
        assertEquals("Goodbye!", commandProcessor.executor(commandExtractor));

    }





}
