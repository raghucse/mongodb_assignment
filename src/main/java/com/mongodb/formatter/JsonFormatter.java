package com.mongodb.formatter;

public interface JsonFormatter {
    /**
     * Takes a JSON string as input and outputs a flattened version of the JSON string,
     * with keys as the path to every terminal value in the JSON structure.
     * Example : Given
     * {
     *      "a": 1,
     *      "b": true,
     *      "c": {
     *          "d": 3,
     *          "e": "test"
     *      }
     * }
     *
     * Output
     * {
     *      "a": 1,
     *      "b": true,
     *      "c.d": 3,
     *      "c.e": "test"
     * }
     *
     * @param jsonString input json string
     * @return formatted json string
     */
    String format(String jsonString);

    /**
     *  Pretty print given json string
     * @param jsonString json string that needs to be pretty printed
     */
    void prettyPrintJson(String jsonString);
}
