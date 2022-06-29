package com.mongodb.formatter;

public interface JsonFormatter {
    String format(String jsonString);
    void prettyPrintJson(String jsonString);
}
