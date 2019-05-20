package greetings;

import org.h2.command.Command;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommandExtractorTest {

    @Test
    void getCommand() {
        CommandExtractor commandExtractor = new CommandExtractor("greet lihle1 venda");

        assertEquals("greet", commandExtractor.getCommand());
        assertEquals("lihle1", commandExtractor.getName());
        assertEquals("venda", commandExtractor.getLanguage());

    }

    @Test
    void getCommandAndName() {
        CommandExtractor commandExtractor = new CommandExtractor("greet lihle");

        assertEquals("greet", commandExtractor.getCommand());
        assertEquals("lihle", commandExtractor.getName());
        assertEquals("English", commandExtractor.getLanguage());

    }

    @Test
    void getCommandAndName2() {
        CommandExtractor commandExtractor = new CommandExtractor("greeted lihle");

        assertEquals("greeted", commandExtractor.getCommand());
        assertEquals("lihle", commandExtractor.getName());

    }

    @Test
    void getCommandAndName3() {
        CommandExtractor commandExtractor = new CommandExtractor("greeted");

        assertEquals("greeted", commandExtractor.getCommand());
        assertEquals("", commandExtractor.getName());

    }
}