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
    public void shouldGreetWithDef(){
        Greeted greeted = new Greeted();
        Greeted greetedTwice = new Greeted();
        Greeted greetedTrice = new Greeted();

        assertEquals(greeted.greetPerson("Jan", "English"), "Hello, Jan");


        assertEquals(greeted.greetedCount(), 1);
    }

}
