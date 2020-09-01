import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MyTests {

    @Test
    public void testDirectGreeting() {
        MyClass chinese = new MyClass("Ni Hao!");
        MyClass spanish = new MyClass("Hola!");

        // assert statements
        assertEquals("Ni Hao!", chinese.getGreeting());
        assertEquals("Hola!", spanish.getGreeting());
    }

    @Test
    public void testStdoutGreeting() throws IOException {
        try (ByteArrayOutputStream bos = new ByteArrayOutputStream()) {
            PrintStream originalOut = System.out;
            System.setOut(new PrintStream(bos));

            // Call main()
            MyMain.main(null);

            // assert statements
            assertEquals("Hello World!\n", bos.toString());

            // undo the binding in System
            System.setOut(originalOut);
        }
    }
}
