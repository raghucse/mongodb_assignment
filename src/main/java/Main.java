import formatter.JsonFormatter;
import formatter.JsonFormatterImpl;

public class Main {
    public static void main(String[] args) {
        String jsonStr = "{\n" +
                "\"a\": 1,\n" +
                "\"b\": true,\n" +
                "\"c\": {\n" +
                "\"d\": 3,\n" +
                "\"e\": \"test\"\n" +
                "}\n" +
                "}";

        JsonFormatter jsonFormatter = new JsonFormatterImpl();
        jsonFormatter.printJson(jsonFormatter.format(jsonStr));
    }
}
