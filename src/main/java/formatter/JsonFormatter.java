package formatter;

public interface JsonFormatter {
    /**
     * Formats Json
     * @param jsonString
     * @return
     */
    String format(String jsonString);
    void printJson(String jsonString);
}
