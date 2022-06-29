import com.mongodb.formatter.JsonFormatter;
import com.mongodb.formatter.JsonFormatterImpl;
import org.json.JSONException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class JsonFormatterTest {

    static JsonFormatter jsonFormatter;

    @BeforeAll
    static void setUp() {
        jsonFormatter = new JsonFormatterImpl();
    }

    @Test
    void testJsonOneLevel() {
        String testJson = "{\n" +
                "\t\"a\": 1,\n" +
                "\t\"b\": true,\n" +
                "\t\"c\": 5.5,\n" +
                "\t\"f\": \"value dd\",\n" +
                "\t\"f%\": false\n" +
                "}\n";
        String expected = "{\"a\":1,\"b\":true,\"c\":5.5,\"f\":\"value dd\",\"f%\":false}";
        assertEquals(expected, jsonFormatter.format(testJson));
    }

    @Test
    void testJsonTwoLevel() {
        String testJson = "{\n" +
                "\t\"a\": 1,\n" +
                "\t\"b\": true,\n" +
                "\t\"c\": {\n" +
                "\t\t\"d\": 3,\n" +
                "\t\t\"e\": \"test\"\n" +
                "\t}\n" +
                "}";
        String expected = "{\"a\":1,\"b\":true,\"c.d\":3,\"c.e\":\"test\"}";
        assertEquals(expected, jsonFormatter.format(testJson));
    }

    @Test
    void testJsonThreeLevel() {
        String testJson = "{\n" +
                "\t\"a\": 1,\n" +
                "\t\"b\": true,\n" +
                "\t\"c\": {\n" +
                "\t\t\"d\": 3,\n" +
                "\t\t\"e\": \"test\",\n" +
                "\t\t\"c\": {\n" +
                "\t\t\t\"c\" : 5\n" +
                "\t\t}\n" +
                "\t}\n" +
                "}\n";
        String expected = "{\"a\":1,\"b\":true,\"c.c.c\":5,\"c.d\":3,\"c.e\":\"test\"}";
        assertEquals(expected, jsonFormatter.format(testJson));
    }

    @Test
    void testJsonInvalidJson() {
        String testJson = "\n" +
                "\t\"a\": 1,\n" +
                "\t\"b\": true,\n" +
                "\t\"c\": {\n" +
                "\t\t\"d\": 3,\n" +
                "\t\t\"e\": \"test\",\n" +
                "\t\t\"c\": {\n" +
                "\t\t\t\"c\" : 5\n" +
                "\t\t}\n" +
                "\t}\n" +
                "}\n";
        assertThrows(JSONException.class, () -> jsonFormatter.format(testJson));
    }
}
