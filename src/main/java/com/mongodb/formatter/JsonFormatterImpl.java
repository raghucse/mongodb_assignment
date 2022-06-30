package com.mongodb.formatter;

import org.json.JSONException;
import org.json.JSONObject;

public class JsonFormatterImpl implements JsonFormatter {
    final String KEY_SEPARATOR = ".";

    @Override
    public String format(String jsonString) throws JSONException {
        JSONObject jsonObject = new JSONObject(jsonString);
        JSONObject result = new JSONObject();
        recurseFormatter(jsonObject, "",result);
        return result.toString();
    }

    private void recurseFormatter(JSONObject jsonObject, String finalKey, JSONObject result) {
        for(String key: jsonObject.keySet()) {
            String curKey = finalKey.isEmpty() ?  key : finalKey+KEY_SEPARATOR+key;
            if(jsonObject.get(key) instanceof JSONObject ) {
                recurseFormatter((JSONObject)jsonObject.get(key), curKey, result);
            } else {
                result.put(curKey, jsonObject.get(key));
            }
        }
    }

    @Override
    public void prettyPrintJson(String jsonString) {
        final int INDENT_FACTOR = 2;
        JSONObject jsonObject = new JSONObject(jsonString);
        System.out.println(jsonObject.toString(INDENT_FACTOR));
    }
}
