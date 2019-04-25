package greetings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GreetTest {
    @Test
    public void shouldGreet(){
        Greeted greeted = new Greeted();

        assertEquals(greeted.greetPerson("Jan", "xhosa"), "Hello, Jan");
    }

    @Test
    public void shouldGreetWithDef(){
        Greeted greeted = new Greeted();


        assertEquals(greeted.greetPerson("Jan", "English"), "Hello, Jan");


        assertEquals(greeted.greetedCount(), 1);
    }

}
