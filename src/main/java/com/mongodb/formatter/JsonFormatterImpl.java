package com.mongodb.formatter;

import org.json.JSONObject;

public class JsonFormatterImpl implements JsonFormatter {

    /**
     * Formats Json as following
     * Given
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
     * @param jsonString input json string
     * @return formatted json string
     */
    @Override
    public String format(String jsonString) {
        JSONObject jsonObject = new JSONObject(jsonString);
        JSONObject res = new JSONObject();
        recurseFormatter(jsonObject, "",res);
        return res.toString();
    }

    public void recurseFormatter(JSONObject jsonObject, String finalKey, JSONObject res) {
        for(String key: jsonObject.keySet()) {
            String curKey = finalKey.isEmpty() ? ""+ key : finalKey+"."+key;
            if(jsonObject.get(key) instanceof JSONObject ) {
                recurseFormatter((JSONObject)jsonObject.get(key), curKey, res);
            } else {
                res.put(curKey, jsonObject.get(key));
            }
        }
    }

    @Override
    public void printJson(String jsonString) {
        JSONObject obj = new JSONObject(jsonString);
        System.out.println(obj.toString(2));
    }

}
