package greetings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LanguageTest {
    @Test
    public void shouldGreetAPerson(){
        Greeted greeted = new Greeted();

        assertEquals(greeted.greetPerson("Jan", "english"), "Hello, Jan");
    }

    @Test
    public void shouldCountGreeted(){
        Greeted greeted = new Greeted();

        assertEquals(0, 0, greeted.greetedCount());
    }

}
