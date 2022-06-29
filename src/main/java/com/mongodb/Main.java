package com.mongodb;

import com.mongodb.formatter.JsonFormatter;
import com.mongodb.formatter.JsonFormatterImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

public class Main {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, Charset.defaultCharset()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        JsonFormatter jsonFormatter = new JsonFormatterImpl();
        jsonFormatter.printJson(jsonFormatter.format(sb.toString()));
    }
}
