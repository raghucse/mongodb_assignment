package com.mongodb.formatter;

import org.json.JSONException;
import org.json.JSONObject;

public class JsonFormatterImpl implements JsonFormatter {
    @Override
    public String format(String jsonString) throws JSONException {
        JSONObject jsonObject = new JSONObject(jsonString);
        JSONObject res = new JSONObject();
        recurseFormatter(jsonObject, "",res);
        return res.toString();
    }

    private void recurseFormatter(JSONObject jsonObject, String finalKey, JSONObject res) {
        for(String key: jsonObject.keySet()) {
            String curKey = finalKey.isEmpty() ?  key : finalKey+"."+key;
            if(jsonObject.get(key) instanceof JSONObject ) {
                recurseFormatter((JSONObject)jsonObject.get(key), curKey, res);
            } else {
                res.put(curKey, jsonObject.get(key));
            }
        }
    }

    @Override
    public void prettyPrintJson(String jsonString) {
        JSONObject obj = new JSONObject(jsonString);
        System.out.println(obj.toString(2));
    }
}
