package com.mongodb.formatter;

public interface JsonFormatter {
    String format(String jsonString);
    void printJson(String jsonString);
}
